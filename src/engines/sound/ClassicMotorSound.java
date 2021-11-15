package engines.sound;

public class ClassicMotorSound implements MotorSound{

    private SoundManager soundManager;

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
        soundManager.changeVolumeSound(name,newVolume);
    }

    public void changeVolumeAll(double newVolume){
        soundManager.changeVolumeAll(newVolume);
    }
}
