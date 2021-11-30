package gameplay;

import engines.physic.Collision;
import javafx.stage.Stage;
import scene.SceneGame;

import java.util.List;

public interface Game {

    void createEntity();
    List<Entity> getEntities();
    SceneGame getSceneGame();
    void generateSceneGame();
    void startEngine(Stage stage);
    void treatmentCollision(Movement movement,Collision collision);
}
