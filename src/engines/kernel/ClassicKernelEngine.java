package engines.kernel;

import engines.UI.Control;
import engines.UI.ControlEngine;
import engines.graphic.GraphicEngine;
import engines.graphic.ImageViewEntities;
import engines.physic.Collision;
import engines.physic.PhysicEngine;
import engines.sound.SoundEngine;
import gameplay.Entity;
import gameplay.Game;
import gameplay.Movement;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import pacman.Life;
import pacman.Score;
import scene.SceneGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClassicKernelEngine implements KernelEngine {

    private GraphicEngine graphicEngine;
    private SoundEngine soundEngine;
    private PhysicEngine physicEngine;
    private ControlEngine controlEngine;
    private Game game;

    public ClassicKernelEngine(Game game) {
        this.game = game;
    }

    public Control getControl(String keyName) {
        return controlEngine.getControl(keyName);
    }

    public double getVolume() {
        return soundEngine.getVolume();
    }

    public void setVolume(double volume) {
        soundEngine.changeVolumeAll(volume);
    }

    public void setSoundEngine(SoundEngine soundEngine) {
        this.soundEngine = soundEngine;
    }

    public void setPhysicEngine(PhysicEngine physicEngine) {
        this.physicEngine = physicEngine;
    }

    public void setControlEngine(ControlEngine controlEngine) {
        this.controlEngine = controlEngine;
    }

    public void setGraphicEngine(GraphicEngine graphicEngine) {
        this.graphicEngine = graphicEngine;
    }

    public Scene getCurrentScene() {
        return graphicEngine.getCurrentScene();
    }

    public List<Control> getControl(Entity entity) {
        return controlEngine.getControl(entity);
    }

    public List<Entity> getEntities() {
        return game.getEntities();
    }

    public boolean setControl(String oldKey, String newKey) {
        return controlEngine.setKey(oldKey, newKey);
    }

    public void mute() {
        soundEngine.mute();
    }

    public void unmute() {
        soundEngine.unmute();
    }

    public SceneGame getSceneGame() {
        return game.getSceneGame();
    }

    public void setControlEngineState(boolean state) {
        controlEngine.setEngineState(state);
    }

    public void setControlEngineScene(Scene scene) {
        controlEngine.setScene(scene);
    }

    public void treatmentCollisionGame(Movement movement) {
        if (physicEngine != null) {
            Collision collision = physicEngine.moveEntity(movement, game.getSceneGame());
            game.treatmentCollision(movement, collision);
        } else {
            System.out.println("error : physic engine null");
        }
    }

    public void setMovementEntity(Movement movement) {
        if (movement.getEntity().isCharacter()) {
            game.getThreadEntity(movement.getEntity()).setMovement(movement);
            game.startThreadEntity();
        }
    }

    public ImageViewEntities getImageViewEntities(Entity entity) {
        return graphicEngine.getImageViewEntities(entity);
    }

    public Entity getEntity(String entityName) {
        if(game.getEntities().size() != 0){
            for (Entity entity : game.getEntities()) {
                if (entity.getEntityName().equals(entityName)) {
                    return entity;
                }
            }
        }
        return null;
    }

    public void updateSceneGame(Entity entity) {
        graphicEngine.updateSceneGame(entity);
    }

    public void playSound(String soundName) {
        soundEngine.playSound(soundName, MediaPlayer.INDEFINITE);
    }
    public void playOneSound(String soundName) {
        soundEngine.playSound(soundName, 1);
        soundEngine.stopSound(soundName);
    }
    public void stopSound(String soundName){
        soundEngine.stopSound(soundName);
    }

    public List<Thread> getCurrentsThreads() {
        return game.getThreadEntities();
    }

    public Score getScore() {
        return game.getScore();
    }

    public Life getLife() {
        return game.getLife();
    }

}
