package engines.UI;

import gameplay.Entity;
import javafx.scene.Scene;

import java.util.List;

/**
 * The interfacr of a control engine
 */
public interface ControlEngine {

    /**
     * Modify a control's key with a new one
     * @param oldKey
     *      a old key
     * @param newKey
     *      a new key
     * @return a boolean value
     */
    boolean setKey(String oldKey, String newKey);

    /**
     * Return a control with his name
     * @param keyName
     *      a key name
     * @return a object type of Control
     */
    Control getControl(String keyName);

    /**
     * Return all control register for a entity
     * @param entity
     *      a entity
     * @return a list of objet type of Control
     */
    List<Control> getControl(Entity entity);

    /**
     * Modify the engine state with a new one
     * @param engineState
     *      a new engine state
     */
    void setEngineState(boolean engineState);

    /**
     * Midify the current scene with a new one
     * @param scene
     *      a new scene
     */
    void setScene(Scene scene);
}
