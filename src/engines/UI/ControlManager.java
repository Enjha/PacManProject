package engines.UI;

public interface ControlManager {

    Control getControl(String key);
    boolean setControl(String oldKey, String newKey);
}
