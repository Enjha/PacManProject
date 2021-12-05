package gameplay;

import engines.graphic.ImageViewEntities;
import engines.kernel.KernelEngine;
import engines.physic.Collision;

public interface ThreadEntity {

    Entity getEntity();
    void setMovement(Movement movement);
    void setCollision(Collision collision);
    void setImageViewEntities(ImageViewEntities imageViewEntities);
    void setPause(boolean pause);
    void setKernelEngine(KernelEngine kernelEngine);
}
