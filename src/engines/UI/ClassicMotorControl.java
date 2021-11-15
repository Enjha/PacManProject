package engines.UI;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;


public class ClassicMotorControl implements MotorControl{

    private Scene scene;
    private ControlManager controlManager;

    public ClassicMotorControl(Scene scene, ControlManager controlManager){
        this.scene = scene;
        this.controlManager = controlManager;
        getKeyPressed();
    }

    private void getKeyPressed(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                Control control = controlManager.getControl(key.getText());
                if(control != null){
                    // appelle methode moteur noyau pour donner le control
                    printKeyPressed(key.getText());
                }
            }
        });
    }

    public void setKey(String oldKey, String newKey){
        if(!controlManager.setControl(oldKey,newKey)){
            System.out.println("La touche " + oldKey + " n'est pas enregistrer");
        }
        else {
            System.out.println("La touche " + newKey + " est enregistrer");
        }
    }

    public void printKeyPressed(String key){
        System.out.println("Key Pressed: " + key);
    }


}
