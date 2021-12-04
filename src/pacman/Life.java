package pacman;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * The interface of life's information for a entity
 */
public interface Life {

    /**
     * Return all image for the life point
     * @return a array list of object type of ImageView
     */
    ArrayList<ImageView> getImageViews();

    /**
     * Return the current number of life point
     * @return a integer value
     */
    int getNumberOfLife();

    /**
     * Add life point to the current life point
     * @param value
     *      the life point to add
     */
    void addLifePoint(int value);

    /**
     * Remove life point to the current life point
     * @param value
     *      the life point to remove
     */
    void removeLifePoint(int value);

    /**
     * Return the pane
     * @return a object type of Pane
     */
    Pane getSceneLife();

    /**
     * Modify the pane
     * @param pane
     *      a new pane
     */
    void setSceneLife(Pane pane);

    /**
     * Modify the number max of life point
     * @param numberMaxOfLife
     *      a new number of life point
     */
    void setNumberMaxOfLife(int numberMaxOfLife);

    /**
     * Return the number max of life point
     * @return a integer value
     */
    int getNumberMaxOfLife();
}
