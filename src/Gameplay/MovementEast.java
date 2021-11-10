package Gameplay;

public class MovementEast implements Movement{

    private Entity entity;
    private Direction direction;

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
        int[] nextPosition = {entity.getPosition().getX() + 1,entity.getPosition().getY()};
        return nextPosition;
    }
}
