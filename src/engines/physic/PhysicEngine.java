package engines.physic;

import gameplay.Movement;
import scene.SceneGame;

public interface PhysicEngine {

    Collision moveEntity(Movement movement, SceneGame sceneGame);
}
