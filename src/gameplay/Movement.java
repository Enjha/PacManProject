package gameplay;

public interface Movement {

    Entity getEntity();
    Direction getDirection();
    int[] nextPosition();
}
