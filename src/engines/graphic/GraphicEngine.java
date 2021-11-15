package engines.graphic;

import java.util.ArrayList;
import java.util.EventListener;

public class GraphicEngine implements GraphicEvent{

    private final ArrayList<EventListener> eventsListeners = new ArrayList<>();

    @Override
    public void notifyEvent(String event) {
        for(int i = 0; i < eventsListeners.size(); i++){
            //notifier l'evenement sur l'élément i de l'arraylist
        }
    }

    @Override
    public void notifyEntityUpdate(GraphicEntity entity) {
        for(int i = 0; i < eventsListeners.size(); i++){
            //notifier les entités sur l"élément i
        }
    }

    @Override
    public void subscribeEvents(EventListener listener) {

    }
}
