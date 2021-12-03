package pacman;

import apiUser.SetupScene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.awt.*;

public class ClassicScore implements Score {

    private final Label labelScore = new Label();
    private int score = 0;
    private Pane pane;
    private boolean visibility = false;

    public ClassicScore() {
        new SetupScene().setLabel(labelScore, "Score : ", Pos.CENTER_LEFT, 300, -20, 80, 100, new Font(15), Paint.valueOf("black"), visibility);
    }

    public Label getLabel() {
        return this.labelScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        this.labelScore.setText("Score : " + score);
    }

    public Pane getSceneScore() {
        return pane;
    }

    public void setSceneScore(Pane pane) {
        this.pane = pane;
        pane.getChildren().add(labelScore);
    }

    public void setVisible(boolean visibility) {
        this.visibility = visibility;
    }

}
