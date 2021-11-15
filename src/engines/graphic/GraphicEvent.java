package engines.graphic;

import java.util.EventListener;

public interface GraphicEvent {

    void notifyEvent(String event);

    void notifyEntityUpdate(GraphicEntity entity);

    void subscribeEvents(EventListener listener);
}