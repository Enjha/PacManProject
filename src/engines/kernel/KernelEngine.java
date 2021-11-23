package engines.kernel;

import engines.UI.Control;
import engines.UI.MotorControl;
import engines.graphic.GraphicEngine;
import engines.physic.MotorPhysic;
import engines.sound.MotorSound;
import gameplay.Direction;
import gameplay.Entity;
import javafx.scene.Scene;

import java.util.List;

public interface KernelEngine {

    void setMotorSound(MotorSound motorSound);
    void setMotorPhysic(MotorPhysic motorPhysic);
    void setMotorControl(MotorControl motorControl);
    void setGraphicEngine(GraphicEngine graphicEngine);
    List<Control> getControl(Entity entity);
    double getVolume();
    void setVolume(double volume);
    Scene getCurrentScene();
    List<Entity> getEntities();
    boolean setControl(String oldKey,String newKey);
    void mute();
    void unmute();

}
