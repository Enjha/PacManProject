package tests.pacman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import gameplay.Direction;
import gameplay.Team;
import org.junit.jupiter.api.Test;
import pacman.*;
import scene.SceneCase;

import static org.junit.jupiter.api.Assertions.*;

class GhostTest {
    private final GhostColor ghostColor = GhostColor.BLUE;
    private final String ghostName = "Blue";
    private final Team team = new ClassicTeam("test",false);
    private final Ghost ghost = new Ghost(ghostName,ghostColor);
    private final SceneCase sceneCase = new LabyrinthCase(1,2,new NormalCaseContentManager());
    private final SceneCase sceneCase2 = new LabyrinthCase(2,1,new NormalCaseContentManager());

    @Test
    void isCharacter() {
        assertTrue(ghost.isCharacter());
    }

    @Test
    void isItem() {
        assertFalse(ghost.isItem());
    }

    @Test
    void canInteractWithItem() {
        assertFalse(ghost.canInteractWithItem());
    }

    @Test
    void getPosition() {
        ghost.setPosition(sceneCase);
        assertEquals(sceneCase,ghost.getPosition());
    }

    @Test
    void getTeam() {
        ghost.setTeam(team);
        assertEquals(team,ghost.getTeam());
    }

    @Test
    void setPosition() {
        assertNull(ghost.getPosition());
        ghost.setPosition(sceneCase);
        assertEquals(sceneCase,ghost.getPosition());
        ghost.setPosition(sceneCase2);
        assertEquals(sceneCase2,ghost.getPosition());
    }

    @Test
    void setTeam() {
        assertNull(ghost.getTeam());
        ghost.setTeam(team);
        assertEquals(team,ghost.getTeam());
    }

    @Test
    void getEntityName() {
        assertEquals(ghostName,ghost.getEntityName());
    }

    @Test
    void getDirection() {
        assertEquals(Direction.Stop,ghost.getDirection());
    }

    @Test
    void setDirection() {
        assertEquals(Direction.Stop,ghost.getDirection());
        Direction directionSouth = Direction.South;
        ghost.setDirection(directionSouth);
        assertEquals(directionSouth,ghost.getDirection());
        ghost.setDirection(null);
        assertEquals(directionSouth,ghost.getDirection());
    }

    @Test
    void isAlive() {
        assertTrue(ghost.isAlive());
    }

    @Test
    void getTextures() {

    }

    @Test
    void setIsAlive() {
        assertTrue(ghost.isAlive());
        ghost.setIsAlive(false);
        assertFalse(ghost.isAlive());
    }

    @Test
    void isAfraid() {
        assertFalse(ghost.isAfraid());
    }

    @Test
    void setIsAfraid() {
        assertFalse(ghost.isAfraid());
        ghost.setIsAfraid(true);
        assertTrue(ghost.isAfraid());
    }

    @Test
    void getColor() {
        assertEquals(ghostColor,ghost.getColor());
    }

    @Test
    void isAnimated() {
        assertFalse(ghost.isAnimated());
    }

    @Test
    void setAnimated() {
        assertFalse(ghost.isAnimated());
        ghost.setAnimated(true);
        assertTrue(ghost.isAnimated());

    }
}