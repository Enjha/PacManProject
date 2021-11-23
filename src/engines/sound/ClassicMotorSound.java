package engines.sound;

public class ClassicMotorSound implements MotorSound{

    private SoundManager soundManager;
    private double volume = 0.3;

    public ClassicMotorSound(SoundManager soundManager){
        this.soundManager = soundManager;
    }

    public void playSound(String name,int cycle){
        soundManager.playSound(name,cycle);
    }

    public void stopSound(String name){
        soundManager.stopSound(name);
    }

    public void changeVolume(String name, double newVolume){
        volume = newVolume;
        soundManager.changeVolumeSound(name,newVolume);
    }

    public void changeVolumeAll(double newVolume){
        volume = newVolume;
        soundManager.changeVolumeAll(newVolume);
    }

    public double getVolume(){
        return volume;
    }

    public void mute(){
        changeVolumeAll(0);
    }

    public void unmute(){
        changeVolumeAll(volume);
    }
}
