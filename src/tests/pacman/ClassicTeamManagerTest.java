package tests.pacman;

import gameplay.Team;
import gameplay.TeamManager;
import org.junit.jupiter.api.Test;
import pacman.ClassicTeam;
import pacman.ClassicTeamManager;

import static org.junit.jupiter.api.Assertions.*;

class ClassicTeamManagerTest {
    private final TeamManager teamManager = new ClassicTeamManager();
    private final String teamName1 = "team1";
    private final String teamName2 = "team2";
    private final Team team2 = new ClassicTeam(teamName2,false);
    private final Team team1 = new ClassicTeam(teamName1,true);


    @Test
    void getTeam() {
        teamManager.addTeam(team1);
        assertEquals(team1,teamManager.getTeam(teamName1));
    }
}