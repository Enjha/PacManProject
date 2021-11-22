package pacman;

import apiUser.SetupScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class SceneMainMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();

    public SceneMainMenu(Stage stage){
        this.stage = stage;
    }

    public void setScene(){
        AnchorPane anchorPane = new AnchorPane();

        Button buttonPlay = new Button("Jouer");
        setupScene.setButton(buttonPlay,"Jouer", Pos.CENTER,500,300,80,200,new Font(30),true);

        Button buttonQuit = new Button("Quitter");
        setupScene.setButton(buttonQuit,"Quitter", Pos.CENTER,500,500,80,200,new Font(20),true);

        Button buttonOption = new Button("Options");
        setupScene.setButton(buttonOption,"Options", Pos.CENTER,500,400,80,200,new Font(20),true);

        ImageView picturePacMan = new ImageView();
        setupScene.setImageView(picturePacMan,450,100,80,300,new Image(new File("ressources/textures/menu_logo.png").toURI().toString()),true);

        buttonOption.setOnMouseClicked((event)-> setSceneOption());
        buttonQuit.setOnMouseClicked((event)-> exit());
        buttonPlay.setOnMouseClicked((event)-> setScenePlay());

        anchorPane.getChildren().addAll(buttonOption,buttonQuit,buttonPlay,picturePacMan);
        root.getChildren().add(anchorPane);
        stage.setScene(scene);
        stage.show();
    }


    private void setSceneOption(){
        new SceneOptionMenu(stage).setScene();
    }

    private void exit(){
        System.exit(0);
    }

    private void setScenePlay(){
        new ScenePlayMenu(stage).setScene();
    }
}
