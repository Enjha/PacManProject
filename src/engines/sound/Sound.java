package engines.sound;

import javafx.scene.media.MediaPlayer;

public interface Sound {

    String getName();
    MediaPlayer getSound();
    void play(int cycle);
    void stop();
    void setVolume(double volume);
}
