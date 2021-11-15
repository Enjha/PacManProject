package engines.kernel;

import engines.graphic.GraphicEntity;
import engines.physic.CollisionEntities;

public class Entity {

    private int id;

    private KernelEngine kernelEngine;

    private GraphicEntity graphicEntity;

    private CollisionEntities physicEntity;

    //private AiEntity aiEntity;

    public Entity(int id, KernelEngine kernelEngine, GraphicEntity graphicEntity, CollisionEntities physicEntity) {
        this.id = id;
        this.kernelEngine = kernelEngine;
        this.graphicEntity = graphicEntity;
        this.physicEntity = physicEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KernelEngine getKernelEngine() {
        return kernelEngine;
    }

    public void setKernelEngine(KernelEngine kernelEngine) {
        this.kernelEngine = kernelEngine;
    }

    public GraphicEntity getGraphicEntity() {
        return graphicEntity;
    }

    public void setGraphicEntity(GraphicEntity graphicEntity) {
        this.graphicEntity = graphicEntity;
    }

    public CollisionEntities getPhysicEntity() {
        return physicEntity;
    }

    public void setPhysicEntity(CollisionEntities physicEntity) {
        this.physicEntity = physicEntity;
    }

}
