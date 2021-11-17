package pacman;

import apiUser.SetupScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ScenePlayMenu implements ScenePacMan{

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();

    public ScenePlayMenu(Stage stage){
        this.stage = stage;
    }

    public void setScene(){
        AnchorPane anchorPane = new AnchorPane();

        Label labelTitle = new Label();
        setupScene.setLabel(labelTitle,"Jouer", Pos.CENTER,500,100,150,200,new Font(40), Paint.valueOf("black"),true);

        Button buttonSolo = new Button();
        setupScene.setButton(buttonSolo,"Solo",Pos.CENTER,500,300,80,200,new Font(20),true);

        Button buttonMulti = new Button();
        setupScene.setButton(buttonMulti,"Multi",Pos.CENTER,500,400,80,200,new Font(20),true);

        Button buttonReturn = new Button();
        setupScene.setButton(buttonReturn,"Retour",Pos.CENTER,500,500,80,200,new Font(20),true);

        buttonReturn.setOnMouseClicked((event)-> setSceneReturnMenu(stage));
        buttonSolo.setOnMouseClicked((event)-> setSceneSoloMenu(stage));
        buttonMulti.setOnMouseClicked((event)-> setSceneMultiMenu(stage));

        anchorPane.getChildren().addAll(labelTitle,buttonSolo,buttonMulti,buttonReturn);
        root.getChildren().add(anchorPane);
        stage.setScene(scene);
        stage.show();
    }

    private void setSceneReturnMenu(Stage stage){
        new SceneMainMenu(stage).setScene();
    }

    private void setSceneSoloMenu(Stage stage){

    }

    private void setSceneMultiMenu(Stage stage){

    }
}
