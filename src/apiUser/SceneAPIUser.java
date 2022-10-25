package apiUser;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * The interface of a scene API user
 */
public interface SceneAPIUser {

    /**
     * Return the scene
     * @return a object type of Scene
     */
    Scene getScene();

    /**
     * Return the pane
     * @return a object type of Pane
     */
    Pane getPane();

    /**
     * Return if the scene is a game's scene
     * @return a boolean value
     */
    boolean isSceneGame();
}
