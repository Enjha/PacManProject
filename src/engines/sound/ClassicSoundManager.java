package engines.sound;

import java.util.HashMap;

public class ClassicSoundManager implements SoundManager{

    private HashMap<String,Sound> sounds = new HashMap<>();

    /**
     * Permet d'ajouter un fichier audio à la hashmap de ceux que nous voulons jouer
     * @param sound
     */
    public void addSound(Sound sound){
        if(!sounds.containsKey(sound.getName())){
            sounds.put(sound.getName(),sound);
        }
    }

    /**
     * Permet de retirer un son de la hashmap de ceux que nous voulons jouer
     * @param sound
     */
    public void removeSound(Sound sound){
        if(sounds.containsKey(sound.getName())){
            sounds.remove(sound);
        }
    }

    /**
     * Permet de jouer le fichier audio et de lui attribuer un cycle
     * @param name
     * @param cycle
     */
    public void playSound(String name,int cycle){
        if(sounds.containsKey(name)){
            sounds.get(name).play(cycle);
        }
    }

    /**
     * Arrêter l'écoute du son mis en argument
     * @param name
     */
    public void stopSound(String name){
        if(sounds.containsKey(name)){
            sounds.get(name).stop();
        }
    }

    /**
     * Permet de changer le volume du fichier audio joué mis en argument
     * @param name
     * @param newVolume
     */
    public void changeVolumeSound(String name, double newVolume){
        if(sounds.containsKey(name)){
            sounds.get(name).setVolume(newVolume);
        }
    }

    /**
     * Permet de modifier le volume de tous les fichiers audios en cours.
     * @param newVolume
     */
    public void changeVolumeAll(double newVolume){
        for(Sound sound : sounds.values()){
            sound.setVolume(newVolume);
        }
    }


}
