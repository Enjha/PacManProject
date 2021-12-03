package pacman;

import apiUser.SetupScene;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class ClassicScore implements Score {

    private final Label labelScore = new Label();
    private int score = 0;
    private Pane pane;

    public ClassicScore() {
        new SetupScene().setLabel(labelScore, "Score : ", Pos.CENTER_LEFT, 300, -20, 80, 100, new Font(15), Paint.valueOf("black"), true);
        labelScore.setId("labelScore");
    }

    public Label getLabel() {
        return this.labelScore;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int value) {
        score += value;
        Platform.runLater(
                () -> {
                    labelScore.setText("Score : " + score);
                });

    }

    public Pane getSceneScore() {
        return pane;
    }

    public void setSceneScore(Pane pane) {
        this.pane = pane;
        pane.getChildren().add(labelScore);
    }
}
