package pacman;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * The interface of the score
 */
public interface Score {

    /**
     * The score's label
     * @return a object type of Label
     */
    Label getLabel();

    /**
     * Return the score's value
     * @return a integer value
     */
    int getScore();

    /**
     * Add a value to the score
     * @param score
     *      a value to add
     */
    void addScore(int score);

    /**
     * Return the Pane
     * @return a object type of Pane
     */
    Pane getSceneScore();

    /**
     * Modify the Pane
     * @param sceneScore
     *      a new Pane
     */
    void setSceneScore(Pane sceneScore);
}
