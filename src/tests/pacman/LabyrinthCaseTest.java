package tests.pacman;

import org.junit.jupiter.api.Test;
import pacman.LabyrinthCase;
import pacman.NormalCaseContentManager;

import static org.junit.jupiter.api.Assertions.*;

class LabyrinthCaseTest {
    private final NormalCaseContentManager caseContentManager = new NormalCaseContentManager();
    private final LabyrinthCase labyrinthCase = new LabyrinthCase(1,2,caseContentManager);
    private final LabyrinthCase labyrinthCase2 = new LabyrinthCase(0,0,new NormalCaseContentManager());

    @Test
    void addCaseContent() {
    }

    @Test
    void removeCaseContent() {
    }

    @Test
    void getCaseContent() {
    }

    @Test
    void getCaseAllContent() {
    }

    @Test
    void getX() {
        assertEquals(1,labyrinthCase.getX());
    }

    @Test
    void getY() {
        assertEquals(2,labyrinthCase.getY());
    }

    @Test
    void getSceneCaseLink() {
        assertNull(labyrinthCase.getSceneCaseLink());
        labyrinthCase.setSceneCaseLink(labyrinthCase2);
        assertEquals(labyrinthCase2,labyrinthCase.getSceneCaseLink());
    }

    @Test
    void setSceneCaseLink() {
        assertNull(labyrinthCase.getSceneCaseLink());
        labyrinthCase.setSceneCaseLink(labyrinthCase2);
        assertEquals(labyrinthCase2,labyrinthCase.getSceneCaseLink());
    }
}