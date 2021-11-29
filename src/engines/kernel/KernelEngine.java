package engines.kernel;

import engines.UI.Control;
import engines.UI.ControlEngine;
import engines.graphic.ClassicGraphicEngine;
import engines.graphic.GraphicEngine;
import engines.physic.PhysicEngine;
import engines.sound.SoundEngine;
import gameplay.Entity;
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

}
