package motor.physic;

import gameplay.Movement;
import scene.Scene;

public interface MotorPhysic {

    Collision moveEntity(Movement movement, Scene scene);
}
