package Gameplay;

public class SimpleMovement implements Movement{

    private Entity entity;
    private Direction direction;

    public SimpleMovement(Entity entity, Direction direction){
        this.entity = entity;
        this.direction = direction;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return direction;
    }
}
