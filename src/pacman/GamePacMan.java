package pacman;

import gameplay.Entity;
import gameplay.Game;
import scene.SceneCase;
import scene.SceneGame;

import java.util.ArrayList;
import java.util.List;

public class GamePacMan implements Game {

    private List<Entity> entities = new ArrayList<>();
    private SceneGame sceneGame;

    public GamePacMan(SceneGame sceneGame){
        this.sceneGame = sceneGame;
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public List<Entity> getEntities(){
        return entities;
    }

    public SceneGame getSceneGame(){
        return sceneGame;
    }
}
