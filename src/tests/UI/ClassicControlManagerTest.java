package tests.UI;

import engines.UI.ClassicControlManager;
import engines.UI.Control;
import engines.UI.KeyBoardControl;
import gameplay.Direction;
import gameplay.Entity;
import org.junit.jupiter.api.Test;
import pacman.NormalFruit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClassicControlManagerTest {
    private final ClassicControlManager controlManager = new ClassicControlManager();
    private final Entity entity = new NormalFruit();
    private final Control control = new KeyBoardControl("a", Direction.North,entity);

    @Test
    void addControl() {
        controlManager.addControl(control);
        assertEquals(control,controlManager.getControl(control.getKeyName()));
    }

    @Test
    void removeControl() {
        controlManager.addControl(control);
        controlManager.removeControl(control);
        assertNull(controlManager.getControl(entity.getEntityName()));
    }

    @Test
    void setControl() {
        controlManager.addControl(control);
        controlManager.setControl("a","f");
        assertEquals(control,controlManager.getControl("f"));
    }
}