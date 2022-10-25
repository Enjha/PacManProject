package gameplay;

/**
 * The interface of a team manager
 */
public interface TeamManager {

    /**
     * Add a new team
     * @param team
     *      a new team
     * @return a boolean value to add
     */
    boolean addTeam(Team team);

    /**
     * Remove a team
     * @param team
     *      a team to remove
     * @return a boolean value
     */
    boolean removeTeam(Team team);


    /**
     * Return the team with this name if its exist
     * @param teamName
     * a team's name
     * @return a object type Of Team
     */
    Team getTeam(String teamName);
}
