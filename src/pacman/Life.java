package pacman;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public interface Life {

    ArrayList<ImageView> getImageViews();

    int getNumberOfLife();

    void setNumberOfLife(int score);

    Pane getSceneLife();

    void setSceneLife(Pane sceneScore);
}
