package pacman.scene;

import apiUser.SetupScene;
import engines.graphic.GraphicEngine;
import gameplay.ThreadEntity;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

/**
 * The scene of the labyrinth
 */
public class SceneLabyrinthMenu implements ScenePacMan {

    /**
     * The root of this scene
     */
    private final BorderPane root = new BorderPane();

    /**
     * The width of the scene
     */
    private final int width = 1100;

    /**
     * The height of the scene
     */
    private final int height = 1000;

    /**
     * The scene
     */
    private final Scene scene = new Scene(root, width, height);

    /**
     * The stage of this application
     */
    private final Stage stage;

    /**
     * The setup of a scene
     */
    private final SetupScene setupScene = new SetupScene();

    /**
     * The pane of this scene
     */
    private Pane pane;

    /**
     * The graphic engine
     */
    private final GraphicEngine graphicEngine;

    /**
     * <b>Constructor of SceneLabyrinthMenu</b>
     * @param stage
     *      a stage
     * @param graphicEngine
     *      a graphic engine
     */
    public SceneLabyrinthMenu(Stage stage, GraphicEngine graphicEngine) {
        assert stage != null : "Error : stage null";
        assert graphicEngine != null : "Error : graphic engine null";
        this.stage = stage;
        this.graphicEngine = graphicEngine;
    }

    /**
     * Return the scene of the labyrinth
     * @return a object type of Scene
     */
    public Scene getScene() {
        pane = new AnchorPane();
        graphicEngine.stopSound("intermission.wav");
        root.setId("background");
        File f = new File("ressources/styles/menu_style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        //The pause button
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

        pane.getChildren().addAll(pauseButton);
        root.getChildren().add(pane);
        root.setStyle("-fx-background-color: black;");
        graphicEngine.setControlEngineState(true);
        graphicEngine.setControlEngineScene(scene);
        return scene;
    }

    /**
     * Return the pane of this scene
     * @return a object type of Pane
     */
    public Pane getPane() {
        return pane;
    }

    /**
     * Return that this scene is a scene game
     * @return a boolean value equal to true
     */
    public boolean isSceneGame() {
        return true;
    }

    /**
     * Make pause to all entity thread
     * @throws InterruptedException
     */
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
