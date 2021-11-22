package engines.graphic;

import apiUser.FxWindow;
import apiUser.SceneAPIUser;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GraphicEngine {

    private Stage stage;
    private Scene currentScene;
    private FxWindow window;

    public GraphicEngine(Stage stage){
        this.stage = stage;
    }

    public void setFxWindow(int width, int height,String name){
        window = new FxWindow(width,height,name,stage);
        window.openWindow();
    }

    public void setCurrentScene(SceneAPIUser scene){
        window.setScene(scene.getScene());
        currentScene = scene.getScene();
    }

}
