package pacman;

import gameplay.Character;
import gameplay.Direction;
import gameplay.Team;
import javafx.scene.image.Image;
import pacman.view.PacManView;
import scene.SceneCase;

import java.util.ArrayList;

/**
 * The entity pacman
 */
public class Pacman implements Character {

    /**
     * The scene case who contain pacman
     */
    private SceneCase position;

    /**
     * The team of pacman
     */
    private Team team;

    /**
     * Number of PacMan life
     */
    private int NumberOflife = 3;

    /**
     * The name of Pacman
     */
    private String entityName = "Pac-Man";

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

    private volatile boolean isAnimated = false;

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
     * @return a boolean value equal to true
     */
    public boolean canInteractWithItem() {
        return true;
    }

    /**
     * The entity's X starting position
     */
    private int xStartPosition;

    /**
     * The entity's Y starting position
     */
    private int yStartPosition;


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
     * Return the Number of PacMan Life
     *
     * @return integer numberOfLife
     */
    public int getNumberOflife() {
        return NumberOflife;
    }

    /**
     * Set the Number of PacMan Life
     */
    public void setNumberOflife(int NumberOflife) {
        this.NumberOflife = NumberOflife;
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
     * Modify the team of this entity
     *
     * @param team a new team
     */
    public void setTeam(Team team) {
        this.team = team;
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
     * Return the textures list of Pacman
     *
     * @return list of Images
     */
    @Override
    public ArrayList<Image> getTextures() {
        return new PacManView().getPacmanView(this);
    }

    /**
     * Modify the direction of this entity's movement
     *
     * @param direction a new direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
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
     * Set the entity's state of live.
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    /**
     * Get the X starting position of PacMan in labyrtinh.
     *
     * @return X integer
     */
    public int getxStartPosition() {
        return xStartPosition;
    }

    /**
     * Set the X starting position of pacman in labyrtinh.
     *
     * @param xStartPosition integer
     */
    public void setxStartPosition(int xStartPosition) {
        this.xStartPosition = xStartPosition;
    }

    /**
     * Get the Y starting position of PacMan in labyrtinh.
     *
     * @return Y integer
     */
    public int getyStartPosition() {
        return yStartPosition;
    }

    /**
     * Set the Y starting position of pacman in labyrtinh.
     *
     * @param yStartPosition integer
     */
    public void setyStartPosition(int yStartPosition) {
        this.yStartPosition = yStartPosition;
    }
}
