package pacman;

import gameplay.Team;
import gameplay.TeamManager;
import java.util.HashMap;

/**
 * A classic team manager
 */
public class ClassicTeamManager implements TeamManager {

    /**
     * The map of the team register
     */
    private final HashMap<String, Team> teams = new HashMap<String,Team>();

    /**
     * Add a new team who don't have a team's name already register
     * Return if the add is a success or not
     * @param team
     *      a new team to add
     * @return a boolean value
     */
    public boolean addTeam(Team team){
        if(!teams.containsKey(team.getTeamName())) {
            teams.put(team.getTeamName(), team);
            assert teams.containsKey(team.getTeamName());
            return true;
        }
        return false;
    }

    /**
     * Remove a team who is already register
     * Return if the remove is a success or not
     * @param team
     *      a team to remove
     * @return a boolean value
     */
    public boolean removeTeam(Team team){
        if(teams.containsKey(team.getTeamName())){
            teams.remove(team);
            assert !teams.containsKey(team.getTeamName());
            return true;
        }
        return false;
    }

    /**
     * Return the team with a team's name or null if this team's name is not register
     * @param teamName
     *      a team's name
     * @return a object type of Team
     */
    public Team getTeam(String teamName){
        return teams.getOrDefault(teamName, null);
    }
}
