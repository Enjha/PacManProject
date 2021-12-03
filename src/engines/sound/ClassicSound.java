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
        assert (sound != null);
        assert (name != null && !name.equals(""));
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
        sound.setCycleCount(cycle);
        assert (cycle == sound.getCycleCount());
        sound.play();
        assert (sound.getStatus() == MediaPlayer.Status.PLAYING);
    }

    /**
     * Stop the sound
     */
    public void stop(){
        sound.stop();
        assert(sound.getStatus() == MediaPlayer.Status.STOPPED);
    }

    /**
     * Modify the sound's volume with a new volume
     * @param volume
     *      a new volume
     */
    public void setVolume(double volume){
        sound.setVolume(volume);
        assert(sound.getVolume() == volume);
    }

}
