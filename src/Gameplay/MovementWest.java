package Gameplay;

public class MovementWest implements Movement{

    private Entity entity;
    private Direction direction;

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
        int[] nextPosition = {entity.getPosition().getX() - 1,entity.getPosition().getY()};
        return nextPosition;
    }
}
