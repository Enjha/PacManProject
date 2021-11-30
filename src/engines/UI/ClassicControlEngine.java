package engines.UI;

import engines.kernel.KernelEngine;
import gameplay.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.List;


public class ClassicControlEngine implements ControlEngine {

    private Scene scene;
    private final ControlManager controlManager;
    private boolean engineState = false;
    private KernelEngine kernelEngine;

    public ClassicControlEngine(ControlManager controlManager,KernelEngine kernelEngine){
        this.controlManager = controlManager;
        this.kernelEngine = kernelEngine;
    }

    private void getKeyPressed(){
        if(engineState) {
            scene.setOnKeyPressed(key -> {
                Control control = controlManager.getControl(key.getText());
                if (control != null) {
                    printKeyPressed(key.getText());
                    getMovement(key.getText());
                }
            });
        }
    }

    public boolean setKey(String oldKey, String newKey){
        if(!controlManager.setControl(oldKey,newKey)){
            return false;
        }
        return true;
    }

    public Control getControl(String keyName){
       return controlManager.getControl(keyName);
    }

    public List<Control> getControl(Entity entity){
        return controlManager.getControl(entity);
    }

    public void printKeyPressed(String key){
        System.out.println("Key Pressed: " + key);
    }

    private void getMovement(String key){
        Control control = getControl(key);
        if(control != null){
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
        else{
            System.err.println("error : control null");
            System.exit(-1);
        }
    }

    public void setEngineState(boolean engineState){
        this.engineState = engineState;
    }

    public void setScene(Scene scene){
        this.scene = scene;
        getKeyPressed();
    }
}
