package engines.graphic;

import apiUser.FxWindow;
import apiUser.SceneAPIUser;
import engines.UI.Control;
import engines.kernel.KernelEngine;
import gameplay.Entity;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.SceneCase;
import scene.SceneGame;

import java.util.ArrayList;
import java.util.List;

public class ClassicGraphicEngine implements GraphicEngine {

    private final Stage stage;
    private FxWindow window;
    private final KernelEngine kernelEngine;
    private ConvertSceneToGraphic convertSceneToGraphic;
    private SceneAPIUser previewScene;

    public ClassicGraphicEngine(Stage stage, KernelEngine kernelEngine, ConvertSceneToGraphic convertSceneToGraphic) {
        this.stage = stage;
        this.kernelEngine = kernelEngine;
        this.convertSceneToGraphic = convertSceneToGraphic;
    }

    public void setFxWindow(int width, int height, String name) {
        window = new FxWindow(width, height, name, stage);
        window.openWindow();
    }

    public void setSceneGameTexture(SceneGame sceneGame) {
        convertSceneToGraphic.setLabyrinthTextureScene(sceneGame, window.getScene().getPanel());
    }

    public void setSceneGameEntity(SceneGame sceneGame) {
        convertSceneToGraphic.setEntityTextureScene(sceneGame, window.getScene().getPanel());
    }

    public void setCurrentScene(SceneAPIUser scene) {
        window.setScene(scene);
        if (window.getScene().isSceneGame()) {
            setSceneGameTexture(kernelEngine.getSceneGame());
            setSceneGameEntity(kernelEngine.getSceneGame());
        }
    }

    public void setPreviewScene(SceneAPIUser scene) {
        this.previewScene = scene;
    }

    public SceneAPIUser getPreviewScene() {
        return previewScene;
    }

    public List<Control> getControl(Entity entity) {
        return kernelEngine.getControl(entity);
    }

    public double getVolume() {
        return kernelEngine.getVolume();
    }

    public void setVolume(double volume) {
        kernelEngine.setVolume(volume);
    }

    public Scene getCurrentScene() {
        return window.getScene().getScene();
    }

    public List<Entity> getEntities() {
        return kernelEngine.getEntities();
    }

    public boolean setControl(String oldKey, String newKey) {
        return kernelEngine.setControl(oldKey, newKey);
    }

    public void mute() {
        kernelEngine.mute();
    }

    public void unmute() {
        kernelEngine.unmute();
    }

    public SceneGame getSceneGame() {
        return kernelEngine.getSceneGame();
    }

    public void setControlEngineState(boolean state) {
        kernelEngine.setControlEngineState(state);
    }

    public void setControlEngineScene(Scene scene) {
        kernelEngine.setControlEngineScene(scene);
    }

    public void updateSceneGame(Entity entity) {
        ImageViewEntities imageViewEntities = getImageViewEntities(entity);
        if (imageViewEntities != null) {
            convertSceneToGraphic.setEntityPosition(entity, imageViewEntities.getImageView());
        } else {
            System.err.println("error : entity not found");
        }
    }

    public ImageViewEntities getImageViewEntities(Entity entity) {
        for (ImageViewEntities image : convertSceneToGraphic.getImageViewEntities()) {
            if (image.getEntity() == entity) {
                return image;
            }
        }
        return null;
    }

    public void playSound(String soundName) {
        kernelEngine.playSound(soundName);
    }

    public List<Thread> getCurrentsThreads() {
        return kernelEngine.getCurrentsThreads();
    }

}
