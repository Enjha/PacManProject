package Gameplay;

public interface Movement {

    Entity getEntity();
    Direction getDirection();
    int[] nextPosition();
}
