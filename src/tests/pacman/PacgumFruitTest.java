package tests.pacman;

import org.junit.jupiter.api.Test;
import pacman.LabyrinthCase;
import pacman.NormalCaseContentManager;
import pacman.PacgumFruit;
import scene.SceneCase;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class PacgumFruitTest {

    private final PacgumFruit pacgumFruit = new PacgumFruit();
    private final SceneCase sceneCase = new LabyrinthCase(1,2,new NormalCaseContentManager());

    @Test
    void isCharacter() {
        assertFalse(pacgumFruit.isCharacter());
    }

    @Test
    void isItem() {
        assertTrue(pacgumFruit.isItem());
    }

    @Test
    void canInteractWithItem() {
        assertFalse(pacgumFruit.canInteractWithItem());
    }

    @Test
    void getPosition() {
        pacgumFruit.setPosition(sceneCase);
        assertEquals(sceneCase,pacgumFruit.getPosition());
    }

    @Test
    void setPosition() {
        assertNull(pacgumFruit.getPosition());
        pacgumFruit.setPosition(sceneCase);
        assertEquals(sceneCase,pacgumFruit.getPosition());
    }

    @Test
    void getEntityName() {
        assertEquals("Pacgum",pacgumFruit.getEntityName());
    }

    @Test
    void isAnimated() {
        assertFalse(pacgumFruit.isAnimated());
    }

    @Test
    void setAnimated() {
        assertFalse(pacgumFruit.isAnimated());
        pacgumFruit.setAnimated(true);
        assertTrue(pacgumFruit.isAnimated());
    }
}