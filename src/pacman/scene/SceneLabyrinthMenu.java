package pacman.scene;

import apiUser.SetupScene;
import engines.graphic.GraphicEngine;
import gameplay.ThreadEntity;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pacman.Pacman;

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
        graphicEngine.stopSound("credit.wav");
        root.setId("background");
        File f = new File("ressources/styles/menu_style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        Button pauseButton = new Button();
        pauseButton.setId("pauseButton");
        Image image = new Image(new File("ressources/textures/pause.png").toURI().toString());
        ImageView icon = new ImageView(image);
        icon.setFitWidth(60);
        icon.setFitHeight(60);
        pauseButton.setGraphic(icon);

        pauseButton.setOnMouseClicked((event) -> {
            try {
                setScenePause();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        panel.getChildren().addAll(pauseButton);
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

    private synchronized void setScenePause() throws InterruptedException {
        for (Thread t : graphicEngine.getCurrentsThreads()) {
            System.out.println(t.getName() + " : " + t.getState());
            ((ThreadEntity) t).setPause(true);
        }
        graphicEngine.setPreviewScene(this);
        graphicEngine.stopSound("game_start.wav");
        graphicEngine.setCurrentScene(new ScenePauseMenu(stage, graphicEngine));
    }

}
