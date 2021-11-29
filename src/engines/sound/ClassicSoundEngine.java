package engines.sound;

public class ClassicSoundEngine implements SoundEngine {

    private SoundManager soundManager;
    private double volume = 0.3;

    public ClassicSoundEngine(SoundManager soundManager){
        this.soundManager = soundManager;
    }

    public void playSound(String name,int cycle){
        soundManager.playSound(name,cycle);
    }

    public void stopSound(String name){
        soundManager.stopSound(name);
    }

    /**
     * Permet de changer le volume d'un fichier audio précis
     * @param name
     * @param newVolume
     */
    public void changeVolume(String name, double newVolume){
        volume = newVolume;
        soundManager.changeVolumeSound(name,newVolume);
    }

    /**
     * Permet de modifier le volume de tous les fichiers audios.
     * @param newVolume
     */
    public void changeVolumeAll(double newVolume){
        volume = newVolume;
        soundManager.changeVolumeAll(newVolume);
    }

    public double getVolume(){
        return volume;
    }

    /**
     * Permet de mettre le son global à 0 (tous les fichiers audio au volume 0)
     */
    public void mute(){
        changeVolumeAll(0);
    }

    /**
     * Remettre le son
     */
    public void unmute(){
        changeVolumeAll(volume);
    }
}
