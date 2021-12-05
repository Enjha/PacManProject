package engines.sound;

import javafx.scene.media.MediaPlayer;

import java.util.HashMap;

/**
 * A classic sound manager
 */
public class ClassicSoundManager implements SoundManager{

    /**
     * The map with all sound register
     */
    private final HashMap<String,Sound> sounds = new HashMap<>();

    /**
     * Add a new sound to the map if his name is not already register
     * @param sound
     *      a new sound to add
     */
    public void addSound(Sound sound){
        assert sound != null : "Error : sound null";
        if(!sounds.containsKey(sound.getName())){
            sounds.put(sound.getName(),sound);
            assert sounds.containsKey(sound.getName()) : "Error : sound not correctly add";
        }
    }

    /**
     * Remove a sound if this sound is already register
     * @param sound
     *      a sound to remove
     */
    public void removeSound(Sound sound){
        assert sound != null : "Error : sound null";
        if(sounds.containsKey(sound.getName())){
            sounds.remove(sound.getName());
            assert !sounds.containsKey(sound.getName()) : "Error : sound not correctly remove";
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
        assert cycle > 0 : "Error : cycle <= 0";
        assert name != null : "name null";
        if(sounds.containsKey(name)){
            sounds.get(name).play(cycle);
            assert sounds.get(name).getSound().getStatus() == MediaPlayer.Status.PLAYING : "Error : the sound is not played";
            assert sounds.get(name).getSound().getCycleCount() == cycle : "Error : the cycle don't correspond";
        }
    }

    /**
     * Stop a sound if its register
     * @param name
     *      a sound's name
     */
    public void stopSound(String name){
        assert name != null : "Error : name null";
        if(sounds.containsKey(name)){
            sounds.get(name).stop();
            assert sounds.get(name).getSound().getStatus() == MediaPlayer.Status.STOPPED : "Error :  the sound is not stopped";
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
        assert name != null : "Error : name null";
        assert newVolume >= 0 : "Error : new volume < 0";
        if(sounds.containsKey(name)){
            sounds.get(name).setVolume(newVolume);
            assert sounds.get(name).getSound().getVolume() == newVolume : "Error : the volume of the sound don't correspond";
        }
    }

    /**
     * Modify all sound's volume with a new volume
     * @param newVolume
     *      a new volume
     */
    public void changeVolumeAll(double newVolume){
        assert newVolume >= 0 : "Error : the new volume < 0";
        for(Sound sound : sounds.values()){
            sound.setVolume(newVolume);
            assert sound.getSound().getVolume() == newVolume : "Error : the volume of the sound don't correspond";
        }
    }


}
