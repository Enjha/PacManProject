package pacman;

import gameplay.Team;

/**
 * A classic team with a name and un collision's state
 */
public class ClassicTeam implements Team {

    /**
     * the team's name
     */
    private final String teamName;

    /**
     * the state of if there is a collision between entities in this team
     */
    private boolean collision;

    /**
     * <b>Constructor of ClassicTeam</b>
     * @param teamName
     *      a team's name
     * @param collision
     *      a collision state
     */
    public ClassicTeam(String teamName, boolean collision){
        this.teamName = teamName;
        this.collision = collision;
    }

    /**
     * Return the team's name
     * @return a string value
     */
    public String getTeamName(){
        return teamName;
    }

    /**
     * Return the state's collision
     * @return a boolean value
     */
    public  boolean getCollision(){
        return collision;
    }

    /**
     * Modify the collision's state
     * @param collision
     *      a new collision's state
     */
    public void setCollision(boolean collision){
        this.collision = collision;
    }
}
