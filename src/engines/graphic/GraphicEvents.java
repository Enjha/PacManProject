package engines.graphic;

import java.util.EventListener;

public interface GraphicEvents {

    void notifyEvent(String event);

    void notifyEntityUpdate(GraphicEntity entity);

    void subscribeEvents(EventListener listener);
}