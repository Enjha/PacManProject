package engines.graphic;

import apiUser.FxWindow;
import apiUser.SceneAPIUser;
import engines.UI.Control;
import engines.kernel.KernelEngine;
import gameplay.Entity;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pacman.Life;
import pacman.Score;
import scene.SceneGame;

import java.util.ArrayList;
import java.util.List;

/**
 * A classic graphic engine
 */
public class ClassicGraphicEngine implements GraphicEngine {

    /**
     * The stage of this application
     */
    private final Stage stage;

    /**
     * The window of this application
     */
    private FxWindow window;


    /**
     * The kernel engine connect to this graphic engine
     */
    private final KernelEngine kernelEngine;

    /**
     * The converter of a scene to a graphic
     */
    private final ConvertSceneToGraphic convertSceneToGraphic;

    /**
     * The preview scene
     */
    private SceneAPIUser previewScene;

    /**
     * A list of label of the pane
     */
    private List<Label> labels = new ArrayList<>();

    /**
     * The game mode solo, by default its true
     */
    private boolean solo = true;

    /**
     * <b>Constructor of ClassicGraphicEngine</b>
     * @param stage
     *      a stage
     * @param kernelEngine
     *      a kernel engine
     * @param convertSceneToGraphic
     *      a converter scene to graphic
     */
    public ClassicGraphicEngine(Stage stage, KernelEngine kernelEngine, ConvertSceneToGraphic convertSceneToGraphic) {
        assert stage != null : "Error : stage null";
        assert kernelEngine != null : "Error : kernel engine null";
        assert convertSceneToGraphic != null : "Error : converter null";
        this.stage = stage;
        this.kernelEngine = kernelEngine;
        this.convertSceneToGraphic = convertSceneToGraphic;
    }

    /**
     * Modify the window of this application
     * @param width
     *      the window's width
     * @param height
     *      the window's height
     * @param name
     *      the window's name
     */
    public void setFxWindow(int width, int height, String name) {
        assert width > 0 : "Error : width <= 0";
        assert height > 0 : "Error : height <= 0";
        assert name != null : "Error : name null";
        window = new FxWindow(width, height, name, stage);
        window.openWindow();
    }

    /**
     * Setup the scene game texture
     * @param sceneGame
     *      a scene game
     */
    public void setSceneGameTexture(SceneGame sceneGame) {
        assert sceneGame != null : "Error : scene game null";
        convertSceneToGraphic.setLabyrinthTextureScene(sceneGame, window.getScene().getPane());
    }

    /**
     * Setup the scene game entity
     * @param sceneGame
     *      a scene game
     */
    public void setSceneGameEntity(SceneGame sceneGame) {
        assert sceneGame != null : "Error : scene game null";
        assert window.getScene() != null : "Error : window scene null";
        convertSceneToGraphic.setEntityTextureScene(sceneGame, window.getScene().getPane());
    }

    /**
     * Modify the current scene display
     * @param scene
     *      a new scene
     */
    public void setCurrentScene(SceneAPIUser scene) {
        assert scene != null : "Error : scene null";
        assert kernelEngine.getLife() != null : "Error : kernel engine --> life null";
        assert kernelEngine.getScore() != null : "Error : kernel engine --> score null";
        assert kernelEngine.getSceneGame() != null : "Error : kernel engine --> scene game null";
        window.setScene(scene);
        if (window.getScene().isSceneGame()) {
            kernelEngine.createThreadEntities();
            setSceneGameTexture(kernelEngine.getSceneGame());
            setSceneGameEntity(kernelEngine.getSceneGame());
            Score score = kernelEngine.getScore();
            Life life = kernelEngine.getLife();
            score.setSceneScore(scene.getPane());
            life.setSceneLife(scene.getPane());
        }
    }

    /**
     * Modify the preview scene
     * @param scene
     *      a new scene
     */
    public void setPreviewScene(SceneAPIUser scene) {
        assert scene != null : "Error : scene null";
        this.previewScene = scene;
    }

    /**
     * Return the preview scene
     * @return a object type of SceneAPIUser
     */
    public SceneAPIUser getPreviewScene() {
        return previewScene;
    }

    /**
     * Return the control of a entity
     * @param entity
     *      a entity
     * @return a list of object type of Control
     */
    public List<Control> getControl(Entity entity) {
        assert entity != null : "Error : entity null";
        return kernelEngine.getControl(entity);
    }

    /**
     * Return the sound's volume
     * @return a double value
     */
    public double getVolume() {
        return kernelEngine.getVolume();
    }

    /**
     * Modify the sound's volume with a new value
     * @param volume
     *      a new volume
     */
    public void setVolume(double volume) {
        assert volume >= 0 : "Error : volume < 0";
        kernelEngine.setVolume(volume);
    }

    /**
     * Return the entity with tis name
     * @param name
     *      a entity's name
     * @return a object type of Entity
     */
    public Entity getEntity(String name){
        assert name != null : "Error : name null";
        return kernelEngine.getEntity(name);
    }

    /**
     * Return the current scene display
     * @return a object type of Scene
     */
    public Scene getCurrentScene() {
        return window.getScene().getScene();
    }

    /**
     * Return all entities
     * @return a list of object type of Entity
     */
    public List<Entity> getEntities() {
        return kernelEngine.getEntities();
    }

    /**
     * Modify the key of a control with a new one
     * @param oldKey
     *      a old key
     * @param newKey
     *      a new key
     * @return a boolean value
     */
    public boolean setControl(String oldKey, String newKey) {
        assert oldKey != null : "Error : old key null";
        assert newKey != null : "Error : new key null";
        return kernelEngine.setControl(oldKey, newKey);
    }

    /**
     * Mute all sound
     */
    public void mute() {
        kernelEngine.mute();
    }

    /**
     * Unmute all sound
     */
    public void unmute() {
        kernelEngine.unmute();
    }

    /**
     * Return the current scene game
     * @return a object type of SceneGame
     */
    public SceneGame getSceneGame() {
        return kernelEngine.getSceneGame();
    }

    /**
     * Modify the control engine state with a new state
     * @param state
     *      a new controle engine state
     */
    public void setControlEngineState(boolean state) {
        kernelEngine.setControlEngineState(state);
    }

    /**
     * Modigy the control engine scene with a new one
     * @param scene
     *      a new scene
     */
    public void setControlEngineScene(Scene scene) {
        assert scene != null : "Error : scene null";
        kernelEngine.setControlEngineScene(scene);
    }

    /**
     * Update the scene game with a entity
     * @param entity
     *      a entity
     */
    public void updateSceneGame(Entity entity) {
        assert entity != null : "Error : entity null";
        ImageViewEntities imageViewEntities = getImageViewEntities(entity);
        assert imageViewEntities != null : "Error : image view entities null";
    }

    /**
     * Return the image view entities of a entity or null if the entity don't have a image view entities
     * @param entity
     *      a entity
     * @return a object type of ImageViewEntities
     */
    public ImageViewEntities getImageViewEntities(Entity entity) {
        assert entity != null : "Error : entity null";
        for (ImageViewEntities image : convertSceneToGraphic.getImageViewEntities()) {
            if (image.getEntity() == entity) {
                return image;
            }
        }
        return null;
    }

    /**
     * Return all label of a pane
     * @param pane
     *      a pane
     * @return a list of object type of Label
     */
    public List<Label> getLabels(Pane pane){
        assert pane != null : "Error : pane null";
        for (Node lab : pane.getChildren()) {
            if (lab instanceof javafx.scene.control.Label) {
                labels.add((javafx.scene.control.Label) lab);
            }
        }
        return labels;
    }

    /**
     * Play a sound with his name
     * @param soundName
     *      a sound's name
     */
    public void playSound(String soundName) {
        assert soundName != null : "Error : sound name null";
        kernelEngine.playSound(soundName);
    }

    /**
     * Stop a sound with his name
     * @param soundName
     *      a sound's name
     */
    public void stopSound(String soundName){
        assert soundName != null : "Error : sound name null";
        kernelEngine.stopSound(soundName);
    }

    /**
     * Return all entities thread
     * @return a list of object type of Thread
     */
    public List<Thread> getCurrentsThreads() {
        return kernelEngine.getCurrentsThreads();
    }

    public void setSolo(boolean solo){
        this.solo = solo;
    }

    /**
     * Return the game mode solo state
     * @return o boolean value
     */
    public boolean getSolo(){
        return solo;
    }
}
