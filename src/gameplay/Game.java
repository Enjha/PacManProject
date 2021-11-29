package gameplay;

import javafx.stage.Stage;
import scene.SceneGame;

import java.util.List;

public interface Game {

    void createEntity();
    List<Entity> getEntities();
    SceneGame getSceneGame();
    void generateSceneGame();
    void startEngine(Stage stage);
}
