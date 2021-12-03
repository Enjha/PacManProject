package pacman.scene;

import gameplay.Entity;
import gameplay.Game;
import scene.SceneGame;

import java.util.List;

public interface LabyrinthGenerator {

    SceneGame generateLabyrinth();
    List<Entity> generateEntity(SceneGame sceneGame, Game game);
}
