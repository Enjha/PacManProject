package engines.UI;


import gameplay.Direction;
import gameplay.Entity;

import java.util.List;

public interface ControlEngine {

    boolean setKey(String oldKey, String newKey);
    Control getControl(String keyName);
    List<Control> getControl(Entity entity);
    void setEngineState(boolean engineState);
}
