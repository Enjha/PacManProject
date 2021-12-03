package gameplay;

/**
 * A movement to the direction north
 */
public class MovementNorth implements Movement{

    /**
     * The entity who move
     */
    private final Entity entity;

    /**
     * <b>Constructor of MovementNorth</b>
     * @param entity
     *      a new entity
     */
    public MovementNorth(Entity entity){
        assert(entity != null);
        this.entity = entity;
    }

    /**
     * Return the movement's entity
     * @return a object type of Entity
     */
    public Entity getEntity(){
        return entity;
    }

    /**
     * Return the movement's entity
     * @return a object type of Entity
     */
    public Direction getDirection(){
        return Direction.North;
    }

    /**
     * Return the next position of this entity
     * @return a table of integer value
     */
    public int[] nextPosition(){
        if(entity.getPosition().getSceneCaseLink() != null){
            return new int[]{entity.getPosition().getSceneCaseLink().getX(),entity.getPosition().getSceneCaseLink().getY()};
        }
        return new int[]{entity.getPosition().getX(), entity.getPosition().getY() - 1};
    }
}
