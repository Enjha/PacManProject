package scene;

import gameplay.Entity;
import gameplay.Movement;

import java.util.List;

/**
 * A scene who contain all information contain in a scene
 */
public interface SceneGame {

    /**
     * Add a scene case in a scene at the position x and y
     * @param sceneCase
     *      a new scene case
     * @param x
     *      the position x of the new scene case
     * @param y
     *      the position y of the new scene case
     * @return a boolean value
     */
    boolean addSceneCase(SceneCase sceneCase, int x, int y);

    /**
     * Remove a scene case at the position x and y
     * Return if the operation was a success
     * @param x
     *      the position x of a scene case
     * @param y
     *      the position y of a scene case
     * @return a boolean value
     */
    boolean removeSceneCase(int x, int y);

    /**
     * Return the scene case at the position x and y
     * @param x
     *      the position x of a scene case
     * @param y
     *      the position y of a scene case
     * @return a object type of SceneCase
     */
    SceneCase getCase(int x, int y);

    /**
     * Return all scene case
     * @return a 2D table of object type of scene case
     */
    SceneCase[][] getCases();

    /**
     * Return the scene element who has a contact with a entity
     * @param x
     *      the position x of a scene case
     * @param y
     *      the position y of a scene case
     * @param movement
     *      a movement of a entity
     * @return o object type of SceneElement
     */
    SceneElement obstacleElement(int x, int y, Movement movement);

    List<Entity> obstacleEntity(int x, int y);
}
