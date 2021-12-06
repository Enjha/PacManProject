package engines.graphic;

import apiUser.SetupScene;
import gameplay.Entity;
import gameplay.Team;
import pacman.view.GhostView;
import pacman.view.ItemView;
import pacman.view.PacManView;
import gameplay.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import pacman.*;
import pacman.view.WallViewPacman;
import scene.SceneGame;
import scene.SceneCase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Classic convert of a scene to graphic
 */
public class ClassicConvertSceneToGraphic implements ConvertSceneToGraphic {

    /**
     * The case size
     */
    private final double CASE_SIZE = 32;

    /**
     * The setup of the scene
     */
    private final SetupScene setupScene = new SetupScene();

    /**
     * The position x of a case in the labyrinth
     */
    private int x;

    /**
     * The position y of a case in the labyrinth
     */
    private int y;

    /**
     * The image view entities of all entities
     */
    private final List<ImageViewEntities> imageViewEntities = new ArrayList<>();

    /**
     * Setup the labyrinth texture
     * @param sceneGame
     *      the scene game
     * @param pane
     *      the pane
     */
    public void setLabyrinthTextureScene(SceneGame sceneGame, Pane pane) {
        assert sceneGame != null : "Error : scene game null";
        assert pane != null : "Error : pane null";

        x = 0;
        y = 0;
        final int originX = 130;
        final int originY = 40;
        final double TEXTURE_SIZE = 32;
        SceneCase[][] sceneCases = sceneGame.getCases();

        //Display all cases of the labyrinth
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                Image wall_texture = new WallViewPacman().getWallView(sceneCase);
                ImageView imageView = new ImageView();
                setupScene.setImageView(imageView, x * CASE_SIZE + originX, y * CASE_SIZE + originY, TEXTURE_SIZE, TEXTURE_SIZE, wall_texture, true);
                pane.getChildren().add(imageView);
                y++;
            }
            y = 0;
            x++;
        }
    }

    /**
     * Setup the entities texture
     * @param sceneGame
     *      a scene game
     * @param pane
     *      a pane
     */
    public void setEntityTextureScene(SceneGame sceneGame, Pane pane) {
        assert sceneGame != null : "Error : scene game";
        assert pane != null : "Error : pane null";

        x = 0;
        y = 0;
        double ENTITY_TEXTURE_SIZE = 16;
        SceneCase[][] sceneCases = sceneGame.getCases();
        ImageView imageView;

        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                imageView = new ImageView();
                int originEntitiesY = 49;
                int originEntitiesX = 139;

                //Display Pac-Man
                if (sceneCase.getCaseContent(Pacman.class.toString()) != null && sceneCase.getCaseContent(Pacman.class.toString()).size() > 0) {
                    ArrayList<Image> pacman_textures = new PacManView().getPacmanView((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originEntitiesX, y * CASE_SIZE + originEntitiesY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, pacman_textures.get(0), true);
                    pane.getChildren().add(imageView);
                    imageViewEntities.add(new ImageViewEntities(((Pacman)sceneCase.getCaseContent(Pacman.class.toString()).get(0)),imageView));
                    ((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0)).setxStartPosition(sceneCase.getX());
                    ((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0)).setyStartPosition(sceneCase.getY());

                }

                //Display a ghost
                else if (sceneCase.getCaseContent(Ghost.class.toString()) != null && sceneCase.getCaseContent(Ghost.class.toString()).size() > 0) {
                    for (Object o : sceneCase.getCaseContent(Ghost.class.toString())) {
                        Ghost ghost = (Ghost) o;
                        ArrayList<Image> ghost_textures = new GhostView().getGhostView(ghost);
                        setupScene.setImageView(imageView, x * CASE_SIZE + originEntitiesX, y * CASE_SIZE + originEntitiesY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, ghost_textures.get(0), true);
                        pane.getChildren().add(imageView);
                        imageViewEntities.add(new ImageViewEntities(((Ghost)sceneCase.getCaseContent(Ghost.class.toString()).get(0)),imageView));
                    }
                }

                //Display a normal fruit
                else if (sceneCase.getCaseContent(NormalFruit.class.toString()) != null && sceneCase.getCaseContent(NormalFruit.class.toString()).size() > 0) {
                    Image fruit_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(NormalFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originEntitiesX, y * CASE_SIZE + originEntitiesY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, fruit_texture, true);
                    imageViewEntities.add(new ImageViewEntities(((NormalFruit)sceneCase.getCaseContent(NormalFruit.class.toString()).get(0)),imageView));
                    pane.getChildren().add(imageView);
                }

                //Display a Pacgum
                else if (sceneCase.getCaseContent(PacgumFruit.class.toString()) != null && sceneCase.getCaseContent(PacgumFruit.class.toString()).size() > 0) {
                    Image pac_gum_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(PacgumFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originEntitiesX, y * CASE_SIZE + originEntitiesY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, pac_gum_texture, true);
                    imageViewEntities.add(new ImageViewEntities(((PacgumFruit)sceneCase.getCaseContent(PacgumFruit.class.toString()).get(0)),imageView));
                    pane.getChildren().add(imageView);
                }
                y++;
            }
            y = 0;
            x++;
        }
    }

    /**
     * Return all image view entities
     * @return a list of object type of ImageViewEntities
     */
    public List<ImageViewEntities> getImageViewEntities(){
        return imageViewEntities;
    }
}
