package engines.graphic;

import apiUser.SceneAPIUser;
import engines.UI.Control;
import gameplay.Entity;
import javafx.scene.Scene;
import pacman.scene.SceneLabyrinthMenu;
import scene.SceneGame;

import java.util.List;

public interface GraphicEngine {

    void setFxWindow(int width, int height, String name);
    void setSceneGameTexture(SceneGame sceneGame);
    void setSceneGameEntity(SceneGame sceneGame);
    void setCurrentScene(SceneAPIUser scene);
    void setPreviewScene(SceneAPIUser scene);
    SceneAPIUser getPreviewScene();
    List<Control> getControl(Entity entity);
    double getVolume();
    void setVolume(double volume);
    Scene getCurrentScene();
    List<Entity> getEntities();
    boolean setControl(String oldKey,String newKey);
    void mute();
    void unmute();
    SceneGame getSceneGame();
    void setControlEngineState(boolean state);
    void setControlEngineScene(Scene scene);
    void updateSceneGame(Entity entity);
    ImageViewEntities getImageViewEntities(Entity entity);
}
