package pacman;

import scene.CaseContentManager;
import scene.SceneCase;

import java.util.List;

/**
 * A case of the labyrinth
 */
public class LabyrinthCase implements SceneCase {

    /**
     * A case content manager
     */
    private final CaseContentManager caseContentManager;

    /**
     * The position x of the case
     */
    private final int x;

    /**
     * The position y of the case
     */
    private final int y;

    private SceneCase sceneCaseLink = null;

    /**
     * <b>Constructor of LabyrinthCase</b>
     * @param x
     *      a position x of the case
     * @param y
     *      a position y of the case
     * @param caseContentManager
     *      a case content manager
     */
    public LabyrinthCase(int x, int y, CaseContentManager caseContentManager){
        this.x = x;
        this.y = y;
        this.caseContentManager = caseContentManager;
    }

    /**
     * Add a new object in the case content
     * @param object
     *      a new object to add
     */
    public void addCaseContent(Object object){
        caseContentManager.addContent(object.getClass().toString(),object);
    }

    /**
     * Remove a object in the case content
     * @param object
     *      a object to remove
     */
    public void removeCaseContent(Object object){
        caseContentManager.removeContent(object.getClass().toString(),object);
    }

    /**
     * Return the case content of a object's type
     * @param typeOfElement
     *      the type of the object to return
     * @return a list of object
     */
    public List<Object> getCaseContent(String typeOfElement){
        return caseContentManager.getContent(typeOfElement);
    }

    public List<List<Object>> getCaseAllContent(){
        return caseContentManager.getAllContent();
    }

    /**
     * Return the position x of the case
     * @return a integer value
     */
    public int getX(){
        return x;
    }

    /**
     * Return the position y of the case
     * @return a integer value
     */
    public int getY(){
        return y;
    }

    public SceneCase getSceneCaseLink(){
        return sceneCaseLink;
    }

    public void setSceneCaseLink(SceneCase sceneCase){
        sceneCaseLink = sceneCase;
    }

}
