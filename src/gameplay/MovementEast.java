package gameplay;

/**
 * A movement to the direction east
 */
public class MovementEast implements Movement {

    /**
     * The entity who move
     */
    private final Entity entity;

    /**
     * <b>Constructor of MovementEast</b>
     * @param entity
     *      a new entity
     */
    public MovementEast(Entity entity) {
        assert(entity != null);
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
     * Return the movement's entity
     * @return a object type of Entity
     */
    public Direction getDirection() {
        return Direction.East;
    }

    /**
     * Return the next position of this entity
     * @return a table of integer value
     */
    public int[] nextPosition() {
        if(entity.getPosition().getSceneCaseLink() != null){
            return new int[]{entity.getPosition().getSceneCaseLink().getX(),entity.getPosition().getSceneCaseLink().getY()};
        }
        return new int[]{entity.getPosition().getX() + 1, entity.getPosition().getY()};
    }
}
