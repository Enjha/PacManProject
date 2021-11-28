package pacman;

import gameplay.Character;
import gameplay.Direction;
import gameplay.Team;
import scene.SceneCase;

/**
 * The entity ghost
 */
public class Ghost implements Character {

    /**
     * The scene case who contain pacman
     */
    private SceneCase position;

    /**
     * The team of pacman
     */
    private Team team;

    /**
     * The name of Pacman
     */
    private String entityName;

    /**
     * The direction of the entity's movement
     * By default the direction is Stop
     */
    private Direction direction = Direction.Stop;

    /**
     * The entity's state of live
     * By default the state is true
     */
    private boolean isAlive = true;

    /**
     * The color of this entity
     */
    private final GhostColor color;

    /**
     * <b>Constructor of Ghost</b>
     * @param entityName
     *      a entity's name
     * @param color
     *      a entity's color
     */
    public Ghost(String entityName, GhostColor color) {
        this.entityName = entityName;
        this.color = color;
    }

    /**
     * Return if this entity is a character
     * @return a boolean value equal to true
     */
    public boolean isCharacter() {
        return true;
    }

    /**
     * Return if this entity is a item
     * @return a boolean value equal to false
     */
    public boolean isItem() {
        return false;
    }

    /**
     * Return if this entity can interact with item
     * @return a boolean value equal to false
     */
    public boolean canInteractWithItem() {
        return false;
    }

    /**
     * Return the scene case who contain this entity
     * @return a object type of SceneCase
     */
    public SceneCase getPosition() {
        return position;
    }

    /**
     * Return the team of this entity
     * @return a object type of Team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Modify the scene case who contain this entity
     * @param position
     *      a new scene case
     */
    public void setPosition(SceneCase position) {
        this.position = position;
    }

    /**
     * Modify the team of this entity
     * @param team
     *      a new team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Return this entity's name
     * @return a string value
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Return the direction of this entity's movement
     * @return a object type of Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Modify the direction of this entity's movement
     * @param direction
     *      a new direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Return this entity's state of live
     * @return a boolean value
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Return this entity's color
     * @return a object type of GhostColor
     */
    public GhostColor getColor() {
        return color;
    }
}