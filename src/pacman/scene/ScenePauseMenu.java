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

public class ScenePauseMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private GraphicEngine graphicEngine;
    private Pane pane;

    public ScenePauseMenu(Stage stage, GraphicEngine graphicEngine) {
        this.graphicEngine = graphicEngine;
        this.stage = stage;
    }

    @Override
    public Pane getPanel() {
        return null;
    }

    @Override
    public boolean isSceneGame() {
        return false;
    }

    @Override
    public Scene getScene() {
        pane = new AnchorPane();
        root.setId("background");
        File f = new File("ressources/styles/menu_style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        Button buttonBack = new Button("Reprendre");
        setupScene.setButton(buttonBack, "Reprendre", Pos.CENTER, 500, 300, 80, 200, new Font(20), true);

        Button buttonOption = new Button("Options");
        setupScene.setButton(buttonOption, "Options", Pos.CENTER, 500, 400, 80, 200, new Font(20), true);

        Button buttonQuit = new Button("Quitter");
        setupScene.setButton(buttonQuit, "Quitter", Pos.CENTER, 500, 500, 80, 200, new Font(20), true);


        ImageView picturePacMan = new ImageView();
        setupScene.setImageView(picturePacMan, 400, -80, 400, 400, new Image(new File("ressources/textures/menu_pause.png").toURI().toString()), true);

        buttonBack.setOnMouseClicked((event) -> setSceneBackLabyrinth());
        buttonOption.setOnMouseClicked((event) -> setSceneOption());
        buttonQuit.setOnMouseClicked((event) -> setSceneMainMenu());

        pane.getChildren().addAll(buttonOption, buttonQuit, buttonBack, picturePacMan);
        root.getChildren().add(pane);

        return scene;
    }

    private synchronized void setSceneBackLabyrinth() {
        notifyAll();
        graphicEngine.setCurrentScene(graphicEngine.getPreviewScene());
    }

    private void setSceneOption() {
        graphicEngine.setCurrentScene(new SceneOptionMenu(stage, graphicEngine));
    }

    private void setSceneMainMenu() {
        graphicEngine.setPreviewScene(null);
        graphicEngine.setCurrentScene(new SceneMainMenu(stage, graphicEngine));
    }

}
