package pacman.scene;

import gameplay.Direction;
import gameplay.Entity;
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

public class LabyrinthBuild implements LabyrinthGenerator{

    private int height;
    private int width;
    private final String seedPath = "ressources/seed/PacMan/labyrinth/seed1.txt";
    private final String entitiesPath = "ressources/seed/PacMan/entities/entities1.txt";

    public SceneGame generateLabyrinth(){
        SceneGame sceneGame = generateSceneCase();

        return sceneGame;
    }

    public List<Entity> generateEntity(SceneGame sceneGame){
        List<Entity> entities = new ArrayList<>();
        try{
            File entitiesFile = new File(entitiesPath);
            BufferedReader buffer = new BufferedReader(new FileReader(entitiesFile));
            String line;
            String[] splitLine;

            while((line = buffer.readLine()) != null){
                splitLine = line.split(" ");
                Entity entity = createNewEntity(splitLine,sceneGame);
                if(entity != null){
                    entities.add(entity);
                }
                else {
                    System.err.println("error : wrong format for the labyrinth's seed --> entity null");
                    System.exit(-1);
                }
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
        return entities;
    }

    private SceneGame generateSceneCase(){
        SceneGame sceneGame = null;
        try {
            File seedFile = new File(seedPath);
            BufferedReader buffer = new BufferedReader(new FileReader(seedFile));
            String line;
            String[] splitLine;
            line = buffer.readLine();

            if(line != null){
                splitLine = line.split(" ");
                if(splitLine.length == 2) {
                    width = Integer.parseInt(splitLine[0]);
                    height = Integer.parseInt(splitLine[1]);
                    sceneGame = new Labyrinth2D(height,width);
                }
                else{
                    System.err.println("error : wrong format for the labyrinth's seed --> wrong number of information (2)");
                    System.exit(-1);
                }
            }
            else {
                System.err.println("error : wrong format for the labyrinth's seed --> information missing");
                System.exit(-1);
            }

            while((line = buffer.readLine()) != null){
                splitLine = line.split(" ");
                int x = Integer.parseInt(splitLine[0]);
                int y = Integer.parseInt(splitLine[1]);
                int numberWall = Integer.parseInt(splitLine[2]);

                SceneCase sceneCase = new LabyrinthCase(x,y,new NormalCaseContentManager());

                for(int i = 1; i <= numberWall; i++){
                    Direction wallDirection = getWallDirection(splitLine[2 + i]);
                    if(wallDirection != null){
                        sceneCase.addCaseContent(new Wall(wallDirection));
                    }
                }

                if(x == 0 && y == 13){
                    System.out.println(sceneCase.getCaseContent(Wall.class.toString()).size());
                }
                if(splitLine.length  > (4 + numberWall)){
                    x = Integer.parseInt(splitLine[3 + numberWall]);
                    y = Integer.parseInt(splitLine[4 + numberWall]);
                    sceneCase.setSceneCaseLink(sceneGame.getCase(x,y));
                }
                sceneGame.addSceneCase(sceneCase,x,y);
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
        return sceneGame;
    }

    private Direction getWallDirection(String directionFile){
        switch (directionFile){
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

    private Entity createNewEntity(String[] entityInformation,SceneGame sceneGame){
        String entityType = entityInformation[0];
        switch (entityType) {
            case "PACMAN":
                if (entityInformation.length == 3) {
                    Entity pacman = new Pacman();
                    setupEntityPosition(entityInformation[1],entityInformation[2],pacman,sceneGame);
                    return pacman;
                } else {
                    System.err.println("error : wrong format for the entities --> wrong number of information (3)");
                    System.exit(-1);
                }

            case "GHOST":
                if (entityInformation.length == 5) {
                    GhostColor ghostColor = getGhostColor(entityInformation[2]);
                    if (ghostColor != null) {
                        Entity ghost = new Ghost(entityInformation[1], ghostColor);
                        setupEntityPosition(entityInformation[3],entityInformation[4],ghost,sceneGame);
                        return ghost;
                    }
                    else {
                        System.err.println("error : wrong format for the labyrinth's seed : ghost color wrong");
                        System.exit(-1);
                    }
                }
                else {
                    System.err.println("error : wrong format for the entities --> wrong number of information (5)");
                    System.exit(-1);
                }
            case "PACGUM":
                if(entityInformation.length == 3){
                    Entity pacgum = new PacgumFruit();
                    setupEntityPosition(entityInformation[1],entityInformation[2],pacgum,sceneGame);
                    return pacgum;
                }
                else {
                    System.err.println("error : wrong format for the entities --> wrong number of information (3)");
                    System.exit(-1);
                }
            case "FRUIT":
                if(entityInformation.length == 3){
                    Entity fruit = new NormalFruit();
                    setupEntityPosition(entityInformation[1],entityInformation[2],fruit,sceneGame);
                    return fruit;
                }
                else {
                    System.err.println("error : wrong format for the entities --> wrong number of information (3)");
                    System.exit(-1);
                }
        }
        return null;
    }

    private GhostColor getGhostColor(String color){
        switch (color){
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

    private void setupEntityPosition(String positionX, String positionY,Entity entity,SceneGame sceneGame){
        try{
            int x = Integer.parseInt(positionX);
            int y = Integer.parseInt(positionY);
            if(sceneGame != null) {
                SceneCase sceneCase = sceneGame.getCase(x, y);
                if (sceneCase != null) {
                    entity.setPosition(sceneCase);
                    sceneCase.addCaseContent(entity);
                } else {
                    System.err.println("error : case null");
                    System.exit(-1);
                }
            }
            else {
                System.err.println("error : scene game null");
                System.exit(-1);
            }

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
