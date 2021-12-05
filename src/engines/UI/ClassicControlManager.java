package engines.UI;

import gameplay.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A classic control manager
 */
public class ClassicControlManager implements ControlManager{

    /**
     * The map of all control register
     */
    private final HashMap<String,Control> controls = new HashMap<>();

    /**
     * Add a new control
     * @param control
     *      a new control to add
     */
    public void addControl(Control control){
        assert control != null : "Error : control null";
        if(!controls.containsKey(control.getKey())){
            controls.put(control.getKey(),control);
        }
    }

    /**
     * Remove a control
     * @param control
     *      a control to remove
     */
    public void removeControl(Control control){
        assert control != null : "Error : control null";
        controls.remove(control.getKey());
    }

    /**
     * Return the control register with this key name or null if this key name is not register
     * @param keyName
     *      a control's key name
     * @return a object type of Control
     */
    public Control getControl(String keyName){
        assert keyName != null : "Error : key name null";
        if(controls.containsKey(keyName)){
            return controls.get(keyName);
        }
        return null;
    }

    /**
     * Return all control for a entity
     * @param entity
     *      a entity
     * @return a list of object type of Control
     */
    public List<Control> getControl(Entity entity){
        assert entity != null : "Error : entity null";
        List<Control> listControl = new ArrayList<>();
        for(Control control : controls.values()) {
            if(control.getEntity() == entity){
                listControl.add(control);
            }
        }
        return listControl;
    }

    /**
     * Modify a control key with a new one
     * @param oldKey
     *      a old key
     * @param newKey
     *      a new key
     * @return a boolean value
     */
    public boolean setControl(String oldKey, String newKey){
        assert oldKey != null : "Error : old key null";
        assert newKey != null : "Error : new key null";
        if(controls.containsKey(oldKey) && !controls.containsKey(newKey)){
            Control control = controls.get(oldKey);
            control.setKey(newKey);
            controls.remove(oldKey);
            controls.put(control.getKey(),control);
            return (controls.containsKey(newKey) && !controls.containsKey(oldKey));
        }
        return false;
    }
}
