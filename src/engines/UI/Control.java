package engines.UI;

import gameplay.Direction;
import gameplay.Entity;

public interface Control {

    String getKey();
    void setKey(String key);
    Direction getDirection();
    Entity getEntity();
}
