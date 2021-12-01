package gameplay;

import engines.graphic.ImageViewEntities;
import engines.physic.Collision;

public interface ThreadEntity {

    Entity getEntity();
    void setMovement(Movement movement);
    void setCollision(Collision collision);
    void setImageViewEntities(ImageViewEntities imageViewEntities);
}
