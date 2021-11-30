package gameplay;

import engines.graphic.ImageViewEntities;

public interface ThreadEntity {

    Entity getEntity();
    void setMovement(Movement movement);
    void setCollision(boolean collision);
    void setImageViewEntities(ImageViewEntities imageViewEntities);
}
