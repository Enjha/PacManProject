package engines.graphic;

import apiUser.SetupScene;
import engines.graphic.view.GhostView;
import engines.graphic.view.ItemView;
import engines.graphic.view.PacManView;
import gameplay.Item;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pacman.*;
import scene.SceneGame;
import scene.SceneCase;



import java.util.ArrayList;

public class ClassicConvertSceneToGraphic implements ConvertSceneToGraphic {

    private final double TEXTURE_SIZE = 32.0;
    private final double CASE_SIZE = 10.0;
    private final SetupScene setupScene = new SetupScene();
    private int x = 0;
    private int y = 0;

    // Cette méthode va mettre en place les textures du labyrinth sur la scene.
    @Override
    public void setLabyrinthTextureScene(SceneGame sceneGame, AnchorPane anchorPane) {
        SceneCase[][] sceneCases = sceneGame.getCases();
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                Image wall_texture = new WallViewPacman().getWallView(sceneCase);
                ImageView imageView = new ImageView();
                setupScene.setImageView(imageView, x * CASE_SIZE, y * CASE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, wall_texture, true);
                anchorPane.getChildren().add(imageView);
                y++;
            }
            x++;
        }
    }

    // Cette méthode va mettre en place les textures des entitées sur la scene.
    @Override
    public void setEntityTextureScene(SceneGame sceneGame,AnchorPane anchorPane) {
        SceneCase[][] sceneCases = sceneGame.getCases();
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                if (sceneCase.getCaseContent(Pacman.class.toString()).size() > 0) {
                    ArrayList<Image> pacman_textures = new PacManView().getPacmanView((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0));
                    // CREE UNE ANIMATION
                }

                if (sceneCase.getCaseContent(Ghost.class.toString()).size() > 0) {
                    for (Object o : sceneCase.getCaseContent(Ghost.class.toString())) {
                        Ghost ghost = (Ghost) o;
                        ArrayList<Image> ghost_textures = new GhostView().getGhostView(ghost);
                        // CREE UNE ANIMATION
                    }
                }
                ImageView imageView = new ImageView();

                if (sceneCase.getCaseContent(NormalFruit.class.toString()).size() > 0) {
                    Image fruit_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(NormalFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE, y * CASE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, fruit_texture, true);
                }

                if (sceneCase.getCaseContent(PacgumFruit.class.toString()).size() > 0) {
                    Image pac_gum_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(PacgumFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE, y * CASE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, pac_gum_texture, true);
                }

                anchorPane.getChildren().add(imageView);
                y++;
            }
            x++;
        }
    }

}
