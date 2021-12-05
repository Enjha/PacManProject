package pacman;

import engines.IA.IAPacman;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import pacman.animations.PacManAnimation;
import pacman.scene.LabyrinthGenerator;
import pacman.scene.SceneMainMenu;
import scene.SceneCase;
import scene.SceneElement;
import scene.SceneGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The game of Pac-Man
 */
public class GamePacMan implements Game {

    /**
     * The entities of the game Pac-Man
     */
    private List<Entity> entities;

    /**
     * The information stock in the labyrinth
     */
    private SceneGame sceneGame;

    /**
     * The labyrinth generator
     */
    private final LabyrinthGenerator labyrinthGenerator;

    /**
     * The kernel engine used
     */
    private KernelEngine kernelEngine;

    /**
     * The entities thread
     */
    private List<Thread> threadEntities = new ArrayList<>();

    /**
     * The entities thread state, by default its false
     */
    private boolean stateThread = false;

    /**
     * The score's information of the game Pac-Man
     */
    private Score score;

    /**
     * The life's information of the game Pac-Man
     */
    private Life life;
    /**
     * The GameOverPane
     */
    private GameOver gameOver;
    /**
     * The number of fruit total of the game Pac-Man
     */
    private int nbFruits;

    /**
     * The team manager used of the game Pac-man
     */
    private TeamManager teamManager;

    //etst

    /**
     * <b>Constructor of GamePacMan</b>
     *
     * @param labyrinthGenerator a labyrinth generator
     * @param score              a score's information
     * @param life               a life's information
     * @param nbFruit            a total number of fruit
     * @param teamManager        a team manager
     */
    public GamePacMan(LabyrinthGenerator labyrinthGenerator, Score score, GameOver gameOver, Life life, int nbFruit, TeamManager teamManager) {
        assert labyrinthGenerator != null && score != null && life != null && teamManager != null && nbFruit > 0 : "Error : a parameter is wrong";

        // public GamePacMan(LabyrinthGenerator labyrinthGenerator, Score score, GameOver gameOver,Life life, int nbFruit, TeamManager teamManager) {
        this.labyrinthGenerator = labyrinthGenerator;
        this.score = score;
        this.gameOver = gameOver;
        this.life = life;
        this.nbFruits = nbFruit;
        this.teamManager = teamManager;

        teamManager.addTeam(new ClassicTeam("GHOST", false));
        teamManager.addTeam(new ClassicTeam("PACMAN", false));
    }

    /**
     * Create the entity Pac-Man and the ghosts
     */
    public void createEntity() {
        entities = labyrinthGenerator.generateEntity(sceneGame, this);
        assert entities.size() > 0 : "error : entity not generate";
        for (Entity entity : entities) {
            if (entity instanceof Pacman) {
                threadEntities.add(new ThreadPacman((Pacman) entity, this));
            }
            if (entity instanceof Ghost) {
                threadEntities.add(new ThreadGhostIA((Ghost) entity, this));
            }
        }
    }

    /**
     * Start the entities thread and play the game start music
     */
    public void startThreadEntity() {
        if (!stateThread) {
            for (Thread thread : threadEntities) {
                assert thread.getState() == Thread.State.NEW : "Error : a thread is not new";
                ThreadEntity threadEntity = (ThreadEntity) thread;
                threadEntity.setImageViewEntities(kernelEngine.getImageViewEntities(threadEntity.getEntity()));
                if(thread instanceof ThreadGhostIA){
                    ((ThreadGhostIA)thread).setKernelEngine(kernelEngine);
                }
                thread.start();
            }
            kernelEngine.playFirstSound("game_start.wav");
            stateThread = true;
        }
    }

    /**
     * Generate the labyrinth
     */
    public void generateSceneGame() {
        sceneGame = labyrinthGenerator.generateLabyrinth();
        assert sceneGame != null : "Error : the scene game is null";
    }

    /**
     * Start the classic kernel engine, classic sound engine, classic graphic engine, classic control engine
     *
     * @param stage the stage of the application
     */
    public void startEngine(Stage stage) {
        kernelEngine = new ClassicKernelEngine(this);
        kernelEngine.setPhysicEngine(new ClassicPhysicEngine());
        kernelEngine.setIaEngine(new IAPacman());
        startSoundEngine();
        startGraphicEngine(stage);
        startControlEngine();
    }

    /**
     * Start the classic sound engine and get all sound needed for the game Pac-Man
     */
    private void startSoundEngine() {
        SoundManager soundManager = new ClassicSoundManager();

        File soundFolder = new File("ressources/sounds/PacMan");
        File[] files = soundFolder.listFiles();

        assert files != null : "error folder null";
        for (File file : files) {
            if (file.isFile()) {
                MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(soundFolder.getPath() + "/" + file.getName()).toURI().toString()));
                mediaPlayer.setOnError(() -> System.out.println("media error" + mediaPlayer.getError().toString()));
                soundManager.addSound(new ClassicSound(mediaPlayer, file.getName()));
            }
        }
        kernelEngine.setSoundEngine(new ClassicSoundEngine(soundManager));
    }

    /**
     * Start the classic graphic engine
     *
     * @param stage the stage of the application
     */
    private void startGraphicEngine(Stage stage) {
        GraphicEngine graphicEngine = new ClassicGraphicEngine(stage, kernelEngine, new ClassicConvertSceneToGraphic());
        graphicEngine.setFxWindow(1200, 800, "Pac-Man");
        graphicEngine.setCurrentScene(new SceneMainMenu(stage, graphicEngine));
        kernelEngine.setGraphicEngine(graphicEngine);
    }

    /**
     * Start the classic control engine and get all control saved
     */
    private void startControlEngine() {
        ControlManager controlManager = new ClassicControlManager();

        try {
            String pathResourcesControls = "ressources/controls/PacMan/commands.txt";
            //read the commands file with the control saved
            File commandFile = new File(pathResourcesControls);

            BufferedReader buffer = new BufferedReader(new FileReader(commandFile));
            String line;
            Entity entity = null;
            //add all entity control saved
            while ((line = buffer.readLine()) != null) {
                String[] lineSplit = line.split(" ");
                if (lineSplit[0].equals("!!") && lineSplit[2].equals("!!")) {
                    entity = getEntity(lineSplit[1]);
                    assert entity != null : "Error : entity nul";
                } else {
                    assert entity != null : "Error : entity null";
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

    /**
     * Return a entity with his name or null if no entity has this name
     *
     * @param entityName a entity's name
     * @return a object type of Entity
     */
    private Entity getEntity(String entityName) {
        for (Entity entity : entities) {
            if (entity.getEntityName().equals(entityName)) {
                return entity;
            }
        }
        return null;
    }

    /**
     * Return all entities of the game Pac-Man
     *
     * @return a list of object type of Entity
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * Return the labyrinth of the game Pac-Man
     *
     * @return
     */
    public SceneGame getSceneGame() {
        return sceneGame;
    }

    /**
     * Treat the collision of a entity who move
     *
     * @param movement  the entity's movement
     * @param collision the entity's collision
     */
    public synchronized void treatmentCollision(Movement movement, Collision collision) {
        assert movement != null : "Error : the movement is null";

        System.out.println(movement.getEntity().getEntityName() + " : " + movement.getEntity().getPosition().getX() + "/" + movement.getEntity().getPosition().getY());
        if (collision != null) {
            //There is a collision with a wall
            if (collision.getSecondObjectCollision() instanceof SceneElement) {
                getThreadEntity(movement.getEntity()).setCollision(collision);
                if (movement.getEntity().isCharacter()) {
                    ((Character) movement.getEntity()).setDirection(Direction.Stop);
                }
            } else {
                //There is a collision with a entity
                if (collision.getSecondObjectCollision() instanceof Entity) {
                    treatmentCollisionEntity(movement, collision);
                }
            }
        }
        //There is no collision
        else {
            treatmentCollisionMoveEntity(movement, null);
        }
    }

    /**
     * Threat the collision between two entities
     *
     * @param movement  a entity's movement
     * @param collision a entity's collision
     */
    private void treatmentCollisionEntity(Movement movement, Collision collision) {
        assert movement != null && collision != null : "Error : a parameter is wrong";
        //A collision between Pac-Man and a normal fruit
        if (collision.getSecondObjectCollision() instanceof NormalFruit && collision.getFirstObjectCollision() instanceof Pacman) {
            score.addScore(10);
            kernelEngine.playFirstSound("eat_fruit.wav");
            treatmentCollisionMoveEntity(movement, collision);
            if(nbFruits >1){
                nbFruits-=1;
            }else{
                System.out.println("gagné");
            }
            kernelEngine.stopSound("eat_fruit.wav");
        }
        //A collision between Pac-Man and a Pacgum fruit
        else if (collision.getSecondObjectCollision() instanceof PacgumFruit && collision.getFirstObjectCollision() instanceof Pacman) {
            score.addScore(50);
            if(nbFruits >1){
                nbFruits-=1;
            }else{
                System.out.println("gagné");
            }
            kernelEngine.playFirstSound("eat_fruit.wav");
            treatmentCollisionMoveEntity(movement, collision);
            kernelEngine.stopSound("eat_fruit.wav");
        }
        //A collision between Pac-Man and a ghost
        else if ((collision.getSecondObjectCollision() instanceof Ghost && collision.getFirstObjectCollision() instanceof Pacman) || (collision.getFirstObjectCollision() instanceof Ghost && collision.getSecondObjectCollision() instanceof Pacman)) {
            Pacman pacman = (Pacman) collision.getFirstObjectCollision();
            getThreadEntity(movement.getEntity()).setCollision(collision);
            treatmentCollisionMoveEntity(movement, collision);
            pacman.setDirection(Direction.Stop);
            getThreadEntity(pacman).setMovement(null);
            pacman.setIsAlive(false);
            pacman.getLife().removeLifePoint(1);
            new PacManAnimation().deadAnimation(kernelEngine.getImageViewEntities(pacman));
        }
    }

    /**
     * Move a entity to the next case compared to the treatment of the collision
     *
     * @param movement  the entity's movement
     * @param collision the entity's collision
     */
    private void treatmentCollisionMoveEntity(Movement movement, Collision collision) {
        assert movement != null : "Error : the movement is null";

        getThreadEntity(movement.getEntity()).setCollision(collision);
        SceneCase newSceneCase = getNewSceneCase(movement.getDirection(), movement.getEntity());

        assert newSceneCase != null : "error : new scene case null";

        sceneGame.getCase(movement.getEntity().getPosition().getX(), movement.getEntity().getPosition().getY()).removeCaseContent(movement.getEntity());
        newSceneCase.addCaseContent(movement.getEntity());
        if (collision != null) {
            if (collision.getSecondObjectCollision() instanceof NormalFruit || collision.getSecondObjectCollision() instanceof PacgumFruit) {
                //The fruit is remove
                newSceneCase.removeCaseContent(collision.getSecondObjectCollision());
            }

        } else {
            if (movement.getEntity().isCharacter()) {
                ((Character) movement.getEntity()).setDirection(movement.getDirection());
            }
        }
        //The entity's position is update
        movement.getEntity().setPosition(newSceneCase);
        //The labyrinth is update
        kernelEngine.updateSceneGame(movement.getEntity());
    }

    /**
     * Return the next case of a entity who move in a direction
     *
     * @param direction the movement's direction
     * @param entity    the entity
     * @return a object type of SceneCase
     */
    private SceneCase getNewSceneCase(Direction direction, Entity entity) {
        assert direction != null && entity != null : "Error : a parameter is wrong";
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

    /**
     * Update the labyrinth after a movement
     *
     * @param movement a entity's movement
     */
    public void updateSceneGame(Movement movement) {
        assert movement != null : "Error : the movement is null";
        kernelEngine.updateSceneGame(movement.getEntity());
    }

    /**
     * Return the entities thread
     *
     * @return a list of object type of Thread
     */
    public List<Thread> getThreadEntities() {
        return threadEntities;
    }

    /**
     * Return the entity thread of a entity
     *
     * @param entity a entity
     * @return a object type of ThreadEntity
     */
    public ThreadEntity getThreadEntity(Entity entity) {
        assert entity != null : "Error : entity null";
        for (Thread thread : threadEntities) {
            if (((ThreadEntity) thread).getEntity() == entity) {
                return (ThreadEntity) thread;
            }
        }
        return null;
    }

    /**
     * Call the collision's treatment of a movement of the kernel engine
     *
     * @param movement a entity's movement
     */
    public void treatmentCollisionGame(Movement movement) {
        assert movement != null : "Error : movement null";
        kernelEngine.treatmentCollisionGame(movement);
    }

    /**
     * Return the image view entities of a entity
     *
     * @param entity a entity
     * @return a object type of ImageViewEntities
     */
    public ImageViewEntities getImageViewEntity(Entity entity) {
        assert entity != null : "Error : entity null";
        return kernelEngine.getImageViewEntities(entity);
    }

    /**
     * Return the score's information
     *
     * @return a object type of Score
     */
    public Score getScore() {
        return score;
    }

    /**
     * Return the life's information
     *
     * @return a object type of Life
     */
    public Life getLife() {
        return life;
    }

    /**
     * Return the team manager of this game
     *
     * @return a object type of TeamManager
     */
    public TeamManager getTeamManager() {
        return teamManager;
    }
}
