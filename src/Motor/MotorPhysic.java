package Motor;

import Gameplay.Movement;
import Scene.Scene;

public interface MotorPhysic {

    Collision moveEntity(Movement movement, Scene scene);
}
