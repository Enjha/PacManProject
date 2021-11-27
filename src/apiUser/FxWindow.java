package apiUser;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FxWindow {

    private final int width;
    private final int height;
    private Scene scene;
    private final String sceneName;

    public FxWindow(int width, int height, String sceneName) {
        this.width = width;
        this.height = height;
        this.sceneName = sceneName;
    }

    public void openWindow(Stage stage) {
        BorderPane root = new BorderPane();
        scene = new Scene(root, width, height);
        stage.setTitle(sceneName);
        stage.setScene(scene);
        stage.show();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return this.scene;
    }

}