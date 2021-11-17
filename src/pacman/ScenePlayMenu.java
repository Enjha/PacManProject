package pacman;

import apiUser.SetupScene;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScenePlayMenu implements ScenePacMan{

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private boolean stateSound = true;

    public ScenePlayMenu(Stage stage){
        this.stage = stage;
    }

    public void setScene(){

    }
}
