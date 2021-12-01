package gameplay;

public class MovementWest implements Movement {

    private final Entity entity;

    public MovementWest(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public Direction getDirection() {
        return Direction.West;
    }

    public int[] nextPosition() {
        if (entity.getPosition().getX() == 0 && entity.getPosition().getY() == 13)
            return new int[]{
                    25, entity.getPosition().getY()
            };
        return new int[]{entity.getPosition().getX() - 1, entity.getPosition().getY()};
    }
}
