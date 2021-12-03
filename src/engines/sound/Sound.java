package engines.sound;

import javafx.scene.media.MediaPlayer;

/**
 * The interface of a sound
 */
public interface Sound {

    /**
     * The sound's name
     * @return a string value
     */
    String getName();

    /**
     * The sound
     * @return a object type of MediaPlayer
     */
    MediaPlayer getSound();

    /**
     * Play the sound
     * @param cycle
     *      the cycle of the sound play
     */
    void play(int cycle);

    /**
     * Stop the sound
     */
    void stop();

    /**
     * Modify the sound's volume with a new volume
     * @param volume
     *      the new volume
     */
    void setVolume(double volume);
}
