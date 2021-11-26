package scene;

import gameplay.Movement;

public interface Scene {

    boolean addSceneCase(SceneCase sceneCase, int x, int y);
    boolean removeSceneCase(int x, int y);
    SceneCase getCase(int x, int y);
    SceneCase[][] getCases();
    SceneElement obstacle(int x, int y, Movement movement);
}
