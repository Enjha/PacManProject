package engines.sound;

import javafx.scene.media.MediaPlayer;

public class ClassicSound implements Sound{

    private MediaPlayer sound;
    private String name;

    public ClassicSound(MediaPlayer sound, String name){
        this.sound = sound;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public MediaPlayer getSound(){
        return sound;
    }

    public void play(int cycle){
        sound.setCycleCount(cycle);
        sound.play();
    }

    public void stop(){
        sound.stop();
    }

    public void setVolume(double volume){
        sound.setVolume(volume);
    }

}
