package gameplay;

public class MovementEast implements Movement {

    private final Entity entity;

    public MovementEast(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public Direction getDirection() {
        return Direction.East;
    }

    public int[] nextPosition() {
        if (entity.getPosition().getX() == 25 && entity.getPosition().getY() == 13)
            return new int[]{
                    0, entity.getPosition().getY()
            };
        return new int[]{entity.getPosition().getX() + 1, entity.getPosition().getY()};
    }
}
