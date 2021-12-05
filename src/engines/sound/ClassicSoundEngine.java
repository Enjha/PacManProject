package engines.sound;

import javafx.scene.media.MediaPlayer;

/**
 * A classic sound engine
 */
public class ClassicSoundEngine implements SoundEngine {

    /**
     * The sound manager of this sound engine
     */
    private final SoundManager soundManager;

    /**
     * The volume of all sound
     */
    private double volume = 0.1;

    /**
     * <b>Constructor of ClassicSoundEngine</b>
     * @param soundManager
     *      A sound manager
     */
    public ClassicSoundEngine(SoundManager soundManager){
        assert soundManager != null : "Error : sound manager null";
        this.soundManager = soundManager;
    }

    /**
     * Play the sound register with this name during a cycle
     * @param name
     *      the sound's name
     * @param cycle
     *      the sound's cycle
     */
    public void playSound(String name,int cycle){
        assert name != null : "Error : name null";
        assert cycle > 0 || cycle ==  MediaPlayer.INDEFINITE: "Error : cycle <= 0";

        soundManager.playSound(name, cycle);
        soundManager.changeVolumeSound(name, volume);
    }

    /**
     * Stop the sound register with this name
     * @param name
     *      a sound's name
     */
    public void stopSound(String name){
        assert name != null : "Error : name null";
        soundManager.stopSound(name);
    }

    /**
     * Modify a sound's volume register with a name with a new volume
     * @param name
     *      a sound's name
     * @param newVolume
     *      a new volume
     */
    public void changeVolume(String name, double newVolume){
        assert name != null : "Error : name null";
        assert newVolume >= 0 : "Error : new volume < 0";
        volume = newVolume;
        soundManager.changeVolumeSound(name,newVolume);
    }

    /**
     * Modify all sound's volume to a new volume
     * @param newVolume
     *      a new volume
     */
    public void changeVolumeAll(double newVolume){
        assert newVolume >= 0 : "Error : new volume < 0";
        volume = newVolume;
        soundManager.changeVolumeAll(newVolume);
    }

    public double getVolume(){
        return volume;
    }

    /**
     * Mute all sound
     */
    public void mute(){
        changeVolumeAll(0);
    }

    /**
     * Unmute all sound
     */
    public void unmute(){
        changeVolumeAll(volume);
    }
}
