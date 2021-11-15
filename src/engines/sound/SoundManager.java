package engines.sound;

public interface SoundManager {

    void addSound(Sound sound);
    void removeSound(Sound sound);
    void playSound(String name,int cycle);
    void stopSound(String name);
    void changeVolumeSound(String name, double newVolume);
    void changeVolumeAll(double newVolume);
}
