package engines.graphic;

import engines.kernel.Entity;

public class EngineEntity {

    protected Entity parent;

    public EngineEntity(Entity parent){
        this.parent = parent;
    }

    public Entity getParent(){return parent;}

    public void setParent(Entity parent){
        this.parent = parent;
    }

}
