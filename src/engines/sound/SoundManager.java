package engines.sound;

/**
 * The interface of a sound manager
 */
public interface SoundManager {

    /**
     * Add a new sound
     * @param sound
     *      a new sound to add
     */
    void addSound(Sound sound);

    /**
     * Remove a sound
     * @param sound
     *      a sound to remove
     */
    void removeSound(Sound sound);

    /**
     * Play a sound during a cycle
     * @param name
     *      a sound's name
     * @param cycle
     *      a cycle
     */
    void playSound(String name,int cycle);

    /**
     * Stop a sound
     * @param name
     *      a sound's name
     */
    void stopSound(String name);

    /**
     * Modify a sound's volume with a new value
     * @param name
     *      a sound's name
     * @param newVolume
     *      a new volume
     */
    void changeVolumeSound(String name, double newVolume);

    /**
     * Modify all sound's volume
     * @param newVolume
     *      a new volume
     */
    void changeVolumeAll(double newVolume);
}
