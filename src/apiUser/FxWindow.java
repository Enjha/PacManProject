package apiUser;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FxWindow {

    private int width;
    private int height;
    private SceneAPIUser sceneAPIUser;
    private Scene scene;
    private BorderPane root;
    private String sceneName;
    private Stage stage;

    public FxWindow(int width, int height,String sceneName,Stage stage){
        this.width = width;
        this.height = height;
        this.sceneName = sceneName;
        this.stage = stage;
    }

    public void openWindow(){
        root = new BorderPane();
        scene = new Scene(root, width, height);
        stage.setTitle(sceneName);
        stage.setScene(scene);
        stage.show();
    }

    public void setScene(SceneAPIUser sceneAPIUser){
        this.sceneAPIUser = sceneAPIUser;
        stage.setScene(sceneAPIUser.getScene());
        stage.show();
    }

    public SceneAPIUser getScene(){
        return sceneAPIUser;
    }

}