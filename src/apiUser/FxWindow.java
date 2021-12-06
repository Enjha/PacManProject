package apiUser;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The window of the application
 */
public class FxWindow {

    /**
     * The window's width
     */
    private final int width;

    /**
     * The window's height
     */
    private final int height;

    /**
     * The scene API user set in this window
     */
    private SceneAPIUser sceneAPIUser;

    /**
     * The scene's name
     */
    private final String sceneName;

    /**
     * The stage of the application
     */
    private final Stage stage;

    /**
     * <b>Constructor of FxWindow</b>
     * @param width
     *      a window's width
     * @param height
     *      a window's height
     * @param sceneName
     *      a scene game
     * @param stage
     *      a stage
     */
    public FxWindow(int width, int height,String sceneName,Stage stage){
        assert width > 0 : "Error : width <= 0";
        assert height > 0 : "Error : height <= 0";
        assert sceneName != null : "Error : scene name null";
        assert stage != null : "Error : stage null";

        this.width = width;
        this.height = height;
        this.sceneName = sceneName;
        this.stage = stage;
    }

    /**
     * Open and show the window
     */
    public void openWindow(){
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, width, height);
        stage.setTitle(sceneName);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Modify the current scene API user
     * @param sceneAPIUser
     *      a new scene API user
     */
    public void setScene(SceneAPIUser sceneAPIUser){
        assert sceneAPIUser != null : "Error scene API user null";

        this.sceneAPIUser = sceneAPIUser;
        assert sceneAPIUser.getScene() != null : "Error : scene null";
        stage.setScene(sceneAPIUser.getScene());
        stage.show();
    }

    /**
     * Return the current scene API user
     * @return a object type of SceneAPIUser
     */
    public SceneAPIUser getScene(){
        return sceneAPIUser;
    }

}