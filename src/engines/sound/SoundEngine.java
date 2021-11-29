package engines.sound;

public interface SoundEngine {

    void playSound(String name,int cycle);
    void stopSound(String name);
    void changeVolume(String name, double newVolume);
    void changeVolumeAll(double newVolume);
    double getVolume();
    void mute();
    void unmute();
}
