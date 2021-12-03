package tests.gameplay;

import gameplay.Entity;
import gameplay.Movement;
import gameplay.MovementNorth;
import gameplay.MovementSouth;
import org.junit.jupiter.api.Test;
import pacman.ClassicLife;
import pacman.LabyrinthCase;
import pacman.NormalCaseContentManager;
import pacman.Pacman;
import scene.SceneCase;

import static org.junit.jupiter.api.Assertions.*;

class MovementSouthTest {

    private Entity entity = new Pacman(new ClassicLife());
    private Movement movement = new MovementSouth(entity);
    private SceneCase sceneCase2 = new LabyrinthCase(0,0,new NormalCaseContentManager());
    private SceneCase sceneCase3 = new LabyrinthCase(2,2,new NormalCaseContentManager());

    @Test
    void nextPosition() {
        entity.setPosition(sceneCase2);
        int[] nextPosition = movement.nextPosition();
        assertEquals(0,nextPosition[0]);
        assertEquals(1,nextPosition[1]);

        sceneCase2.setSceneCaseLink(sceneCase3);
        sceneCase3.setSceneCaseLink(sceneCase2);

        nextPosition = movement.nextPosition();
        assertEquals(2,nextPosition[0]);
        assertEquals(2,nextPosition[1]);

    }
}