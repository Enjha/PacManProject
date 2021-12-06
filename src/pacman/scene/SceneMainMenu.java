package pacman.scene;

import apiUser.SetupScene;
import engines.graphic.GraphicEngine;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

/**
 * Scene main menu
 */
public class SceneMainMenu implements ScenePacMan {

    /**
     * The root of this scene
     */
    private final BorderPane root = new BorderPane();

    /**
     * The width of this scene
     */
    private final int width = 1200;

    /**
     * the height of this scene
     */
    private final int height = 800;

    /**
     * The scene
     */
    private final Scene scene = new Scene(root, width, height);

    /**
     * The stage of this application
     */
    private final Stage stage;

    /**
     * The setup of the scene
     */
    private final SetupScene setupScene = new SetupScene();

    /**
     * the graphic engine
     */
    private final GraphicEngine graphicEngine;

    /**
     * The pane of this scene
     */
    private Pane pane;

    /**
     * <b>Constructor of SceneMainMenu</b>
     * @param stage
     *      a stage
     * @param graphicEngine
     *      a graphicEngine
     */
    public SceneMainMenu(Stage stage, GraphicEngine graphicEngine){
        assert stage != null : "Error : stage nul";
        assert graphicEngine != null : "Error : graphic engine null";

        this.stage = stage;
        this.graphicEngine = graphicEngine;
    }

    /**
     * Return the scene of the main menu
     * @return a object type of Scene
     */
    public Scene getScene(){
        pane = new AnchorPane();
        root.setId("background");
        File f = new File("ressources/styles/menu_style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

        Button buttonPlay = new Button("Jouer");
        setupScene.setButton(buttonPlay,"Jouer", Pos.CENTER,500,300,80,200,new Font(30),true);

        Button buttonQuit = new Button("Quitter");
        setupScene.setButton(buttonQuit,"Quitter", Pos.CENTER,500,500,80,200,new Font(20),true);

        Button buttonOption = new Button("Options");
        setupScene.setButton(buttonOption,"Options", Pos.CENTER,500,400,80,200,new Font(20),true);

        ImageView picturePacMan = new ImageView();
        Image logoImage = new Image(new File("ressources/textures/menu_logo.png").toURI().toString());
        assert !logoImage.isError() : "Error : width";
        setupScene.setImageView(picturePacMan,450,100,80,300,logoImage,true);

        buttonOption.setOnMouseClicked((event)-> setSceneOption());
        buttonQuit.setOnMouseClicked((event)-> exit());
        buttonPlay.setOnMouseClicked((event)-> setScenePlay());

        graphicEngine.playSound("intermission.wav");

        pane.getChildren().addAll(buttonOption,buttonQuit,buttonPlay,picturePacMan);
        root.getChildren().add(pane);

        return scene;
    }

    /**
     * Set the scene to the scene option
     */
    private void setSceneOption(){
        graphicEngine.setPreviewScene(this);
        graphicEngine.setCurrentScene(new SceneOptionMenu(stage, graphicEngine));
    }

    /**
     * Exit the game
     */
    private void exit(){
        System.exit(0);
    }

    /**
     * Set the scene to the scene play
     */
    private void setScenePlay(){
        graphicEngine.setCurrentScene(new ScenePlayMenu(stage, graphicEngine));
    }

    /**
     * Return the pane of this scene
     * @return
     */
    public Pane getPane(){
        return pane;
    }

    /**
     * Return that scene is not a scene game
     * @return a boolean value equal to false
     */
    public boolean isSceneGame(){
        return false;
    }
}
