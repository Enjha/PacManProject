package gameplay;

public class MovementWest implements Movement{

    private final Entity entity;

    public MovementWest(Entity entity){
        this.entity = entity;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return Direction.West;
    }

    public int[] nextPosition(){
        return new int[]{entity.getPosition().getX() - 1,entity.getPosition().getY()};
    }
}
