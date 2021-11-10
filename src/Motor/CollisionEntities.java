package Motor;

import Gameplay.Entity;

public class CollisionEntities implements Collision{

    private Entity firstEntity;
    private Entity secondEntity;

    public CollisionEntities(Entity firstEntity, Entity secondEntity){
        this.firstEntity = firstEntity;
        this.secondEntity = secondEntity;
    }

    public Object getFirstObjectCollision(){
        return firstEntity;
    }

    public Object getSecondObjectCollision(){
        return secondEntity;
    }
}
