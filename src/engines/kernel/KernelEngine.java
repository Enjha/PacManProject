package engines.kernel;

import engines.UI.Control;
import engines.UI.ControlEngine;
import engines.graphic.ClassicGraphicEngine;
import engines.graphic.GraphicEngine;
import engines.graphic.ImageViewEntities;
import engines.physic.PhysicEngine;
import engines.sound.SoundEngine;
import gameplay.Entity;
import gameplay.Movement;
import javafx.scene.Scene;
import scene.SceneGame;

import java.util.List;

public interface KernelEngine {

    void setSoundEngine(SoundEngine soundEngine);
    void setPhysicEngine(PhysicEngine physicEngine);
    void setControlEngine(ControlEngine controlEngine);
    void setGraphicEngine(GraphicEngine graphicEngine);
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
    void treatmentCollisionGame(Movement movement);
    void updateSceneGame(Entity entity);
    void setMovementEntity(Movement movement);
    ImageViewEntities getImageViewEntities(Entity entity);
    void playSound(String soundName);

}
