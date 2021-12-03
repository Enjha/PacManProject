package engines.sound;

import javafx.scene.media.MediaPlayer;

public class ClassicSound implements Sound{

    private MediaPlayer sound;
    private String name;

    public ClassicSound(MediaPlayer sound, String name){
        assert (sound != null);
        assert (name != null && !name.equals(""));
        this.sound = sound;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public MediaPlayer getSound(){
        return sound;
    }

    /** Permet de jouer un fichier audio "cycle"-fois */
    public void play(int cycle){
        sound.setCycleCount(cycle);
        assert (cycle == sound.getCycleCount());
        sound.play();
        assert (sound.getStatus() == MediaPlayer.Status.PLAYING);
    }

    /** Permet d'arrêter l'écoute d'un fichier audio*/
    public void stop(){
        sound.stop();
        assert(sound.getStatus() == MediaPlayer.Status.STOPPED);
    }

    public void setVolume(double volume){
        sound.setVolume(volume);
        assert(sound.getVolume() == volume);
    }

}
