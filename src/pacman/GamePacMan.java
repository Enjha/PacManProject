package pacman;

import engines.UI.*;
import engines.graphic.ClassicConvertSceneToGraphic;
import engines.graphic.ClassicGraphicEngine;
import engines.graphic.GraphicEngine;
import engines.kernel.ClassicKernelEngine;
import engines.kernel.KernelEngine;
import engines.physic.ClassicPhysicEngine;
import engines.physic.PhysicEngine;
import engines.sound.*;
import gameplay.Direction;
import gameplay.Entity;
import gameplay.Game;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import pacman.scene.LabyrinthGenerator;
import pacman.scene.SceneMainMenu;
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
    private LabyrinthGenerator labyrinthGenerator;
    private KernelEngine kernelEngine;
    private PhysicEngine physicEngine;
    private SoundEngine soundEngine;
    private ControlEngine controlEngine;
    private GraphicEngine graphicEngine;

    public GamePacMan(LabyrinthGenerator labyrinthGenerator) {
        this.labyrinthGenerator = labyrinthGenerator;
    }

    public void createEntity() {
        entities = labyrinthGenerator.generateEntity(sceneGame);
        /*entities.add(new Pacman());
        entities.add(new Ghost("Pinky", GhostColor.PINK));
        entities.add(new Ghost("Blue", GhostColor.BLUE));*/
    }

    public void generateSceneGame() {
        sceneGame = labyrinthGenerator.generateLabyrinth();
    }

    public void startEngine(Stage stage) {
        kernelEngine = new ClassicKernelEngine(this);
        physicEngine = new ClassicPhysicEngine();
        startSoundEngine();
        startGraphicEngine(stage);
        startControlEngine();
    }

    private void startSoundEngine() {
        SoundManager soundManager = new ClassicSoundManager();

        String pathRessourcesSound = "ressources/sounds.PacMan";
        File soundFolder = new File(pathRessourcesSound);
        File[] listOfFiles = soundFolder.listFiles();

        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    soundManager.addSound(new ClassicSound(new MediaPlayer(new Media(new File(pathRessourcesSound + "/" + listOfFile.getName()).toURI().toString())), listOfFile.getName()));
                }
            }
            soundEngine = new ClassicSoundEngine(soundManager);
            kernelEngine.setSoundEngine(soundEngine);
        } else {
            System.out.println("error folder null");
        }
    }

    private void startGraphicEngine(Stage stage) {
        graphicEngine = new ClassicGraphicEngine(stage, kernelEngine, new ClassicConvertSceneToGraphic());
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

            controlEngine = new ClassicControlEngine(kernelEngine.getCurrentScene(), controlManager);
            kernelEngine.setControlEngine(controlEngine);
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
}
