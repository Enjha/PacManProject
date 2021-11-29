package engines.UI;

import gameplay.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassicControlManager implements ControlManager{

    private final HashMap<String,Control> controls = new HashMap<>();

    /**
     * Permet d'ajouter une touche dans la hashmap controls qui permet de garder en mémoire les touches utilisateurs
     * @param control
     */
    public void addControl(Control control){
        if(!controls.containsKey(control.getKey())){
            controls.put(control.getKey(),control);
        }
    }

    /**
     * Permet de supprimer une des touches conservées pour les commandes utilisateurs
     * @param control
     */
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

    /**
     * Permet de récupérer les controls suivant l'utilisateur donné (pour le mode multijoueur)
     * @param entity
     * @return
     */
    public List<Control> getControl(Entity entity){
        List<Control> listControl = new ArrayList<>();
        for(Control control : controls.values()) {
            if(control.getEntity() == entity){
                listControl.add(control);
            }
        }
        return listControl;
    }

    /**
     * Modifie les controles suivant ce que l'utilisateur voudra utiliser
     * @param oldKey
     * @param newKey
     * @return
     */
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
