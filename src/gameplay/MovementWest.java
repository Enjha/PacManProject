package gameplay;

/**
 * A movement to the direction west
 */
public class MovementWest implements Movement {

    /**
     * The entity who move
     */
    private final Entity entity;

    /**
     * <b>Constructor of MovementWest</b>
     * @param entity
     *      a new entity
     */
    public MovementWest(Entity entity) {
        assert (entity != null);
        this.entity = entity;
    }

    /**
     * Return the movement's entity
     * @return a object type of Entity
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * return the movement's direction
     * @return a object type of Direction
     */
    public Direction getDirection() {
        return Direction.West;
    }

    /**
     * Return the next position of this entity
     * @return a table of integer value
     */
    public int[] nextPosition() {
        if(entity.getPosition().getSceneCaseLink() != null){
            return new int[]{entity.getPosition().getSceneCaseLink().getX(),entity.getPosition().getSceneCaseLink().getY()};
        }
        return new int[]{entity.getPosition().getX() - 1, entity.getPosition().getY()};
    }
}
