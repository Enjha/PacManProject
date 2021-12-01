package pacman;

import gameplay.Direction;
import gameplay.Entity;
import gameplay.Movement;
import scene.*;
import scene.SceneGame;

import java.util.ArrayList;
import java.util.List;

/**
 * The scene of a 2D labyrinth
 */
public class Labyrinth2D implements SceneGame {

    /**
     * The cases of the labyrinth
     */
    private final SceneCase[][] labyrinth;

    /**
     * the labyrinth's height
     */
    private final int height;

    /**
     * the labyrinth's width
     */
    private final int width;

    /**
     * <b>Constructor of Labyrinth2D</b>
     * @param height
     *      the height of the labyrinth
     * @param width
     *      the width of the labyrinth
     */
    public Labyrinth2D(int height, int width){
        labyrinth = new SceneCase[width][height];
        this.height = height;
        this.width = width;
    }

    /**
     * If x and y are correct compared to the dimension of the labyrinth, the new scene case is add
     * Return if the operation was a success
     * @param sceneCase
     *      a new scene case
     * @param x
     *      the position x of the new scene case
     * @param y
     *      the position y of the new scene case
     * @return a boolean value
     */
    public boolean addSceneCase(SceneCase sceneCase, int x, int y){
        if(labyrinth[x][y] == null && x < width && y < height) {
            labyrinth[x][y] = sceneCase;
            return true;
        }
        return false;
    }

    /**
     * If x and y are correct compared to the dimension of the labyrinth, the scene case is remove
     * Return if the operation was a success
     * @param x
     *      the position x of a scene case
     * @param y
     *      the position y of a scene case
     * @return a boolean value
     */
    public boolean removeSceneCase(int x, int y){
        if(labyrinth[x][y] != null && x >= 0 && x < width && y >= 0 && y < height) {
            labyrinth[x][y] = null;
            return true;
        }
        return false;
    }

    /**
     * If x and y are correct compared to the dimension of the labyrinth, return the scene case at the position x and y
     * If x and y are incorrect compared to the dimension of the labyrinth, return a null
     * @param x
     *      the position x of a scene case
     * @param y
     *      the position y of a scene case
     * @return a object type of SceneCase
     */
    public SceneCase getCase(int x, int y){
        if(x >= 0 && x < width && y >= 0 && y < height){
            return labyrinth[x][y];
        }
        return null;
    }

    /**
     * If x and y are correct compared to the dimension of the labyrinth, return the scene element who has a contact with a entity
     * If x and y are incorrect compared to the dimension of the labyrinth, return a null
     * @param x
     *      the position x of a scene case
     * @param y
     *      the position y of a scene case
     * @param movement
     *      a movement of a entity
     * @return a object type of SceneElement
     */
    public SceneElement obstacleElement(int x, int y, Movement movement){
        if(x >= 0 && x < width && y >= 0 && y < height) {
            SceneCase sceneCase = labyrinth[x][y];
            return wall(movement.getDirection(),sceneCase);
        }
        return null;
    }

    public List<Entity> obstacleEntity(int x, int y, Movement movement){
        List<Entity> entities = null;
        if(x >= 0 && x < width && y >= 0 && y < height) {
            return entity(labyrinth[x][y]);
        }
        return entities;
    }

    /**
     * Return the wall in the scene case at the direction if this wall exist or null if this wall don't exist
     * @param direction
     *      a direction in the scene case
     * @param sceneCase
     *      a scene case
     * @return a object type of Wall
     */
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

    private List<Entity> entity(SceneCase sceneCase){
        List<List<Object>> list = sceneCase.getCaseAllContent();
        List<Entity> entities = new ArrayList<>();
        if(list != null){
            for(List<Object> listObject : list){
                if(listObject.size() > 0 && listObject.get(0) instanceof Entity){
                    for(Object object : listObject) {
                        entities.add((Entity) object);
                    }
                }
            }
        }
        return entities;
    }

    /**
     * Return all cases of the labyrinth
     * @return a 2D table of object type of SceneCase
     */
    public SceneCase[][] getCases(){
        return labyrinth;
    }
}
