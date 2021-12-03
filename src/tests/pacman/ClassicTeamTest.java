package tests.pacman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import gameplay.Team;
import org.junit.jupiter.api.Test;
import pacman.ClassicTeam;

class ClassicTeamTest {
    private Team team = new ClassicTeam("test",true);

    @Test
    void getTeamName() {
        assertEquals("test",team.getTeamName());
    }

    @Test
    void getCollision() {
        assertTrue(team.getCollision());
    }
}