package pacman;

import apiUser.SetupScene;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import java.io.File;

public class ClassicGameOver implements GameOver{


    private final Label labelGameOver = new Label();
    private final Label labelLastScore = new Label();

    private ImageView picturePacMan = new ImageView();

    private Button buttonQuit = new Button("Quitter");
    private Button buttonOption = new Button("Options");

    private SetupScene setupScene = new SetupScene();
    private Pane pane;

    public ClassicGameOver(){
        setupScene.setImageView(picturePacMan,500,100,80,300,new Image(new File("ressources/textures/menu_logo.png").toURI().toString()),false);
        picturePacMan.setId("picturePacman");

        setupScene.setLabel(labelGameOver, "GAME OVER ! ", Pos.CENTER_LEFT, 500, 200, 160, 200, new Font(20), Paint.valueOf("black"), false);
        labelGameOver.setId("labelGameOver");

        setupScene.setLabel(labelLastScore, "Score final : ", Pos.CENTER_LEFT, 500, 300, 80, 200, new Font(20), Paint.valueOf("black"), false);
        labelLastScore.setId("labelLastScore");

        setupScene.setButton(buttonQuit,"Quitter", Pos.CENTER,500,500,80,200,new Font(20),false);
        setupScene.setButton(buttonOption,"Options", Pos.CENTER,500,400,80,200,new Font(20),false);
    }

    public Label getLabelGameOver() {
        return this.labelGameOver;
    }
    public Label getLabelLastScore() {
        return this.labelLastScore;
    }

    public void callGameOver() {
        if(!labelGameOver.isVisible()){
            Platform.runLater(
                () -> {
                    labelGameOver.setVisible(true);
                    labelLastScore.setVisible(true);
                    picturePacMan.setVisible(true);
                    buttonQuit.setVisible(true);
                    buttonOption.setVisible(true);
                    labelLastScore.setText("Score Final : + SCORE A AJOUTER");
                    System.out.println("Ca arrive, mais pas d'affichage");
                });
        }

    }

    @Override
    public Button getButtonOption() {
        return buttonOption;
    }

    @Override
    public Button getButtonQuit() {
        return buttonQuit;
    }

    @Override
    public Pane getGameOver() {
        return pane;
    }

    @Override
    public void setSceneGameOVer(Pane sceneGameOver) {
        assert(pane != null);
        this.pane = sceneGameOver;
        pane.getChildren().addAll(labelGameOver, picturePacMan, buttonOption, buttonQuit, labelLastScore);
        pane.setStyle("-fx-background-color: black;");
        pane.setVisible(true);
    }

}
