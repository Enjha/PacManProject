package engines.kernel;

import engines.UI.Control;
import engines.UI.ControlEngine;
import engines.graphic.ClassicGraphicEngine;
import engines.graphic.GraphicEngine;
import engines.physic.PhysicEngine;
import engines.sound.SoundEngine;
import gameplay.Entity;
import gameplay.Game;
import javafx.scene.Scene;
import scene.SceneGame;

import java.util.List;

public class ClassicKernelEngine implements KernelEngine{

    //moteur graphique ici
    private GraphicEngine classicGraphicEngine;
    private SoundEngine soundEngine;
    private PhysicEngine physicEngine;
    private ControlEngine controlEngine;
    private Game game;

    public ClassicKernelEngine(Game game){
        this.game = game;
    }

    public Control getControl(String keyName){
        return controlEngine.getControl(keyName);
    }

    public double getVolume(){
        return soundEngine.getVolume();
    }

    public void setVolume(double volume){
        soundEngine.changeVolumeAll(volume);
    }

    public void setSoundEngine(SoundEngine soundEngine){
        this.soundEngine = soundEngine;
    }

    public void setPhysicEngine(PhysicEngine physicEngine){
        this.physicEngine = physicEngine;
    }

    public void setControlEngine(ControlEngine controlEngine){
        this.controlEngine = controlEngine;
    }

    public void setGraphicEngine(GraphicEngine graphicEngine){
        this.classicGraphicEngine = graphicEngine;
    }

    public Scene getCurrentScene(){
        return classicGraphicEngine.getCurrentScene();
    }

    public List<Control> getControl(Entity entity){
        return controlEngine.getControl(entity);
    }

    public List<Entity> getEntities(){
        return game.getEntities();
    }

    public boolean setControl(String oldKey,String newKey){
        return controlEngine.setKey(oldKey,newKey);
    }

    public void mute(){
        soundEngine.mute();
    }

    public void unmute(){
        soundEngine.unmute();
    }

    public SceneGame getSceneGame(){
        return game.getSceneGame();
    }

    public void setControlEngineState(boolean state){
        controlEngine.setEngineState(state);
    }
}
