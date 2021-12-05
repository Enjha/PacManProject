package engines.UI;

import gameplay.Entity;

import java.util.List;

/**
 * The interface of a control manager
 */
public interface ControlManager {

    /**
     * Return all control register for a entity
     * @param entity
     *      a entity
     * @return a list of object type of Control
     */
    List<Control> getControl(Entity entity);

    /**
     * Return the control with this key
     * @param keyName
     *      a key name
     * @return a object type of Control
     */
    Control getControl(String keyName);

    /**
     * Modify a control's key with a new one
     * @param oldKey
     *      a old key
     * @param newKey
     *      a new key
     * @return a boolean value
     */
    boolean setControl(String oldKey, String newKey);

    /**
     * Add a new control
     * @param control
     *      a control to add
     */
    void addControl(Control control);

    /**
     * Remove a control
     * @param control
     *      a control to remove
     */
    void removeControl(Control control);
}
