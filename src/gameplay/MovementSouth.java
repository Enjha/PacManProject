package gameplay;

public class MovementSouth implements Movement{

    private final Entity entity;
    private final Direction direction;

    public MovementSouth(Entity entity){
        this.entity = entity;
        this.direction = Direction.South;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return direction;
    }

    public int[] nextPosition(){
        return new int[]{entity.getPosition().getX(),entity.getPosition().getY() + 1};
    }
}
