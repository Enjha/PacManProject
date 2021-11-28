package gameplay;

import gameplay.Entity;
import scene.SceneGame;

import java.util.List;

public interface Game {

    void addEntity(Entity entity);
    List<Entity> getEntities();
    SceneGame getSceneGame();
}
