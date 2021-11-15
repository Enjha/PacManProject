package engines.UI;

import java.util.HashMap;

public class ClassicControlManager implements ControlManager{

    private HashMap<String,Control> controls = new HashMap<>();

    public void addControl(Control control){
        if(!controls.containsKey(control.getKey())){
            controls.put(control.getKey(),control);
        }
    }

    public void removeControl(Control control){
        if(controls.containsKey(control.getKey())){
            controls.remove(control.getKey());
        }
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
