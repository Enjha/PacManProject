package Gameplay;

public class MovementSouth implements Movement{

    private Entity entity;
    private Direction direction;

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
        int[] nextPosition = {entity.getPosition().getX(),entity.getPosition().getY() + 1};
        return nextPosition;
    }
}
