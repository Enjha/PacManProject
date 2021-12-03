package engines.graphic;

import java.util.EventListener;

public interface GraphicEvents {

    void notifyEvent(String event);

    void subscribeEvents(EventListener listener);
}