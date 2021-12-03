package engines.physic;

import gameplay.Entity;

/**
 * The collision between 2 entities
 */
public class CollisionEntities implements Collision{

    /**
     * The first entity
     */
    private final Entity firstEntity;

    /**
     * The second entity
     */
    private final Entity secondEntity;

    /**
     * <b>Constructor of CollisionEntities</b>
     * @param firstEntity
     *      the first entity
     * @param secondEntity
     *      the second entity
     */
    public CollisionEntities(Entity firstEntity, Entity secondEntity){
        assert(firstEntity != null && secondEntity != null);
        this.firstEntity = firstEntity;
        this.secondEntity = secondEntity;
    }

    /**
     * Return the first entity of this collision
     * @return a object
     */
    public Object getFirstObjectCollision(){
        return firstEntity;
    }

    /**
     * Return the second entity of this collision
     * @return a object
     */
    public Object getSecondObjectCollision(){
        return secondEntity;
    }
}
