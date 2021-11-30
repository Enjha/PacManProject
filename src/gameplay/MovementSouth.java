package gameplay;

public class MovementSouth implements Movement{

    private final Entity entity;

    public MovementSouth(Entity entity){
        this.entity = entity;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return Direction.South;
    }

    public int[] nextPosition(){
        return new int[]{entity.getPosition().getX(),entity.getPosition().getY() + 1};
    }
}
