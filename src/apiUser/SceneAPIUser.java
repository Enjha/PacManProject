package apiUser;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public interface SceneAPIUser {

    Scene getScene();
    Pane getPanel();
    boolean isSceneGame();
}
