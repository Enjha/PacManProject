package engines.sound;

/**
 * Interface of the sound engine
 */
public interface SoundEngine {

    /**
     * Play the sound during a cycle
     * @param name
     *      the sound's name
     * @param cycle
     *      the cycle
     */
    void playSound(String name,int cycle);

    /**
     * Stop the sound
     * @param name
     *      the sound's name
     */
    void stopSound(String name);

    /**
     * Modify the sound's volume with a new volume
     * @param name
     *      the sound's name
     * @param newVolume
     *      the new volume
     */
    void changeVolume(String name, double newVolume);

    /**
     * Modify All sound's volume with a new volume
     * @param newVolume
     *      a new volume
     */
    void changeVolumeAll(double newVolume);

    /**
     * Return the volume's value
     * @return a double value
     */
    double getVolume();

    /**
     * Mute all sound
     */
    void mute();

    /**
     * Unmute all sound
     */
    void unmute();
}
