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
import java.util.ArrayList;


public class SceneLabyrinthMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1100;
    private final int height = 1000;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private Pane panel;
    private GraphicEngine graphicEngine;
    private Pacman pacman = new Pacman();

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

        Button pauseButton = new Button();
        pauseButton.setId("pauseButton");
        Image image = new Image(new File("ressources/textures/pause.png").toURI().toString());
        ImageView icon = new ImageView(image);
        icon.setFitWidth(60);
        icon.setFitHeight(60);
        pauseButton.setGraphic(icon);

        Label labelScore = new Label();
        setupScene.setLabel(labelScore, "Score : " + graphicEngine.getScore(), Pos.CENTER_LEFT, 300, -20, 80, 100, new Font(15), Paint.valueOf("black"), true);
        Label labelVie = new Label();
        setupScene.setLabel(labelVie, "Vie(s) restante(s) : ", Pos.CENTER_LEFT, 500, -20, 80, 300, new Font(15), Paint.valueOf("black"), true);
        labelScore.setId("labelScore");
        labelVie.setId("labelVie");

        for (int i = 0; i < pacman.getNumberOflife(); i++) {
            ImageView coeur = new ImageView();
            setupScene.setImageView(coeur, 630 + (25 * i), 7, 30, 30, new Image(new File("ressources/textures/coeur.png").toURI().toString()), true);
            panel.getChildren().add(coeur);
        }

        pauseButton.setOnMouseClicked((event) -> {
            try {
                setScenePause();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        panel.getChildren().addAll(pauseButton, labelScore, labelVie);
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
        graphicEngine.setCurrentScene(new ScenePauseMenu(stage, graphicEngine));
    }

}
