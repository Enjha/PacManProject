package pacman;

import gameplay.Team;
import gameplay.TeamManager;
import java.util.HashMap;


public class ClassicTeamManager implements TeamManager {

    private final HashMap<String, Team> teams = new HashMap<String,Team>();

    public boolean addTeam(Team team){
        if(!teams.containsKey(team.getTeamName())) {
            teams.put(team.getTeamName(), team);
            return true;
        }
        return false;
    }

    public boolean removeTeam(Team team){
        if(teams.containsKey(team.getTeamName())){
            teams.remove(team);
            return true;
        }
        return false;
    }

    public Team getTeam(String teamName){
        return teams.get(teamName);
    }
}
