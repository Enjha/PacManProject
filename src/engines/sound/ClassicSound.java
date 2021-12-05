package engines.sound;

import javafx.scene.media.MediaPlayer;

/**
 * A classic sound
 */
public class ClassicSound implements Sound{

    /**
     * The sound
     */
    private MediaPlayer sound;

    /**
     * the sound's name
     */
    private String name;

    /**
     * <b>Constructor of ClassicSound</b>
     * @param sound
     *      a sound
     * @param name
     *      s sound's name
     */
    public ClassicSound(MediaPlayer sound, String name){
        assert sound != null : "Error : sound null";
        assert name != null : "Error : name null";
        this.sound = sound;
        this.name = name;
    }

    /**
     * Return the sound's name
     * @return a string value
     */
    public String getName(){
        return name;
    }

    /**
     * Return the sound
     * @return a object type of MediaPlayer
     */
    public MediaPlayer getSound(){
        return sound;
    }

    /**7
     * Play the sound during a cycle
     * @param cycle
     *      a cycle
     */
    public void play(int cycle){
        assert cycle > 0 || cycle == MediaPlayer.INDEFINITE : "Error : cycle <= 0";
        sound.setCycleCount(cycle);
        sound.play();
    }

    /**
     * Stop the sound
     */
    public void stop(){
        sound.stop();
    }

    /**
     * Modify the sound's volume with a new volume
     * @param volume
     *      a new volume
     */
    public void setVolume(double volume){
        assert volume >= 0 : "Error : volume < 0";
        sound.setVolume(volume);
        assert sound.getVolume() == volume : "Error : the volume of the sound don't correspond";
    }

}
