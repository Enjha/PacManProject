package pacman;

import apiUser.SetupScene;
import engines.UI.ClassicControlEngine;
import engines.UI.ClassicControlManager;
import engines.UI.ControlManager;
import engines.UI.KeyBoardControl;
import engines.graphic.ClassicConvertSceneToGraphic;
import engines.graphic.ClassicGraphicEngine;
import engines.graphic.GraphicEngine;
import engines.graphic.ImageViewEntities;
import engines.kernel.ClassicKernelEngine;
import engines.kernel.KernelEngine;
import engines.physic.ClassicPhysicEngine;
import engines.physic.Collision;
import engines.sound.ClassicSound;
import engines.sound.ClassicSoundEngine;
import engines.sound.ClassicSoundManager;
import engines.sound.SoundManager;
import gameplay.Character;
import gameplay.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pacman.scene.*;
import scene.SceneCase;
import scene.SceneElement;
import scene.SceneGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamePacMan implements Game {

    private List<Entity> entities;
    private SceneGame sceneGame;
    private final LabyrinthGenerator labyrinthGenerator;
    private KernelEngine kernelEngine;
    private List<Thread> threadEntities = new ArrayList<>();
    private boolean stateThread = false;
    private Score score;
    private Life life;
    private int nbFruits;
    private TeamManager teamManager;

    public GamePacMan(LabyrinthGenerator labyrinthGenerator, Score score, Life life, int nbFruit, TeamManager teamManager) {
        this.labyrinthGenerator = labyrinthGenerator;
        this.score = score;
        this.life = life;
        this.nbFruits = nbFruit;
        this.teamManager = teamManager;
        teamManager.addTeam(new ClassicTeam("GHOST", false));
        teamManager.addTeam(new ClassicTeam("PACMAN", false));
    }

    public void createEntity() {
        entities = labyrinthGenerator.generateEntity(sceneGame, this);
        for (Entity entity : entities) {
            if (entity instanceof Pacman) {
                threadEntities.add(new ThreadPacman((Pacman) entity, this));
            }
            if (entity instanceof Ghost) {
                threadEntities.add(new ThreadGhost((Ghost) entity, this));
            }
        }
    }

    public void startThreadEntity() {
        if (!stateThread) {
            for (Thread thread : threadEntities) {
                ThreadEntity threadEntity = (ThreadEntity) thread;
                threadEntity.setImageViewEntities(kernelEngine.getImageViewEntities(threadEntity.getEntity()));
                thread.start();
            }
            kernelEngine.playFirstSound("game_start.wav");
            stateThread = true;
        }
    }

    public void generateSceneGame() {
        sceneGame = labyrinthGenerator.generateLabyrinth();
    }

    public void startEngine(Stage stage) {
        kernelEngine = new ClassicKernelEngine(this);
        kernelEngine.setPhysicEngine(new ClassicPhysicEngine());
        startSoundEngine();
        startGraphicEngine(stage);
        startControlEngine();
    }

    private void startSoundEngine() {
        SoundManager soundManager = new ClassicSoundManager();

        File soundFolder = new File("ressources/sounds/PacMan");
        File[] files = soundFolder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(soundFolder.getPath() + "/" + file.getName()).toURI().toString()));
                    mediaPlayer.setOnError(() -> System.out.println("media error" + mediaPlayer.getError().toString()));
                    soundManager.addSound(new ClassicSound(mediaPlayer, file.getName()));
                }
            }
            kernelEngine.setSoundEngine(new ClassicSoundEngine(soundManager));
        } else {
            System.out.println("error folder null");
        }
    }

    private void startGraphicEngine(Stage stage) {
        GraphicEngine graphicEngine = new ClassicGraphicEngine(stage, kernelEngine, new ClassicConvertSceneToGraphic());
        graphicEngine.setFxWindow(1200, 800, "Pac-Man");
        graphicEngine.setCurrentScene(new SceneMainMenu(stage, graphicEngine));
        kernelEngine.setGraphicEngine(graphicEngine);
    }

    private void startControlEngine() {
        ControlManager controlManager = new ClassicControlManager();

        try {
            String pathRessoucesControls = "ressources/controls/PacMan/commands.txt";
            File commandFile = new File(pathRessoucesControls);

            BufferedReader buffer = new BufferedReader(new FileReader(commandFile));
            String line;
            Entity entity = null;
            while ((line = buffer.readLine()) != null) {
                String[] lineSplit = line.split(" ");
                if (lineSplit[0].equals("!!") && lineSplit[2].equals("!!")) {
                    entity = getEntity(lineSplit[1]);
                    if (entity == null) {
                        System.out.println("Error : entity null 0");
                        System.exit(-1);
                    }

                } else {
                    if (entity == null) {
                        System.out.println("Error : entity null");
                        System.exit(-1);
                    }

                    Direction direction;
                    switch (lineSplit[0]) {
                        case "NORTH":
                            direction = Direction.North;
                            break;
                        case "SOUTH":
                            direction = Direction.South;
                            break;
                        case "WEST":
                            direction = Direction.West;
                            break;
                        case "EAST":
                            direction = Direction.East;
                            break;
                        default:
                            direction = Direction.Stop;
                    }
                    controlManager.addControl(new KeyBoardControl(lineSplit[1], direction, entity));
                }
            }

            kernelEngine.setControlEngine(new ClassicControlEngine(controlManager, kernelEngine));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private Entity getEntity(String entityName) {
        for (Entity entity : entities) {
            if (entity.getEntityName().equals(entityName)) {
                return entity;
            }
        }
        return null;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public SceneGame getSceneGame() {
        return sceneGame;
    }

    public void treatmentCollision(Movement movement, Collision collision) {
        if (collision != null) {

            if (collision.getSecondObjectCollision() instanceof SceneElement) {
                getThreadEntity(movement.getEntity()).setCollision(collision);
                if (movement.getEntity().isCharacter()) {
                    ((Character) movement.getEntity()).setDirection(Direction.Stop);
                }
            } else {
                if (collision.getSecondObjectCollision() instanceof Entity) {
                    treatmentCollisionEntity(movement, collision);
                }
            }
        } else {
            treatmentCollisionMoveEntity(movement, null);
        }
    }

    private void treatmentCollisionEntity(Movement movement, Collision collision) {
        if (collision.getSecondObjectCollision() instanceof NormalFruit) {
            score.addScore(10);
            treatmentCollisionMoveEntity(movement, collision);
            kernelEngine.playOneSound("eat_fruit.wav");
            System.out.println(nbFruits);
            if(nbFruits>1) nbFruits-=1;
            else{
                System.out.println("gagné !");
            }
        } else if (collision.getSecondObjectCollision() instanceof PacgumFruit) {
            score.addScore(50);
            treatmentCollisionMoveEntity(movement, collision);
            kernelEngine.playOneSound("eat_fruit.wav");
            if(nbFruits>1) nbFruits-=1;
            else{
                System.out.println("gagné !");
            }
        } else if (collision.getSecondObjectCollision() instanceof Ghost) {
            getThreadEntity(movement.getEntity()).setCollision(collision);
            treatmentCollisionMoveEntity(movement, collision);
        }
    }

    private void treatmentCollisionMoveEntity(Movement movement, Collision collision) {
        getThreadEntity(movement.getEntity()).setCollision(collision);
        SceneCase newSceneCase = getNewSceneCase(movement.getDirection(), movement.getEntity());

        if (newSceneCase != null) {
            sceneGame.getCase(movement.getEntity().getPosition().getX(), movement.getEntity().getPosition().getY()).removeCaseContent(movement.getEntity());
            newSceneCase.addCaseContent(movement.getEntity());
            if (collision != null) {
                if (collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit) {
                    newSceneCase.removeCaseContent(collision.getSecondObjectCollision());
                } else if (collision.getSecondObjectCollision() instanceof Ghost) {
                   /* Pacman pacman = (Pacman) collision.getFirstObjectCollision();
                    pacman.setDirection(Direction.Stop);
                    pacman.setIsAlive(false);
                    kernelEngine.playOneSound("siren_1.wav");*/
                    System.out.println("TESTETSETSETTSE");
                }

            } else {
                if (movement.getEntity().isCharacter()) {
                    ((Character) movement.getEntity()).setDirection(movement.getDirection());
                }
            }
            movement.getEntity().setPosition(newSceneCase);
            kernelEngine.updateSceneGame(movement.getEntity());
        } else {
            System.err.println("error : new scene case null");
            System.exit(-1);
        }
    }

    private SceneCase getNewSceneCase(Direction direction, Entity entity) {
        switch (direction) {
            case North:
                return sceneGame.getCase(entity.getPosition().getX(), new MovementNorth(entity).nextPosition()[1]);
            case South:
                return sceneGame.getCase(entity.getPosition().getX(), new MovementSouth(entity).nextPosition()[1]);
            case East:
                return sceneGame.getCase(new MovementEast(entity).nextPosition()[0], entity.getPosition().getY());
            case West:
                return sceneGame.getCase(new MovementWest(entity).nextPosition()[0], entity.getPosition().getY());
            default:
                return null;
        }
    }

    public void updateSceneGame(Movement movement) {
        kernelEngine.updateSceneGame(movement.getEntity());
    }

    public List<Thread> getThreadEntities() {
        return threadEntities;
    }

    public ThreadEntity getThreadEntity(Entity entity) {
        for (Thread thread : threadEntities) {
            if (((ThreadEntity) thread).getEntity() == entity) {
                return (ThreadEntity) thread;
            }
        }
        return null;
    }

    public void treatmentCollisionGame(Movement movement) {
        kernelEngine.treatmentCollisionGame(movement);
    }

    public ImageViewEntities getImageViewEntity(Entity entity) {
        return kernelEngine.getImageViewEntities(entity);
    }

    public Score getScore() {
        return this.score;
    }

    public Life getLife() {
        return this.life;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }
}
