package Pacman;

import Gameplay.Direction;
import Gameplay.Movement;
import Scene.*;
import Scene.Scene;

public class Labyrinth2D implements Scene {

    private SceneCase[][] labyrinth;
    private int height;
    private int width;

    public Labyrinth2D(int height, int width){
        labyrinth = new SceneCase[height][width];
        this.height = height;
        this.width = width;
    }

    public boolean addSceneCase(SceneCase sceneCase, int x, int y){
        if(labyrinth[x][y] != null && x >= 0 && x < width && y >= 0 && y < height) {
            labyrinth[x][y] = sceneCase;
            return true;
        }
        return false;
    }

    public boolean removeSceneCase(int x, int y){
        if(labyrinth[x][y] != null  && x >= 0 && x < width && y >= 0 && y < height) {
            labyrinth[x][y] = null;
            return true;
        }
        return false;
    }

    public SceneCase getCase(int x, int y){
        if(x >= 0 && x < width && y >= 0 && y < height){
            return labyrinth[x][y];
        }
        return null;
    }

    public boolean obstacle(int x, int y, Movement movement){
        if(x >= 0 && x < width && y >= 0 && y < height) {
            SceneCase sceneCase = labyrinth[x][y];
            switch (movement.getDirection()){
                case North: return wall(Direction.North,sceneCase);
                case South: return wall(Direction.South,sceneCase);
                case West: return wall(Direction.West,sceneCase);
                case East: return wall(Direction.East,sceneCase);
            }
        }
        return true;
    }

    private boolean wall(Direction direction, SceneCase sceneCase){
        for(Object object : sceneCase.getCaseContent()){
            if(object instanceof Wall){
                if(((Wall) object).getWallDirection() == direction){
                    return true;
                }
            }
        }
        return false;
    }
}
