package pacman;

import gameplay.Direction;
import gameplay.Movement;
import scene.*;
import scene.Scene;

import java.util.List;

public class Labyrinth2D implements Scene {

    private final SceneCase[][] labyrinth;
    private final int height;
    private final int width;

    public Labyrinth2D(int height, int width){
        labyrinth = new SceneCase[height][width];
        this.height = height;
        this.width = width;
    }

    public boolean addSceneCase(SceneCase sceneCase, int x, int y){
        if(labyrinth[x][y] == null && x < width && y < height) {
            labyrinth[x][y] = sceneCase;
            return true;
        }
        return false;
    }

    public boolean removeSceneCase(int x, int y){
        if(labyrinth[x][y] != null && x < width && y < height) {
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

    public SceneElement obstacle(int x, int y, Movement movement){
        if(x >= 0 && x < width && y >= 0 && y < height) {
            SceneCase sceneCase = labyrinth[x][y];
            return wall(movement.getDirection(),sceneCase);
        }
        return null;
    }

    private Wall wall(Direction direction, SceneCase sceneCase){
        List<Object> list = sceneCase.getCaseContent(Wall.class.toString());
        if(list != null) {
            for (Object object : sceneCase.getCaseContent(Wall.class.toString())) {
                if (((Wall) object).getSceneElement() == direction) {
                    return (Wall) object;
                }
            }
        }
      return null;
    }
}
