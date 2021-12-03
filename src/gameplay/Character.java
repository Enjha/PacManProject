package gameplay;

import javafx.scene.image.Image;
import pacman.Life;

import java.util.ArrayList;

/**
 * Interface of a character
 */
public interface Character extends Entity {

    /**
     * Return the character's team
     * @return a object type of Team
     */
    Team getTeam();

    /**
     * Modify the character's team
     * @param team
     *      a new team
     */
    void setTeam(Team team);

    /**
     * Return the character's direction
     * @return a object type of Direction
     */
    Direction getDirection();

    /**
     * Modify the character's direction
     * @param direction
     *       a new direction
     */
    void setDirection(Direction direction);

    /**
     * Return the character's state of life
     * @return a boolean value
     */
    boolean isAlive();

    /**
     * Return all texture of the character
     * @return a list of object type of Image
     */
    ArrayList<Image> getTextures();

    /**
     * Return the character's life
     * @return a object type of Life
     */
    Life getLife();

    /**
     * Modify the number of character's life point
     * @param nbLife
     *      the new life point
     */
    void setLifePoint(int nbLife);

    /**
     * Return the character's start position x
     * @return a integer value
     */
    int getxStartPosition();

    /**
     * Return the character's start position y
     * @return a integer value
     */
    int getyStartPosition();

    /**
     * Modify the character's start position x
     * @param yStartPosition
     *      a new start position x
     */
    void setyStartPosition(int yStartPosition);

    /**
     * Modify the character's start position y
     * @param xStartPosition
     *      a new start position y
     */
    void setxStartPosition(int xStartPosition);

    /**
     * Modify the character's state of life
     * @param isAlive
     *      a new state of life
     */
    void setIsAlive(boolean isAlive);

}
