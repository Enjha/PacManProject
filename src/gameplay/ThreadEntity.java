package gameplay;

public interface ThreadEntity {

    Entity getEntity();
    void setMovement(Movement movement);
    void setCollision(boolean collision);
}
