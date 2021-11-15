package apiUser;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class SceneFirstMenu implements ScenePacMan{

    private BorderPane root = new BorderPane();
    private final int widht = 400;
    private final int height = 300;
    private Scene scene = new Scene(root, widht, height);

    private void init(){

    }

    public Scene getScene(){
        return scene;
    }
}
