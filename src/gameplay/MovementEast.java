package gameplay;

public class MovementEast implements Movement{

    private final Entity entity;
    private final Direction direction;

    public MovementEast(Entity entity){
        this.entity = entity;
        this.direction = Direction.East;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return direction;
    }

    public int[] nextPosition(){
        return new int[]{entity.getPosition().getX() + 1,entity.getPosition().getY()};
    }
}
