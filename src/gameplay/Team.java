package gameplay;

/**
 * The interface of a team
 */
public interface Team {

    /**
     * Return the team's name
     * @return a string value
     */
    String getTeamName();

    /**
     * Return the collision's state
     * @return a boolean value
     */
    boolean getCollision();

    /**
     * Modify the collision's state
     * @param collision
     *      a new collision's state
     */
    void setCollision(boolean collision);
}
