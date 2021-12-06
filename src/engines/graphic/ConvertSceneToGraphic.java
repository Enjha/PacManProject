package engines.graphic;

import javafx.scene.layout.Pane;
import scene.SceneGame;

import java.util.List;

/**
 * The interface of a convert scene to graphic
 */
public interface ConvertSceneToGraphic {

    /**
     * Setup the labyrinth texture
     * @param sceneGame
     *      the scene game
     * @param pane
     *      the pane
     */
    void setLabyrinthTextureScene(SceneGame sceneGame, Pane pane);

    /**
     * Setup the entities texture
     * @param sceneGame
     *      a scene game
     * @param pane
     *      a pane
     */
    void setEntityTextureScene(SceneGame sceneGame,Pane pane);

    /**
     * Return all image view entities
     * @return a list of object type of ImageViewEntities
     */
    List<ImageViewEntities> getImageViewEntities();
}
