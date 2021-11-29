package pacman.scene;

import gameplay.Direction;
import pacman.Labyrinth2D;
import pacman.LabyrinthCase;
import pacman.NormalCaseContentManager;
import scene.SceneCase;
import scene.SceneGame;
import scene.Wall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DefinedLabyrinth implements LabyrinthGenerator{

    private final int height = 29;
    private final int width = 26;
    private final String seedPath = "ressources/seed/PacMan/labyrinth/seed1.txt";

    public SceneGame generateLabyrinth(){
        SceneGame sceneGame = new Labyrinth2D(height,width);

        generateSceneCaseEmpty(sceneGame);
        //generateExteriorWall(sceneGame);
        generateWall(sceneGame);

        return sceneGame;
    }

    private void generateSceneCaseEmpty(SceneGame sceneGame){
        for(int w = 0; w < width; w ++){
            for(int h = 0; h < height; h ++){
                sceneGame.addSceneCase(new LabyrinthCase(w,h,new NormalCaseContentManager()),w,h);
            }
        }
    }

    private void generateExteriorWall(SceneGame sceneGame){
        SceneCase sceneCase;

        for(int w = 0; w < width; w ++){
            sceneCase = sceneGame.getCase(w,0);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.North));
            }
            else {
                System.out.println("case (" + w +",0) : null");
            }

            sceneCase = sceneGame.getCase(w,height - 1);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.South));
            }
            else {
                System.out.println("case (" + w +"," + (height - 1) + ") : null");
            }
        }

        for(int h = 0; h < height; h ++){
            sceneCase = sceneGame.getCase(0,h);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.West));
            }
            else {
                System.out.println("case (0," + h + ") : null");
            }

            sceneCase = sceneGame.getCase(width - 1,h);
            if(sceneCase != null) {
                sceneCase.addCaseContent(new Wall(Direction.East));
            }
            else {
                System.out.println("case (" + (width - 1) + "," + h + ") : null");
            }
        }
    }

    private void generateWall(SceneGame sceneGame){
        try {
            File seedFile = new File(seedPath);
            BufferedReader buffer = new BufferedReader(new FileReader(seedFile));
            String line;

            while((line = buffer.readLine()) != null){
                String[] splitLine = line.split(" ");
                int x = Integer.parseInt(splitLine[0]);
                int y = Integer.parseInt(splitLine[1]);
                int numberWall = Integer.parseInt(splitLine[2]);
                SceneCase sceneCase = sceneGame.getCase(x,y);
                if(sceneCase != null){
                    for(int i = 1; i <= numberWall; i++){
                        Direction wallDirection = getWallDirection(splitLine[2 + i]);
                        if(wallDirection != null){
                            sceneCase.addCaseContent(new Wall(wallDirection));
                        }
                    }
                }
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
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
}
