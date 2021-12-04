package pacman;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * The interface of the score
 */
public interface GameOver {

    /**
     * The score's label
     * @return a object type of Label
     */
    Label getLabelLastScore();
    Label getLabelGameOver();
    Button getButtonOption();

    Button getButtonQuit();

    /**
     * Return the Pane
     * @return a object type of Pane
     */
    Pane getGameOver();

    void callGameOver();
    /**
     * Modify the Pane
     * @param sceneGameOver
     *      a new Pane
     */
    void setSceneGameOVer(Pane sceneGameOver);
}
