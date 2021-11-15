package gameplay;

public class MovementWest implements Movement{

    private final Entity entity;
    private final Direction direction;

    public MovementWest(Entity entity){
        this.entity = entity;
        this.direction = Direction.West;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return direction;
    }

    public int[] nextPosition(){
        return new int[]{entity.getPosition().getX() - 1,entity.getPosition().getY()};
    }
}
