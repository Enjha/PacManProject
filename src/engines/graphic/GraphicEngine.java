package engines.graphic;

import apiUser.SceneAPIUser;
import engines.UI.Control;
import gameplay.Entity;
import gameplay.ThreadEntity;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import pacman.scene.SceneLabyrinthMenu;
import scene.SceneGame;

import java.awt.*;
import java.util.ArrayList;
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
    Entity getEntity(String name);
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
    void playSound(String soundName);
    void stopSound(String soundName);
    List<Thread> getCurrentsThreads();
    void setSolo(boolean solo);
    boolean getSolo();
}
