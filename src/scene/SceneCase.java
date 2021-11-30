package scene;

import java.util.List;

/**
 * A scene case
 */
public interface SceneCase {

    /**
     * Position x of this scene case
     * @return a integer value
     */
    int getX();

    /**
     * Position y of this scene case
     * @return a integer value
     */
    int getY();

    /**
     * Remove a object contain in a scene case
     * @param object
     *      a object
     */
    void removeCaseContent(Object object);

    /**
     * Add a object not contain in a scene case
     * @param object
     *      a object
     */
    void addCaseContent(Object object);

    /**
     * Return a list of a type of element in a scene case
     * @param typeOfElement
     *      the type of the object to return
     * @return a list of object
     */
    List<Object> getCaseContent(String typeOfElement);

    List<List<Object>> getCaseAllContent();
}
