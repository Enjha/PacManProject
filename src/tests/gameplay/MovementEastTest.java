package tests.gameplay;

import gameplay.Entity;
import gameplay.Movement;
import gameplay.MovementEast;
import gameplay.MovementNorth;
import org.junit.jupiter.api.Test;
import pacman.LabyrinthCase;
import pacman.NormalCaseContentManager;
import pacman.Pacman;
import scene.SceneCase;

import static org.junit.jupiter.api.Assertions.*;

class MovementEastTest {

    private Entity entity = new Pacman();
    private Movement movement = new MovementEast(entity);
    private SceneCase sceneCase2 = new LabyrinthCase(0,0,new NormalCaseContentManager());
    private SceneCase sceneCase3 = new LabyrinthCase(2,2,new NormalCaseContentManager());

    @Test
    void nextPosition() {
        entity.setPosition(sceneCase2);
        int[] nextPosition = movement.nextPosition();
        assertEquals(1,nextPosition[0]);
        assertEquals(0,nextPosition[1]);

        sceneCase2.setSceneCaseLink(sceneCase3);
        sceneCase3.setSceneCaseLink(sceneCase2);

        nextPosition = movement.nextPosition();
        assertEquals(2,nextPosition[0]);
        assertEquals(2,nextPosition[1]);

    }
}