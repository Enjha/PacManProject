package scene;

import gameplay.Direction;

/**
 * A wall in a scene case
 */
public class Wall implements SceneElement{

    /**
     * Wall's position in the scene case
     */
    private final Direction wallDirection;

    /**
     * <b>Constructor of Wall</b>
     * @param wallDirection
     *      a wall's position in this SceneCase
     */
    public Wall(Direction wallDirection){
        this.wallDirection = wallDirection;
    }

    /**
     * Return the wall's direction
     * @return a object type of Direction
     */
    public Direction getSceneElement(){
        return wallDirection;
    }
}
