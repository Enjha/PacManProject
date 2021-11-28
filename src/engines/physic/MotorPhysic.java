package engines.physic;

import gameplay.Movement;
import scene.SceneGame;

public interface MotorPhysic {

    Collision moveEntity(Movement movement, SceneGame sceneGame);
}
