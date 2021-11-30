package engines.kernel;

import engines.UI.Control;
import engines.UI.ControlEngine;
import engines.graphic.GraphicEngine;
import engines.physic.Collision;
import engines.physic.PhysicEngine;
import engines.sound.SoundEngine;
import gameplay.Entity;
import gameplay.Game;
import gameplay.Movement;
import gameplay.Character;
import javafx.scene.Scene;
import scene.SceneGame;

import java.util.List;

public class ClassicKernelEngine implements KernelEngine{

    private GraphicEngine graphicEngine;
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
        this.graphicEngine = graphicEngine;
    }

    public Scene getCurrentScene(){
        return graphicEngine.getCurrentScene();
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

    public void setControlEngineScene(Scene scene){
        controlEngine.setScene(scene);
    }

    public void treatmentCollisionGame(Movement movement){
        if(physicEngine != null) {
            Collision collision = physicEngine.moveEntity(movement, game.getSceneGame());
            game.treatmentCollision(movement,collision);
        }
        else {
            System.out.println("error : physic engine null");
        }
    }

    public void setMovementEntity(Movement movement){
        if(movement.getEntity().isCharacter()) {
            game.getThreadEntity(movement.getEntity()).setMovement(movement);
            game.startThreadEntity();
        }
    }

    public void updateSceneGame(Entity entity){
        graphicEngine.updateSceneGame(entity);
    }
}
