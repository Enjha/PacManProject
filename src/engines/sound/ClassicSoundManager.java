package engines.sound;

import java.util.HashMap;

public class ClassicSoundManager implements SoundManager{

    private HashMap<String,Sound> sounds = new HashMap<>();

    /**
     * Add a new sound to the map if his name is not already register
     * @param sound
     *      a new sound to add
     */
    public void addSound(Sound sound){
        if(!sounds.containsKey(sound.getName())){
            sounds.put(sound.getName(),sound);
        }
    }

    /**
     * Remove a sound if this sound is already register
     * @param sound
     *      a sound to remove
     */
    public void removeSound(Sound sound){
        if(sounds.containsKey(sound.getName())){
            sounds.remove(sound);
        }
    }

    /**
     * Play a sound during a cycle if its register
     * @param name
     *      a sound's name
     * @param cycle
     *      a cycle
     */
    public void playSound(String name,int cycle){
        if(sounds.containsKey(name)){
            sounds.get(name).play(cycle);
        }
    }

    /**
     * Stop a sound if its register
     * @param name
     *      a sound's name
     */
    public void stopSound(String name){
        if(sounds.containsKey(name)){
            sounds.get(name).stop();
        }
    }

    /**
     * Modify a sound's volume with a new volume if its register
     * @param name
     *      a sound's name
     * @param newVolume
     *      a new volume
     */
    public void changeVolumeSound(String name, double newVolume){
        if(sounds.containsKey(name)){
            sounds.get(name).setVolume(newVolume);
        }
    }

    /**
     * Modify all sound's volume with a new volume
     * @param newVolume
     *      a new volume
     */
    public void changeVolumeAll(double newVolume){
        for(Sound sound : sounds.values()){
            sound.setVolume(newVolume);
        }
    }


}
