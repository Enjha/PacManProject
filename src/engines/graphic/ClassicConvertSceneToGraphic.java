package engines.graphic;

import apiUser.SetupScene;
import gameplay.Entity;
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
 * Cette classe va se charger de récupérer dans chaque case de la scène les entité/wall
 * et afficher leur textures aux coordonnées voulues.
 */
public class ClassicConvertSceneToGraphic implements ConvertSceneToGraphic {

    // Taille d'une case de la scene
    private final double CASE_SIZE = 32;
    private final int originEntitiesY = 49;
    private final int originEntitiesX = 139;
    // Instanciation d'un setupScene de l'API
    private final SetupScene setupScene = new SetupScene();
    // Initialization de la case x
    private int x;
    // Initialization de la case y
    private int y;
    private final List<ImageViewEntities> imageViewEntities = new ArrayList<>();

    /**
     * Cette fonction permet de placer les textures du labyrinth sur la scene.
     *
     * @param sceneGame La scene de jeu
     * @param pane      La pane qui sera afficher sur la scene
     */
    @Override
    public void setLabyrinthTextureScene(SceneGame sceneGame, Pane pane) {
        x = 0;
        y = 0;
        final int originX = 130;
        final int originY = 40;
        final double TEXTURE_SIZE = 32;
        SceneCase[][] sceneCases = sceneGame.getCases();
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
     * Cette fonction permet de placer les textures des entitées présente sur la scene.
     *
     * @param sceneGame La scene de jeu
     * @param pane      La pane qui sera afficher sur la scene
     */
    @Override
    public void setEntityTextureScene(SceneGame sceneGame, Pane pane) {
        x = 0;
        y = 0;
        double ENTITY_TEXTURE_SIZE = 16;
        SceneCase[][] sceneCases = sceneGame.getCases();
        ImageView imageView;
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                imageView = new ImageView();
                if (sceneCase.getCaseContent(Pacman.class.toString()) != null && sceneCase.getCaseContent(Pacman.class.toString()).size() > 0) {
                    ArrayList<Image> pacman_textures = new PacManView().getPacmanView((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0));
                    // CREE UNE ANIMATION
                    setupScene.setImageView(imageView, x * CASE_SIZE + originEntitiesX, y * CASE_SIZE + originEntitiesY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, pacman_textures.get(0), true);
                    pane.getChildren().add(imageView);
                    imageViewEntities.add(new ImageViewEntities(((Pacman)sceneCase.getCaseContent(Pacman.class.toString()).get(0)),imageView));
                    ((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0)).setxStartPosition(sceneCase.getX());
                    ((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0)).setyStartPosition(sceneCase.getY());
                }

                if (sceneCase.getCaseContent(Ghost.class.toString()) != null && sceneCase.getCaseContent(Ghost.class.toString()).size() > 0) {
                    for (Object o : sceneCase.getCaseContent(Ghost.class.toString())) {
                        Ghost ghost = (Ghost) o;
                        ArrayList<Image> ghost_textures = new GhostView().getGhostView(ghost);
                        // CREE UNE ANIMATION
                        setupScene.setImageView(imageView, x * CASE_SIZE + originEntitiesX, y * CASE_SIZE + originEntitiesY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, ghost_textures.get(0), true);
                        pane.getChildren().add(imageView);
                        imageViewEntities.add(new ImageViewEntities(((Ghost)sceneCase.getCaseContent(Ghost.class.toString()).get(0)),imageView));

                    }
                }

                if (sceneCase.getCaseContent(NormalFruit.class.toString()) != null && sceneCase.getCaseContent(NormalFruit.class.toString()).size() > 0) {
                    Image fruit_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(NormalFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originEntitiesX, y * CASE_SIZE + originEntitiesY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, fruit_texture, true);
                    imageViewEntities.add(new ImageViewEntities(((NormalFruit)sceneCase.getCaseContent(NormalFruit.class.toString()).get(0)),imageView));
                    pane.getChildren().add(imageView);
                }

                if (sceneCase.getCaseContent(PacgumFruit.class.toString()) != null && sceneCase.getCaseContent(PacgumFruit.class.toString()).size() > 0) {
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

    public List<ImageViewEntities> getImageViewEntities(){
        return imageViewEntities;
    }

    public void setEntityPosition(Entity entity,ImageView imageView){
       //imageView.setLayoutX(entity.getPosition().getX() * CASE_SIZE + originEntitiesX);
       //imageView.setLayoutY(entity.getPosition().getY() * CASE_SIZE + originEntitiesY);
    }
}
