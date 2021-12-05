package engines.UI;

import gameplay.Direction;
import gameplay.Entity;

/**
 * The interface of a control
 */
public interface Control {

    /**
     * Return the control's key
     * @return a string value
     */
    String getKeyName();

    /**
     * Modify the control's key with a new one
     * @param keyName
     *      a new key
     */
    void setKeyName(String keyName);

    /**
     * Return the control's direction
     * @return a object type of Direction
     */
    Direction getDirection();

    /**
     * Return the control's entity
     * @return a object type of Entity
     */
    Entity getEntity();
}
