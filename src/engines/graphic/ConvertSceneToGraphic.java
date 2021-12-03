package engines.graphic;

import gameplay.Entity;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import scene.SceneGame;

import java.awt.*;
import java.util.List;

public interface ConvertSceneToGraphic {

    void setLabyrinthTextureScene(SceneGame sceneGame, Pane pane);
    void setEntityTextureScene(SceneGame sceneGame,Pane pane);
    List<ImageViewEntities> getImageViewEntities();
    void setEntityPosition(Entity entity, ImageView imageView);
}
