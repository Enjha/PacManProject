package engines.graphic;

import gameplay.Entity;

public interface EventListener {

    void onEvent(String event);
    void onEntityEvent(Entity entity, String eventName);
    void onEntityUpdate(EngineEntity entity);
}
