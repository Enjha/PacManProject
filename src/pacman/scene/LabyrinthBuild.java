package pacman.scene;

import gameplay.Direction;
import gameplay.Entity;
import gameplay.Game;
import gameplay.Character;
import pacman.*;
import scene.SceneCase;
import scene.SceneGame;
import scene.Wall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A labyrinth builder
 */
public class LabyrinthBuild implements LabyrinthGenerator {

    public List<Entity> generateEntity(SceneGame sceneGame, Game game) {
        List<Entity> entities = new ArrayList<>();
        try {
            String entitiesPath = "ressources/seed/PacMan/entities/entities1.txt";
            File entitiesFile = new File(entitiesPath);
            BufferedReader buffer = new BufferedReader(new FileReader(entitiesFile));
            String line;
            String[] splitLine;

            while ((line = buffer.readLine()) != null) {
                splitLine = line.split(" ");
                Entity entity = createNewEntity(splitLine, sceneGame, game);
                if (entity != null) {
                    entities.add(entity);
                } else {
                    System.err.println("error : wrong format for the labyrinth's seed --> entity null");
                    System.exit(-1);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return entities;
    }

    /**
     * Generate the labyrinth et return the scene game
     * @return a objec type of SceneGame
     */
    public SceneGame generateLabyrinth() {
        SceneGame sceneGame = null;
        try {
            String seedPath = "ressources/seed/PacMan/labyrinth/seed1.txt";
            //Read the information of the future labyrinth
            File seedFile = new File(seedPath);
            BufferedReader buffer = new BufferedReader(new FileReader(seedFile));
            String line;
            String[] splitLine;

            //Get the size of the labyrinth
            line = buffer.readLine();
            assert line != null : "Error : wrong fomat for the labyrinth seed --> information missing";
            splitLine = line.split(" ");
            assert splitLine.length == 2 : "Error : wrong format for the labyrinth's seed --> wrong number of information (2)";
            int width = Integer.parseInt(splitLine[0]);
            int height = Integer.parseInt(splitLine[1]);
            sceneGame = new Labyrinth2D(height, width);

            //Get all information of the case and create it
            while ((line = buffer.readLine()) != null) {
                splitLine = line.split(" ");
                int x = Integer.parseInt(splitLine[0]);
                int y = Integer.parseInt(splitLine[1]);
                int numberWall = Integer.parseInt(splitLine[2]);

                SceneCase sceneCase = new LabyrinthCase(x, y, new NormalCaseContentManager());

                for (int i = 1; i <= numberWall; i++) {
                    Direction wallDirection = getWallDirection(splitLine[2 + i]);
                    if (wallDirection != null) {
                        sceneCase.addCaseContent(new Wall(wallDirection));
                    }
                }

                //Check if a case is link to a other case
                if (splitLine.length > (4 + numberWall)) {
                    x = Integer.parseInt(splitLine[3 + numberWall]);
                    y = Integer.parseInt(splitLine[4 + numberWall]);
                    sceneCase.setSceneCaseLink(sceneGame.getCase(x, y));
                }
                sceneGame.addSceneCase(sceneCase, x, y);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return sceneGame;
    }

    /**
     * Return the direction corresponding of the name
     * @param directionFile
     *      the name of the direction
     * @return a object type of Direction
     */
    private Direction getWallDirection(String directionFile) {
        assert directionFile != null : "Error : direction null";
        switch (directionFile) {
            case "NORTH":
                return Direction.North;
            case "SOUTH":
                return Direction.South;
            case "WEST":
                return Direction.West;
            case "EAST":
                return Direction.East;
            default:
                return null;
        }
    }

    /**
     * Generate a entity
     * @param entityInformation
     *      the information of a entity
     * @param sceneGame
     *      the current scene game
     * @param game
     *      the current game
     * @return a object type of Entity
     */
    private Entity createNewEntity(String[] entityInformation, SceneGame sceneGame, Game game) {
        assert entityInformation != null : "Error : information of the entity null";
        assert sceneGame != null : "Error : scene game null";
        assert game != null : "Error : game null";

        String entityType = entityInformation[0];
        switch (entityType) {
            case "PACMAN":
                assert entityInformation.length == 3 : "Error : wrong format for the entities --> wrong number of information (3)";
                Character pacman = new Pacman(new ClassicLife(3));
                setupEntityPosition(entityInformation[1], entityInformation[2], pacman, sceneGame);
                pacman.setTeam(game.getTeamManager().getTeam("PACMAN"));
                return pacman;

            case "GHOST":
                assert entityInformation.length == 5 : "Error : wrong format for the entities --> wrong number of information (5)";
                GhostColor ghostColor = getGhostColor(entityInformation[2]);
                assert ghostColor != null : "Error : wrong format for the labyrinth's seed : ghost color wrong";
                Character ghost = new Ghost(entityInformation[1], ghostColor);
                setupEntityPosition(entityInformation[3], entityInformation[4], ghost, sceneGame);
                ghost.setTeam(game.getTeamManager().getTeam("GHOST"));
                return ghost;

            case "PACGUM":
                assert entityInformation.length == 3 : "Error : wrong format for the entities --> wrong number of information (3)";
                Entity pacgum = new PacgumFruit();
                setupEntityPosition(entityInformation[1], entityInformation[2], pacgum, sceneGame);
                return pacgum;

            case "FRUIT":
                assert entityInformation.length == 3 : "Error : wrong format for the entities --> wrong number of information (3)";
                Entity fruit = new NormalFruit();
                setupEntityPosition(entityInformation[1], entityInformation[2], fruit, sceneGame);
                return fruit;
        }
        return null;
    }

    /**
     * Return the ghost color of the color read
     * @param color
     *      the ghost color read
     * @return a object type of GhostColor
     */
    private GhostColor getGhostColor(String color) {
        assert color != null : "Error : color null";
        switch (color) {
            case "BLUE":
                return GhostColor.BLUE;
            case "ORANGE":
                return GhostColor.ORANGE;
            case "PINK":
                return GhostColor.PINK;
            case "RED":
                return GhostColor.RED;
            default:
                return null;
        }
    }

    /**
     * Set a entity position
     * @param positionX
     *      the position x of the entity
     * @param positionY
     *      the position y of the entity
     * @param entity
     *      the entity
     * @param sceneGame
     *      the scene game
     */
    private void setupEntityPosition(String positionX, String positionY, Entity entity, SceneGame sceneGame) {
        assert positionX != null : "Error : position x null";
        assert positionY != null : "Error : position y null";
        assert entity != null : "Error : entity null";
        try {
            int x = Integer.parseInt(positionX);
            int y = Integer.parseInt(positionY);
            if (sceneGame != null) {
                SceneCase sceneCase = sceneGame.getCase(x, y);
                if (sceneCase != null) {
                    entity.setPosition(sceneCase);
                    sceneCase.addCaseContent(entity);
                } else {
                    System.err.println("error : case null");
                    System.exit(-1);
                }
            } else {
                System.err.println("error : scene game null");
                System.exit(-1);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
