package engines.IA;

import gameplay.Entity;
import gameplay.Movement;
import pacman.Ghost;
import scene.SceneCase;

public interface IAEngine extends Runnable{

    void run();
    Movement generateRandomMovement(Entity entity);
}
