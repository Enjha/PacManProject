package tests.pacman;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.Test;

import gameplay.Entity;
import pacman.Ghost;
import pacman.GhostColor;
import pacman.NormalCaseContentManager;
import pacman.Pacman;

import java.util.List;

class NormalCaseContentManagerTest {

    private NormalCaseContentManager normalCaseContentManager = new NormalCaseContentManager();
    private Entity pacman = new Pacman();
    private Entity ghostBlue = new Ghost("Blue",GhostColor.BLUE);
    private Entity ghostPink = new Ghost("Pink",GhostColor.PINK);

    @Test
    void addContent() {
        normalCaseContentManager.addContent(pacman.getClass().toString(),pacman);

        assertEquals(1,normalCaseContentManager.getListOfTypeOfContent().size());
        assertEquals(Pacman.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(0));

        assertEquals(1,normalCaseContentManager.getCaseContent().size());
        assertEquals(1,normalCaseContentManager.getCaseContent().get(0).size());
        assertEquals(pacman,normalCaseContentManager.getCaseContent().get(0).get(0));

        normalCaseContentManager.addContent(ghostBlue.getClass().toString(), ghostBlue);

        assertEquals(2,normalCaseContentManager.getListOfTypeOfContent().size());
        assertEquals(Pacman.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(0));
        assertEquals(Ghost.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(1));

        assertEquals(2,normalCaseContentManager.getCaseContent().size());
        assertEquals(1,normalCaseContentManager.getCaseContent().get(0).size());
        assertEquals(pacman,normalCaseContentManager.getCaseContent().get(0).get(0));
        assertEquals(1,normalCaseContentManager.getCaseContent().get(1).size());
        assertEquals(ghostBlue,normalCaseContentManager.getCaseContent().get(1).get(0));

        normalCaseContentManager.addContent(ghostPink.getClass().toString(),ghostPink);

        assertEquals(2,normalCaseContentManager.getListOfTypeOfContent().size());
        assertEquals(Pacman.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(0));
        assertEquals(Ghost.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(1));

        assertEquals(2,normalCaseContentManager.getCaseContent().size());
        assertEquals(1,normalCaseContentManager.getCaseContent().get(0).size());
        assertEquals(pacman,normalCaseContentManager.getCaseContent().get(0).get(0));
        assertEquals(2,normalCaseContentManager.getCaseContent().get(1).size());
        assertEquals(ghostBlue,normalCaseContentManager.getCaseContent().get(1).get(0));
        assertEquals(ghostPink,normalCaseContentManager.getCaseContent().get(1).get(1));

    }

    @Test
    void removeContent() {
        normalCaseContentManager.addContent(pacman.getClass().toString(),pacman);
        normalCaseContentManager.addContent(ghostBlue.getClass().toString(), ghostBlue);
        normalCaseContentManager.addContent(ghostPink.getClass().toString(),ghostPink);

        normalCaseContentManager.removeContent(ghostBlue.getClass().toString(), ghostBlue);
        assertEquals(2,normalCaseContentManager.getListOfTypeOfContent().size());
        assertEquals(Pacman.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(0));
        assertEquals(Ghost.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(1));
        assertEquals(2,normalCaseContentManager.getCaseContent().size());
        assertEquals(1,normalCaseContentManager.getCaseContent().get(0).size());
        assertEquals(pacman,normalCaseContentManager.getCaseContent().get(0).get(0));
        assertEquals(1,normalCaseContentManager.getCaseContent().get(1).size());
        assertEquals(ghostPink,normalCaseContentManager.getCaseContent().get(1).get(0));

        normalCaseContentManager.removeContent(ghostBlue.getClass().toString(),ghostBlue);
        assertEquals(2,normalCaseContentManager.getListOfTypeOfContent().size());
        assertEquals(Pacman.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(0));
        assertEquals(Ghost.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(1));
        assertEquals(2,normalCaseContentManager.getCaseContent().size());
        assertEquals(1,normalCaseContentManager.getCaseContent().get(0).size());
        assertEquals(pacman,normalCaseContentManager.getCaseContent().get(0).get(0));
        assertEquals(1,normalCaseContentManager.getCaseContent().get(1).size());
        assertEquals(ghostPink,normalCaseContentManager.getCaseContent().get(1).get(0));

        normalCaseContentManager.removeContent(ghostPink.getClass().toString(),ghostPink);
        assertEquals(1,normalCaseContentManager.getListOfTypeOfContent().size());
        assertEquals(Pacman.class.toString(),normalCaseContentManager.getListOfTypeOfContent().get(0));
        assertEquals(1,normalCaseContentManager.getCaseContent().size());
        assertEquals(1,normalCaseContentManager.getCaseContent().get(0).size());
        assertEquals(pacman,normalCaseContentManager.getCaseContent().get(0).get(0));
    }

    @Test
    void getContent() {
        normalCaseContentManager.addContent(pacman.getClass().toString(),pacman);
        normalCaseContentManager.addContent(ghostBlue.getClass().toString(), ghostBlue);
        normalCaseContentManager.addContent(ghostPink.getClass().toString(),ghostPink);
        List<Object> list;

        list = normalCaseContentManager.getContent(Pacman.class.toString());
        assertEquals(1,list.size());
        assertEquals(pacman,list.get(0));

        list = normalCaseContentManager.getContent(Ghost.class.toString());
        assertEquals(2,list.size());
        assertEquals(ghostBlue,list.get(0));
        assertEquals(ghostPink,list.get(1));

        list = normalCaseContentManager.getContent(NormalCaseContentManager.class.toString());
        assertNull(list);
    }
}*/