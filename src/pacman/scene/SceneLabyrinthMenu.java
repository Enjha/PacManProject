package pacman.scene;

import apiUser.SetupScene;
import engines.graphic.ClassicGraphicEngine;
import engines.graphic.GraphicEngine;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class SceneLabyrinthMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1300;
    private final int height = 900;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private Pane pane;
    private GraphicEngine graphicEngine;

    public SceneLabyrinthMenu(Stage stage, GraphicEngine graphicEngine){
        this.stage = stage;
        this.graphicEngine = graphicEngine;
    }

    public Scene getScene(){
        pane = new AnchorPane();
        root.getChildren().add(pane);
        return scene;
    }

    public Pane getPane(){
        return pane;
    }

    public boolean isSceneGame(){
        return true;
    }
}
