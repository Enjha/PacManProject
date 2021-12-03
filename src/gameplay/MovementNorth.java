package gameplay;

public class MovementNorth implements Movement{

    private final Entity entity;

    public MovementNorth(Entity entity){
        this.entity = entity;
    }

    public Entity getEntity(){
        return entity;
    }

    public Direction getDirection(){
        return Direction.North;
    }

    public int[] nextPosition(){
        if(entity.getPosition().getSceneCaseLink() != null){
            return new int[]{entity.getPosition().getSceneCaseLink().getX(),entity.getPosition().getSceneCaseLink().getY()};
        }
        return new int[]{entity.getPosition().getX(), entity.getPosition().getY() - 1};
    }
}
