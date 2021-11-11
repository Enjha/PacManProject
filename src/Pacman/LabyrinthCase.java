package Pacman;

import Scene.CaseContentManager;
import Scene.SceneCase;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthCase implements SceneCase {

    private CaseContentManager caseContentManager;
    private int x;
    private int y;

    public LabyrinthCase(int x, int y, CaseContentManager caseContentManager){
        this.x = x;
        this.y = y;
        this.caseContentManager = caseContentManager;
    }

    public void addCaseContent(Object object){
        caseContentManager.addContent(object.getClass().toString(),object);
    }

    public void removeCaseContent(Object object){
        caseContentManager.removeContent(object.getClass().toString(),object);
    }

    public List<Object> getCaseContent(String typeOfElement){
        return caseContentManager.getContent(typeOfElement);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
