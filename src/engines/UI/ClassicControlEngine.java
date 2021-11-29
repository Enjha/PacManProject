package engines.UI;

import gameplay.Entity;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.List;


public class ClassicControlEngine implements ControlEngine {

    private Scene scene;
    private ControlManager controlManager;
    private boolean engineState = false;

    public ClassicControlEngine(Scene scene, ControlManager controlManager){
        this.scene = scene;
        this.controlManager = controlManager;
        getKeyPressed();
    }

    private void getKeyPressed(){
        if(engineState) {
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent key) {
                    Control control = controlManager.getControl(key.getText());
                    if (control != null) {
                        // appelle methode moteur noyau pour donner le control
                        printKeyPressed(key.getText());
                    }
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

    public void setEngineState(boolean engineState){
        this.engineState = engineState;
    }
}
