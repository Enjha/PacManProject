package engines.graphic;

import apiUser.SetupScene;
import engines.graphic.view.GhostView;
import engines.graphic.view.ItemView;
import engines.graphic.view.PacManView;
import gameplay.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import pacman.*;
import scene.SceneGame;
import scene.SceneCase;

import java.util.ArrayList;

/**
 * Cette classe va se charger de récupérer dans chaque case de la scène les entité/wall
 * et afficher leur textures aux coordonnées voulues.
 */
public class ClassicConvertSceneToGraphic implements ConvertSceneToGraphic {

    // Taille d'une case de la scene
    private final double CASE_SIZE = 32;
    // Instanciation d'un setupScene de l'API
    private final SetupScene setupScene = new SetupScene();
    // Initialization de la case x
    private int x;
    // Initialization de la case y
    private int y;

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
        final int originX = 100;
        final int originY = 0;
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
        int originY = 9;
        int originX = 109;
        double ENTITY_TEXTURE_SIZE = 16;
        SceneCase[][] sceneCases = sceneGame.getCases();
        ImageView imageView;
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {

                if (sceneCase.getCaseContent(Pacman.class.toString()) != null && sceneCase.getCaseContent(Pacman.class.toString()).size() > 0) {
                    ArrayList<Image> pacman_textures = new PacManView().getPacmanView((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0));
                    // CREE UNE ANIMATION
                    imageView = new ImageView();
                    setupScene.setImageView(imageView, x * CASE_SIZE + originX, y * CASE_SIZE + originY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, pacman_textures.get(0), true);
                    pane.getChildren().add(imageView);
                }

                if (sceneCase.getCaseContent(Ghost.class.toString()) != null && sceneCase.getCaseContent(Ghost.class.toString()).size() > 0) {
                    for (Object o : sceneCase.getCaseContent(Ghost.class.toString())) {
                        Ghost ghost = (Ghost) o;
                        ArrayList<Image> ghost_textures = new GhostView().getGhostView(ghost);
                        // CREE UNE ANIMATION
                        imageView = new ImageView();
                        setupScene.setImageView(imageView, x * CASE_SIZE + originX, y * CASE_SIZE + originY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, ghost_textures.get(0), true);
                        pane.getChildren().add(imageView);
                    }
                }
                imageView = new ImageView();

                if (sceneCase.getCaseContent(NormalFruit.class.toString()) != null && sceneCase.getCaseContent(NormalFruit.class.toString()).size() > 0) {
                    Image fruit_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(NormalFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originX, y * CASE_SIZE + originY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, fruit_texture, true);
                }

                if (sceneCase.getCaseContent(PacgumFruit.class.toString()) != null && sceneCase.getCaseContent(PacgumFruit.class.toString()).size() > 0) {
                    Image pac_gum_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(PacgumFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originX, y * CASE_SIZE + originY, ENTITY_TEXTURE_SIZE, ENTITY_TEXTURE_SIZE, pac_gum_texture, true);
                }
                pane.getChildren().add(imageView);
                y++;
            }
            y = 0;
            x++;
        }
    }

}
