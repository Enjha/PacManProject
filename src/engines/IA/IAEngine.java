package engines.IA;

import gameplay.Movement;
import pacman.Ghost;

public interface IAEngine extends Runnable{

    void run();
    Movement generateRandomMovement(Ghost ghost);
}
