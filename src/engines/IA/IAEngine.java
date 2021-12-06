package engines.IA;

import gameplay.Movement;
import pacman.Ghost;
import scene.SceneCase;

public interface IAEngine extends Runnable{

    void run();
    Movement generateRandomMovement(Ghost ghost);
}
