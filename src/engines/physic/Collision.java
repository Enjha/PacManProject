package engines.physic;

/**
 * The interface of a collision of 2 objects
 */
public interface Collision {

    /**
     * The first object of the collision
     * @return a object
     */
    Object getFirstObjectCollision();

    /**
     * The second object of the collision
     * @return a object
     */
    Object getSecondObjectCollision();
}
