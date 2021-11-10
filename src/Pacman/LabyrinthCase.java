package Pacman;

import Scene.SceneCase;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthCase implements SceneCase {

    private List<Object> caseContent = new ArrayList<>();
    private int x;
    private int y;
    private double height;
    private double width;

    public LabyrinthCase(int x, int y, double height, double width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public boolean addCaseContent(Object object){
        if(!caseContent.contains(object)) {
            caseContent.add(object);
            return true;
        }
        return false;
    }

    public boolean removeCaseContent(Object object){
        if(caseContent.contains(object)){
            caseContent.remove(object);
            return true;
        }
        return false;
    }

    public List<Object> getCaseContent(){
        return caseContent;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

}
