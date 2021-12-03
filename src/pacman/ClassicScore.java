package pacman;

import apiUser.SetupScene;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * A classic score
 */
public class ClassicScore implements Score {

    /**
     * The score's label
     */
    private final Label labelScore = new Label();

    /**
     * The score's value, by default its equal to 0
     */
    private int score = 0;

    /**
     * The pane
     */
    private Pane pane;

    /**
     * <b>Constructor of ClassicScore</b>
     */
    public ClassicScore() {
        new SetupScene().setLabel(labelScore, "Score : ", Pos.CENTER_LEFT, 300, -20, 80, 100, new Font(15), Paint.valueOf("black"), true);
        labelScore.setId("labelScore");
    }

    /**
     * Return the score's label
     * @return a object type of Label
     */
    public Label getLabel() {
        return this.labelScore;
    }

    /**
     * Return the score's value
     * @return a integer value
     */
    public int getScore() {
        return score;
    }

    /**
     * Add a value to the score's value
     * @param value
     *      a new value to add
     */
    public void addScore(int value) {
        assert(value > 0);
        score += value;
        Platform.runLater(
                () -> {
                    labelScore.setText("Score : " + score);
                });

    }

    /**
     * Return the pan
     * @return a object type of Pane
     */
    public Pane getSceneScore() {
        return pane;
    }

    /**
     * Modify the pane with a new one
     * @param pane
     *      a new pane
     */
    public void setSceneScore(Pane pane) {
        assert(pane != null);
        this.pane = pane;
        pane.getChildren().add(labelScore);
    }
}
