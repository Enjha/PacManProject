package engines.UI;

import gameplay.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassicControlManager implements ControlManager{

    private final HashMap<String,Control> controls = new HashMap<>();

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

    public Control getControl(String keyName){
        if(controls.containsKey(keyName)){
            return controls.get(keyName);
        }
        return null;
    }

    public List<Control> getControl(Entity entity){
        List<Control> listControl = new ArrayList<>();
        for(Control control : controls.values()) {
            if(control.getEntity() == entity){
                listControl.add(control);
            }
        }
        return listControl;
    }

    public boolean setControl(String oldKey, String newKey){
        if(controls.containsKey(oldKey) && !controls.containsKey(newKey)){
            Control control = controls.get(oldKey);
            control.setKey(newKey);
            controls.remove(oldKey);
            controls.put(control.getKey(),control);
            return true;
        }
        return false;
    }

}
