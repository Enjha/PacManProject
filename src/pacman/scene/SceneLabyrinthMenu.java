package pacman.scene;

import apiUser.SetupScene;
import engines.graphic.GraphicEngine;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SceneLabyrinthMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1100;
    private final int height = 1000;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private Pane panel;
    private GraphicEngine graphicEngine;

    public SceneLabyrinthMenu(Stage stage, GraphicEngine graphicEngine){
        this.stage = stage;
        this.graphicEngine = graphicEngine;
    }

    public Scene getScene(){
        panel = new AnchorPane();
        root.getChildren().add(panel);
        return scene;
    }

    public Pane getPanel(){
        return panel;
    }

    public boolean isSceneGame(){
        return true;
    }
}
