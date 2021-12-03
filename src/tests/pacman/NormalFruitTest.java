package tests.pacman;

import org.junit.jupiter.api.Test;
import pacman.LabyrinthCase;
import pacman.NormalCaseContentManager;
import pacman.NormalFruit;
import scene.SceneCase;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NormalFruitTest {
    private final NormalFruit normalFruit = new NormalFruit();
    private final SceneCase sceneCase = new LabyrinthCase(1,2,new NormalCaseContentManager());

    @Test
    void isCharacter() {
        assertFalse(normalFruit.isCharacter());
    }

    @Test
    void isItem() {
        assertTrue(normalFruit.isItem());
    }

    @Test
    void canInteractWithItem() {
        assertFalse(normalFruit.canInteractWithItem());
    }

    @Test
    void getPosition() {
        normalFruit.setPosition(sceneCase);
        assertEquals(sceneCase,normalFruit.getPosition());
    }

    @Test
    void setPosition() {
        assertNull(normalFruit.getPosition());
        normalFruit.setPosition(sceneCase);
        assertEquals(sceneCase,normalFruit.getPosition());
    }

    @Test
    void getEntityName() {
        assertEquals("Fruit",normalFruit.getEntityName());
    }

    @Test
    void isAnimated() {
        assertFalse(normalFruit.isAnimated());
    }

    @Test
    void setAnimated() {
        normalFruit.setAnimated(true);
        assertTrue(normalFruit.isAnimated());
    }
}