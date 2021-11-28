package engines.kernel;

import engines.UI.Control;
import engines.UI.MotorControl;
import engines.graphic.GraphicEngine;
import engines.physic.MotorPhysic;
import engines.sound.MotorSound;
import gameplay.Entity;
import gameplay.Game;
import javafx.scene.Scene;
import scene.SceneGame;

import java.util.List;

public class ClassicKernelEngine implements KernelEngine{

    //moteur graphique ici
    private GraphicEngine graphicEngine;
    private MotorSound motorSound;
    private MotorPhysic motorPhysic;
    private MotorControl motorControl;
    private Game game;

    public ClassicKernelEngine(Game game){
        this.game = game;
    }

    public Control getControl(String keyName){
        return motorControl.getControl(keyName);
    }

    public double getVolume(){
        return motorSound.getVolume();
    }

    public void setVolume(double volume){
        motorSound.changeVolumeAll(volume);
    }

    public void setMotorSound(MotorSound motorSound){
        this.motorSound = motorSound;
    }

    public void setMotorPhysic(MotorPhysic motorPhysic){
        this.motorPhysic = motorPhysic;
    }

    public void setMotorControl(MotorControl motorControl){
        this.motorControl = motorControl;
    }

    public void setGraphicEngine(GraphicEngine graphicEngine){
        this.graphicEngine = graphicEngine;
    }

    public Scene getCurrentScene(){
        return graphicEngine.getCurrentScene();
    }

    public List<Control> getControl(Entity entity){
        return motorControl.getControl(entity);
    }

    public List<Entity> getEntities(){
        return game.getEntities();
    }

    public boolean setControl(String oldKey,String newKey){
        return motorControl.setKey(oldKey,newKey);
    }

    public void mute(){
        motorSound.mute();
    }

    public void unmute(){
        motorSound.unmute();
    }

    public SceneGame getSceneGame(){
        return game.getSceneGame();
    }
}
