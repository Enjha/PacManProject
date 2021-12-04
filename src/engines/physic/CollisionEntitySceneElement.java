package engines.physic;

import gameplay.Entity;
import scene.SceneElement;

/**
 * The collision between a entity and un scene element
 */
public class CollisionEntitySceneElement implements Collision{

    /**
     * The entity of this collision
     */
    private final Entity entity;

    /**
     * The scene element of this collision
     */
    private final SceneElement sceneElement;

    /**
     * <b>Constructor of CollisionEntitySceneElement</b>
     * @param entity
     *      the entity
     * @param sceneElement
     *      the scene element
     */
    public CollisionEntitySceneElement(Entity entity, SceneElement sceneElement){
        assert entity != null : "Error : first entity null";
        assert sceneElement != null : "Error : second entity null";
        this.entity = entity;
        this.sceneElement = sceneElement;
    }

    /**
     * Return the entity of this collision
     * @return a object
     */
    public Object getFirstObjectCollision(){
        return entity;
    }

    /**
     * Return the scene element of this collision
     * @return a object
     */
    public Object getSecondObjectCollision(){
        return sceneElement;
    }
}
