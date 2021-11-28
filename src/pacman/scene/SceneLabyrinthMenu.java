package pacman.scene;

import apiUser.SetupScene;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SceneLabyrinthMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();

    public SceneLabyrinthMenu(Stage stage){
        this.stage = stage;
    }

    public Scene getScene(){
        AnchorPane anchorPane = new AnchorPane();



        root.getChildren().add(anchorPane);
        return scene;
    }
}
