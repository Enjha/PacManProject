package gameplay;

public class MovementNorth implements Movement{

    private final Entity entity;
    private final Direction direction;

    public MovementNorth(Entity entity){
        this.entity = entity;
        this.direction = Direction.North;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return direction;
    }

    public int[] nextPosition(){
        return new int[]{entity.getPosition().getX(),entity.getPosition().getY() - 1};
    }
}
