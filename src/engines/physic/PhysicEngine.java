package engines.physic;

import gameplay.Movement;
import scene.SceneGame;

/**
 * The interface of a physic engine
 */
public interface PhysicEngine {

    /**
     * Treat the movement of a entity and return the collision if its exist or null
     * @param movement
     *      the movement of a entity
     * @param sceneGame
     *      the scene game
     * @return a object type of Collision
     */
    Collision moveEntity(Movement movement, SceneGame sceneGame);
}
