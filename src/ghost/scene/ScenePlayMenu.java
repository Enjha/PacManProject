package ghost.scene;

import apiUser.SetupScene;
import engines.graphic.GraphicEngine;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ScenePlayMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private GraphicEngine graphicEngine;
    private Pane pane;

    public ScenePlayMenu(Stage stage, GraphicEngine graphicEngine){
        this.stage = stage;
        this.graphicEngine = graphicEngine;
    }

    public Scene getScene(){
        pane = new AnchorPane();

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

        pane.getChildren().addAll(labelTitle,buttonSolo,buttonMulti,buttonReturn);
        root.getChildren().add(pane);
        return scene;
    }

    private void setSceneReturnMenu(Stage stage){
        graphicEngine.setCurrentScene( new SceneMainMenu(stage, graphicEngine));
    }

    private void setSceneSoloMenu(Stage stage){
        graphicEngine.setCurrentScene(new SceneLabyrinthMenu(stage, graphicEngine));
    }

    private void setSceneMultiMenu(Stage stage){

    }

    public Pane getPanel(){
        return pane;
    }

    public boolean isSceneGame(){
        return false;
    }
}
