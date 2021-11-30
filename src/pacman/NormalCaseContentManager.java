package pacman;

import scene.CaseContentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A normal case content manager
 */
public class NormalCaseContentManager implements CaseContentManager {

    /**
     * The list of element's type of the case scene
     */
    private final List<String> listOfTypeOfContent = new ArrayList<>();

    /**
     * The list of element's list of the case scene
     */
    private final List<List<Object>> caseContent = new ArrayList<>();

    /**
     * Add a object in the case scene
     * If this object's type is new, a new list is create
     * If this object's type is not new, the object is add to the correct list
     * @param typeOfContent
     *      a type of the object to add
     * @param content
     *      a object to add
     */
    public void addContent(String typeOfContent, Object content){
        int index = verifyTypeOfContent(typeOfContent);
        if(index == -1){
            addNewCaseContent(typeOfContent,content);
        }
        else {
            caseContent.get(index).add(content);
        }
    }

    /**
     * Remove a object in the case scene
     * If this object's type is not new, this object is remove
     * If this type's list is empty, this type's list is remove
     * @param typeOfContent
     *      a type of the object to remove
     * @param element
     *      a object te remove
     */
    public void removeContent(String typeOfContent, Object element){
        int index = verifyTypeOfContent(typeOfContent);
        if(index != -1){
            caseContent.get(index).remove(element);
            if(caseContent.get(index).size() == 0){
                caseContent.remove(index);
                listOfTypeOfContent.remove(index);
            }
        }
    }

    /**
     * If this type is not new, return the object's list of a type
     * If this type is new, return a null
     * @param typeOfContent
     *      a type of a object
     * @return a list of object
     */
    public List<Object> getContent(String typeOfContent){
        int index = verifyTypeOfContent(typeOfContent);
        if(index != -1){
            return caseContent.get(index);
        }
        else{
            return null;
        }
    }

    public List<List<Object>> getAllContent(){
        return caseContent;
    }

    /**
     * If this type is new, return -1
     * If this type is not new, return the list's index of this type
     * @param typeOfContent
     *      a object's type
     * @return
     */
    private int verifyTypeOfContent(String typeOfContent){
        for(int i = 0; i < caseContent.size(); i++){
            if(listOfTypeOfContent.get(i).equals(typeOfContent)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Create a new list for a new type and add a object to this list
     * Add a new type in the type's list
     * @param typeOfContent
     *      a new object's type
     * @param content
     *      a new object
     */
    private void addNewCaseContent(String typeOfContent,Object content){
        listOfTypeOfContent.add(typeOfContent);
        List<Object> list = new ArrayList<>();
        list.add(content);
        caseContent.add(list);
    }

    /**
     * Return the list of content's type
     * @return a list of string value
     */
    public List<String> getListOfTypeOfContent(){
        return listOfTypeOfContent;
    }

    /**
     * Return the list of object's list
     * @return a list of object's list
     */
    public List<List<Object>> getCaseContent(){
        return caseContent;
    }
}
