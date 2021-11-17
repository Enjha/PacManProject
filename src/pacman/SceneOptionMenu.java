package pacman;

import apiUser.SetupScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneOptionMenu implements ScenePacMan {

    private BorderPane root = new BorderPane();
    private final int widht = 1200;
    private final int height = 800;
    private Scene scene = new Scene(root, widht, height);
    private Stage stage;
    private SetupScene setupScene = new SetupScene();
    private boolean stateSound = true;

    public SceneOptionMenu(Stage stage){
        this.stage = stage;
    }

    public void setScene(){
        AnchorPane anchorPane = new AnchorPane();

        Label labelTitle = new Label();
        setupScene.setLabel(labelTitle,"Options", Pos.CENTER,500,50,80,200,new Font(30), Paint.valueOf("black"),true);

        Slider SliderSoundVolume = new Slider();
        setupScene.setSlider(SliderSoundVolume,480,400,80,250,0.0,1.0,0.3,true); //recupérer valeur initial du son à partir du moteur noyau

        Label labelVolume = new Label();
        setupScene.setLabel(labelVolume,"Volume :",Pos.CENTER,450,350,80,300,new Font(20),Paint.valueOf("black"),true);

        Label labelVolumeLevel = new Label();
        setupScene.setLabel(labelVolumeLevel,""+(int)(SliderSoundVolume.getValue()*100),Pos.CENTER,730,400,80,100,new Font(20),Paint.valueOf("black"),true);

        Button buttonSound = new Button();
        setupScene.setButton(buttonSound,"Son : Activé",Pos.CENTER,500,200,80,200,new Font(20),true);

        SliderSoundVolume.valueProperty().addListener(observable -> {
            labelVolumeLevel.setText(""+(int)(SliderSoundVolume.getValue()*100));
            // modifier son avec moteur noyau
        });

        buttonSound.setOnMouseClicked((event)-> setStateSound(buttonSound));

        anchorPane.getChildren().addAll(labelTitle,SliderSoundVolume,labelVolumeLevel,labelVolume,buttonSound);
        root.getChildren().add(anchorPane);
        stage.setScene(scene);
        stage.show();
    }

    private void setStateSound(Button soundButton){
        if(stateSound){
            stateSound = false;
            soundButton.setText("Son : Désactivé");
            // mettre son à 0 avec moteur noyau
        }
        else {
            stateSound = true;
            soundButton.setText("Son : Activé");
            // mettre son avec valeur du moteur son avec moteur noyau
        }
    }
}
