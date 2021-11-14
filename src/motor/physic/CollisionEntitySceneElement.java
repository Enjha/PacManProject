package motor.physic;

import gameplay.Entity;
import scene.SceneElement;

public class CollisionEntitySceneElement implements Collision{

    private Entity entity;
    private SceneElement sceneElement;

    public CollisionEntitySceneElement(Entity entity, SceneElement sceneElement){
        this.entity = entity;
        this.sceneElement = sceneElement;
    }

    public Object getFirstObjectCollision(){
        return entity;
    }

    public Object getSecondObjectCollision(){
        return sceneElement;
    }
}
