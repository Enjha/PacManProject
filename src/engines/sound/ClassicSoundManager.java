package engines.sound;

import java.util.HashMap;

public class ClassicSoundManager implements SoundManager{

    private HashMap<String,Sound> sounds = new HashMap<>();

    public void addSound(Sound sound){
        if(!sounds.containsKey(sound.getName())){
            sounds.put(sound.getName(),sound);
        }
    }

    public void removeSound(Sound sound){
        if(sounds.containsKey(sound.getName())){
            sounds.remove(sound);
        }
    }

    public void playSound(String name,int cycle){
        if(sounds.containsKey(name)){
            sounds.get(name).play(cycle);
        }
    }

    public void stopSound(String name){
        if(sounds.containsKey(name)){
            sounds.get(name).stop();
        }
    }

    public void changeVolumeSound(String name, double newVolume){
        if(sounds.containsKey(name)){
            sounds.get(name).setVolume(newVolume);
        }
    }

    public void changeVolumeAll(double newVolume){
        for(Sound sound : sounds.values()){
            sound.setVolume(newVolume);
        }
    }


}
