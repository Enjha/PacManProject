package engines.UI;

import engines.kernel.KernelEngine;
import gameplay.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.List;

/**
 * A classic control engine
 */
public class ClassicControlEngine implements ControlEngine {

    /**
     * The scene used bu this control engine
     */
    private Scene scene;

    /**
     * The control manager
     */
    private final ControlManager controlManager;

    /**
     * The engine state (on/off), by default its false
     */
    private boolean engineState = false;

    /**
     * The kernel engine connect to this control engine
     */
    private final KernelEngine kernelEngine;

    /**
     * <b>Constructor of ClassicControlEngine</b>
     * @param controlManager
     *      a control manager
     * @param kernelEngine
     *      a kernel engine
     */
    public ClassicControlEngine(ControlManager controlManager,KernelEngine kernelEngine){
        assert controlManager != null : "Error : control manager null";
        assert kernelEngine != null : "Error : kernel engine null";
        this.controlManager = controlManager;
        this.kernelEngine = kernelEngine;
    }

    /**
     * Detect the key pressed on the keyboard if the engine state is true and treat this key
     */
    private void getKeyPressed(){
        if(engineState) {
            assert scene != null : "Error : scene null";
            scene.setOnKeyPressed(key -> {
                Control control = controlManager.getControl(key.getText());
                //if a control has this key register
                if (control != null) {
                    printKeyPressed(key.getText());
                    getMovement(key.getText());
                }
            });
        }
    }

    /**
     * Modify a control's key with a new one
     * @param oldKey
     *      the old key
     * @param newKey
     *      the new key
     * @return a boolean value
     */
    public boolean setKey(String oldKey, String newKey){
        assert oldKey != null : "Error : old key null";
        assert newKey != null : "Error : new key null";
        return controlManager.setControl(oldKey, newKey);
    }

    /**
     * Return the control register with this key name
     * @param keyName
     *      a key name
     * @return a object type of Control
     */
    public Control getControl(String keyName){
        assert keyName != null : "Error : key name null";
       return controlManager.getControl(keyName);
    }

    /**
     * Return all control register to a entity
     * @param entity
     *      a entity
     * @return a list of object type of Control
     */
    public List<Control> getControl(Entity entity){
        assert entity != null : "Error : entity null";
        return controlManager.getControl(entity);
    }

    //A supprimer à la fin !!!!!!!!
    public void printKeyPressed(String key){
        System.out.println("Key Pressed: " + key);
    }

    /**
     * Return the movement register to a control with this key name
     * @param keyName
     *      a key name
     */
    private void getMovement(String keyName){
        assert keyName != null : "Error : key name null";
        Control control = getControl(keyName);
        assert control != null : "Error : control null";
        switch (control.getDirection()){
            case North:
                kernelEngine.setMovementEntity(new MovementNorth(control.getEntity()));
                break;
            case South:
                kernelEngine.setMovementEntity(new MovementSouth(control.getEntity()));
                break;
            case West:
                kernelEngine.setMovementEntity(new MovementWest(control.getEntity()));
                break;
            case East:
                kernelEngine.setMovementEntity(new MovementEast(control.getEntity()));
                break;
        }
    }

    /**
     * Modify the engine state with a new one
     * @param engineState
     *      a new engine state
     */
    public void setEngineState(boolean engineState){
        this.engineState = engineState;
    }

    /**
     * Modify the current scene
     * @param scene
     *      a new scene
     */
    public void setScene(Scene scene){
        assert scene != null : "Error : new scene null";
        this.scene = scene;
        getKeyPressed();
    }
}
