package engines.UI;

import gameplay.Direction;
import gameplay.Entity;

import java.util.List;

public interface ControlManager {

    List<Control> getControl(Entity entity);
    Control getControl(String key);
    boolean setControl(String oldKey, String newKey);
    void addControl(Control control);
    void removeControl(Control control);
}
