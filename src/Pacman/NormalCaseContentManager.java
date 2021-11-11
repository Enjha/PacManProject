package Pacman;

import Scene.CaseContentManager;

import java.util.ArrayList;
import java.util.List;

public class NormalCaseContentManager implements CaseContentManager {

    private List<String> listOfTypeOfContent = new ArrayList<>();
    private List<List<Object>> caseContent = new ArrayList<>();

    public void addContent(String typeOfContent, Object content){
        int index = verifyTypeOfContent(typeOfContent);
        if(index == -1){
            addNewCaseContent(typeOfContent,content);
        }
        else {
            caseContent.get(index).add(content);
        }
    }

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

    public List<Object> getContent(String typeOfContent){
        int index = verifyTypeOfContent(typeOfContent);
        if(index != -1){
            return caseContent.get(index);
        }
        else{
            return null;
        }
    }

    private int verifyTypeOfContent(String typeOfContent){
        for(int i = 0; i < caseContent.size(); i++){
            if(listOfTypeOfContent.get(i).equals(typeOfContent)){
                return i;
            }
        }
        return -1;
    }

    private void addNewCaseContent(String typeOfContent,Object content){
        listOfTypeOfContent.add(typeOfContent);
        List<Object> list = new ArrayList<>();
        list.add(content);
        caseContent.add(list);
    }
}
