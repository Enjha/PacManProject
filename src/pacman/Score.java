package pacman;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public interface Score {
    Label getLabel();

    int getScore();

    void addScore(int score);

    Pane getSceneScore();

    void setSceneScore(Pane sceneScore);
}
