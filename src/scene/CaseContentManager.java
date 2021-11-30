package scene;

import java.util.List;

/**
 * A case content manager
 */
public interface CaseContentManager {

    /**
     * Add a object in a scene case
     * @param typeOfContent
     *      the type of the object
     * @param content
     *      the object to add
     */
    void addContent(String typeOfContent, Object content);

    /**
     * Return the object's list of a type
     * @param typeOfContent
     *      the type of a object
     * @return a list of object
     */
    List<Object> getContent(String typeOfContent);

    List<List<Object>> getAllContent();

    void removeContent(String typeOfContent, Object element);
}
