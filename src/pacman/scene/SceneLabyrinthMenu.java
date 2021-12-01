package pacman.scene;

import apiUser.SetupScene;
import engines.graphic.GraphicEngine;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;


public class SceneLabyrinthMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1100;
    private final int height = 1000;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private Pane panel;
    private GraphicEngine graphicEngine;

    public SceneLabyrinthMenu(Stage stage, GraphicEngine graphicEngine) {
        this.stage = stage;
        this.graphicEngine = graphicEngine;
    }

    public Scene getScene() {
        panel = new AnchorPane();
        root.setId("background");
        File f = new File("ressources/styles/menu_style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        Button buttonSetting = new Button();
        buttonSetting.setId("buttonSetting");
        Image image = new Image(new File("ressources/textures/setting.png").toURI().toString());
        ImageView icon = new ImageView(image);
        icon.setFitWidth(50);
        icon.setFitHeight(50);
        buttonSetting.setGraphic(icon);
        setupScene.setButton(buttonSetting, "", Pos.CENTER, 20, 20, 80, 80, new Font(30), true);
        buttonSetting.setOnMouseClicked((event) -> setSceneOption());

        panel.getChildren().addAll(buttonSetting);
        root.getChildren().add(panel);
        root.setStyle("-fx-background-color: black;");
        graphicEngine.setControlEngineState(true);
        graphicEngine.setControlEngineScene(scene);
        return scene;
    }

    public Pane getPanel() {
        return panel;
    }

    public boolean isSceneGame() {
        return true;
    }

    private void setSceneOption() {
        graphicEngine.setCurrentScene(new SceneOptionMenu(stage, graphicEngine));
    }

}
