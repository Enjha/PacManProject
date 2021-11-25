package engines.graphic;

import apiUser.FxWindow;
import apiUser.SceneAPIUser;
import engines.UI.Control;
import engines.kernel.KernelEngine;
import gameplay.Direction;
import gameplay.Entity;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class GraphicEngine {

    private final Stage stage;
    private FxWindow window;
    private final KernelEngine kernelEngine;

    public GraphicEngine(Stage stage,KernelEngine kernelEngine){
        this.stage = stage;
        this.kernelEngine = kernelEngine;
    }

    public void setFxWindow(int width, int height, String name){
        window = new FxWindow(width,height,name);
        window.openWindow(stage);
    }

    public void setCurrentScene(SceneAPIUser scene){
        window.setScene(scene.getScene());
    }

    public List<Control> getControl(Entity entity){
        return kernelEngine.getControl(entity);
    }

    public double getVolume(){
        return kernelEngine.getVolume();
    }

    public void setVolume(double volume){
        kernelEngine.setVolume(volume);
    }

    public Scene getCurrentScene(){
        return window.getScene();
    }

    public List<Entity> getEntities(){
        return kernelEngine.getEntities();
    }

    public boolean setControl(String oldKey,String newKey){
        return kernelEngine.setControl(oldKey,newKey);
    }

    public void mute(){
        kernelEngine.mute();
    }

    public void unmute(){
        kernelEngine.unmute();
    }

}
