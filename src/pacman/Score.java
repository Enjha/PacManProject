package pacman;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public interface Score {
    Label getLabel();

    int getScore();

    void setScore(int score);

    Pane getSceneScore();

    void setSceneScore(Pane sceneScore);

    void setVisible(boolean visibility);
}
