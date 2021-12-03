package gameplay;

public class MovementWest implements Movement {

    private final Entity entity;

    public MovementWest(Entity entity) {
        assert entity != null;
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public Direction getDirection() {
        return Direction.West;
    }

    public int[] nextPosition() {
        if(entity.getPosition().getSceneCaseLink() != null){
            return new int[]{entity.getPosition().getSceneCaseLink().getX(),entity.getPosition().getSceneCaseLink().getY()};
        }
        return new int[]{entity.getPosition().getX() - 1, entity.getPosition().getY()};
    }
}
