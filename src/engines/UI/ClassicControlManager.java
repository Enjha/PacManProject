package engines.UI;

import java.util.HashMap;

public class ClassicControlManager implements ControlManager{

    private HashMap<String,Control> controls;

    public ClassicControlManager(HashMap<String,Control> controls){
        this.controls = controls;
    }

    public Control getControl(String key){
        if(controls.containsKey(key)){
            return controls.get(key);
        }
        return null;
    }

    public boolean setControl(String oldKey, String newKey){
        if(controls.containsKey(oldKey)){
            controls.get(oldKey).setKey(newKey);
            return true;
        }
        return false;
    }

}
