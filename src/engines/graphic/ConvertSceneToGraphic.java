package engines.graphic;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import scene.SceneGame;

public interface ConvertSceneToGraphic {

    void setLabyrinthTextureScene(SceneGame sceneGame, Pane pane);
    void setEntityTextureScene(SceneGame sceneGame,Pane pane);
}
