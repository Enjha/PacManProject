package pacman;

import gameplay.Character;
import gameplay.Direction;
import gameplay.Team;
import pacman.view.GhostView;
import javafx.scene.image.Image;
import scene.SceneCase;

import java.util.ArrayList;
import java.util.List;

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
    private final String entityName;

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
     * The entity's state of fear
     * By default the state is false
     */
    private boolean isAfraid = false;

    /**
     * The color of this entity
     */
    private final GhostColor color;

    /**
     * The animation's state of this ghost
     */
    private boolean isAnimated = false;

    private Life life;

    /**
     * <b>Constructor of Ghost</b>
     *
     * @param entityName a entity's name
     * @param color      a entity's color
     */
    public Ghost(String entityName, GhostColor color) {
        this.entityName = entityName;
        this.color = color;
    }

    /**
     * Return if this entity is a character
     *
     * @return a boolean value equal to true
     */
    public boolean isCharacter() {
        return true;
    }

    /**
     * Return if this entity is a item
     *
     * @return a boolean value equal to false
     */
    public boolean isItem() {
        return false;
    }

    /**
     * Return if this entity can interact with item
     *
     * @return a boolean value equal to false
     */
    public boolean canInteractWithItem() {
        return false;
    }

    /**
     * Return the scene case who contain this entity
     *
     * @return a object type of SceneCase
     */
    public SceneCase getPosition() {
        return position;
    }

    /**
     * Return the team of this entity
     *
     * @return a object type of Team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Modify the scene case who contain this entity
     *
     * @param position a new scene case
     */
    public void setPosition(SceneCase position) {
        this.position = position;
    }

    /**
     * The ghost's X starting position
     */
    private int xStartPosition;

    /**
     * The ghost's Y starting position
     */
    private int yStartPosition;

    /**
     * Modify the team of this entity
     *
     * @param team a new team
     */
    public void setTeam(Team team) {
        if(team != null) {
            this.team = team;
        }
    }

    /**
     * Return this entity's name
     *
     * @return a string value
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Return the direction of this entity's movement
     *
     * @return a object type of Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Modify the direction of this entity's movement
     *
     * @param direction a new direction
     */
    public void setDirection(Direction direction) {
        if(direction != null) {
            this.direction = direction;
        }
    }

    /**
     * Return this entity's state of live
     *
     * @return a boolean value
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Return the textures list of the Ghosts
     *
     * @return list of Images
     */
    public ArrayList<Image> getTextures() {
        return new GhostView().getGhostView(this);
    }

    /**
     * Set the entity's state of live.
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Return this entity's state of fear
     *
     * @return a boolean value
     */
    public boolean isAfraid() {
        return isAfraid;
    }

    /**
     * Set the entity's state of fear.
     */
    public void setIsAfraid(boolean isAfraid) {
        this.isAfraid = isAfraid;
    }

    /**
     * Return this entity's color
     *
     * @return a object type of GhostColor
     */
    public GhostColor getColor() {
        return color;
    }

    /**
     * Return the state of the ghost's animation
     * @return o boolean value
     */
    public boolean isAnimated() {
        return isAnimated;
    }

    /**
     * Modify the state of the ghost's animation
     * @param isAnimated
     */
    public void setAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    /**
     * Return the life of a ghost
     *
     * @return a object type of Life
     */
    public Life getLife() {
        return life;
    }

    /**
     * Set the Number of a ghost Life point
     */
    public void setLifePoint(int nbLife) {
        this.life.setNumberOfLife(nbLife);
    }

    /**
     * Get the X starting position of a ghost in the labyrinth.
     *
     * @return a integer value
     */
    public int getxStartPosition() {
        return xStartPosition;
    }

    /**
     * Set the X starting position of a ghost in the labyrinth.
     *
     * @param xStartPosition
     *      a new start position x
     */
    public void setxStartPosition(int xStartPosition) {
        this.xStartPosition = xStartPosition;
    }

    /**
     * Get the Y starting position of a ghost in the labyrinth.
     *
     * @return a integer value
     */
    public int getyStartPosition() {
        return yStartPosition;
    }

    /**
     * Set the Y starting position of a ghost in the labyrinth.
     *
     * @param yStartPosition
     *      a new start position y
     */
    public void setyStartPosition(int yStartPosition) {
        this.yStartPosition = yStartPosition;
    }
}