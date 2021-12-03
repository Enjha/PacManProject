package gameplay;

/**
 * Interface of a movement
 */
public interface Movement {

    /**
     * Return the movement's entity
     * @return a object type of Entity
     */
    Entity getEntity();

    /**
     * Return the movement's direction
     * @return a object type of Direction
     */
    Direction getDirection();

    /**
     * Return the next position of the movement's entity
     * @return a table of integer value
     */
    int[] nextPosition();
}
