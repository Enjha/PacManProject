package engines.graphic;

import javafx.scene.layout.AnchorPane;
import scene.SceneGame;

public interface ConvertSceneToGraphic {

    void setLabyrinthTextureScene(SceneGame sceneGame, AnchorPane anchorPane);
    void setEntityTextureScene(SceneGame sceneGame,AnchorPane anchorPane);
}
