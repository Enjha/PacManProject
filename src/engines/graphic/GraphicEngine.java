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

/**
 * The interface of a graphic engine
 */
public interface GraphicEngine {

    /**
     * Modify the window of this application
     * @param width
     *      the window's width
     * @param height
     *      the window's height
     * @param name
     *      the window's name
     */
    void setFxWindow(int width, int height, String name);

    /**
     * Setup the scene game texture
     * @param sceneGame
     *      a scene game
     */
    void setSceneGameTexture(SceneGame sceneGame);

    /**
     * Setup the scene game entity
     * @param sceneGame
     *      a scene game
     */
    void setSceneGameEntity(SceneGame sceneGame);

    /**
     * Modify the current scene display
     * @param scene
     *      a new scene
     */
    void setCurrentScene(SceneAPIUser scene);

    /**
     * Modify the preview scene
     * @param scene
     *      a new scene
     */
    void setPreviewScene(SceneAPIUser scene);

    /**
     * Return the preview scene
     * @return a object type of SceneAPIUser
     */
    SceneAPIUser getPreviewScene();

    /**
     * Return the control of a entity
     * @param entity
     *      a entity
     * @return a list of object type of Control
     */
    List<Control> getControl(Entity entity);

    /**
     * Return the sound's volume
     * @return a double value
     */
    double getVolume();

    /**
     * Modify the sound's volume with a new value
     * @param volume
     *      a new volume
     */
    void setVolume(double volume);

    /**
     * Return the entity with tis name
     * @param name
     *      a entity's name
     * @return a object type of Entity
     */
    Entity getEntity(String name);

    /**
     * Return the current scene display
     * @return a object type of Scene
     */
    Scene getCurrentScene();

    /**
     * Return all entities
     * @return a list of object type of Entity
     */
    List<Entity> getEntities();

    /**
     * Modify the key of a control with a new one
     * @param oldKey
     *      a old key
     * @param newKey
     *      a new key
     * @return a boolean value
     */
    boolean setControl(String oldKey,String newKey);

    /**
     * Mute all sound
     */
    void mute();

    /**
     * Unmute all sound
     */
    void unmute();

    /**
     * Return the current scene game
     * @return a object type of SceneGame
     */
    SceneGame getSceneGame();

    /**
     * Modify the control engine state with a new state
     * @param state
     *      a new controle engine state
     */
    void setControlEngineState(boolean state);

    /**
     * Modigy the control engine scene with a new one
     * @param scene
     *      a new scene
     */
    void setControlEngineScene(Scene scene);

    /**
     * Update the scene game with a entity
     * @param entity
     *      a entity
     */
    void updateSceneGame(Entity entity);

    /**
     * Return the image view entities of a entity or null if the entity don't have a image view entities
     * @param entity
     *      a entity
     * @return a object type of ImageViewEntities
     */
    ImageViewEntities getImageViewEntities(Entity entity);

    /**
     * Return all label of a pane
     * @param pane
     *      a pane
     * @return a list of object type of Label
     */
    List<Label> getLabels(Pane pane);

    /**
     * Play a sound with his name
     * @param soundName
     *      a sound's name
     */
    void playSound(String soundName);

    /**
     * Stop a sound with his name
     * @param soundName
     *      a sound's name
     */
    void stopSound(String soundName);

    /**
     * Return all entities thread
     * @return a list of object type of Thread
     */
    List<Thread> getCurrentsThreads();

    /**
     * Modify if the game mode is solo
     * @param solo
     *      the state
     */
    void setSolo(boolean solo);

    /**
     * Return the game mode solo state
     * @return a boolean value
     */
    boolean getSolo();
}
