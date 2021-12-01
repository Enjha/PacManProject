package ghost.scene;

import gameplay.Entity;
import scene.SceneGame;

import java.util.List;

public interface LabyrinthGenerator {

    SceneGame generateLabyrinth();
    List<Entity> generateEntity(SceneGame sceneGame);
}
