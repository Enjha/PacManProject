package engines.graphic;

import apiUser.SetupScene;
import engines.graphic.view.GhostView;
import engines.graphic.view.ItemView;
import engines.graphic.view.PacManView;
import gameplay.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import pacman.*;
import scene.SceneGame;
import scene.SceneCase;



import java.util.ArrayList;
import java.util.List;

public class ClassicConvertSceneToGraphic implements ConvertSceneToGraphic {

    private final double TEXTURE_SIZE = 64;
    private final double CASE_SIZE = 64.0;
    private final double TEXTURE_ENTITY_SIZE = 42;
    private final SetupScene setupScene = new SetupScene();
    private int x = 0;
    private int y = 0;
    private int originX = 100;
    private int originY = 100;
    private int originXEntity = 114;
    private int originYEntity = 114;

    // Cette méthode va mettre en place les textures du labyrinth sur la scene.
    @Override
    public void setLabyrinthTextureScene(SceneGame sceneGame, Pane pane) {
        x = 0;
        y = 0;
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

    // Cette méthode va mettre en place les textures des entitées sur la scene.
    @Override
    public void setEntityTextureScene(SceneGame sceneGame,Pane pane) {
        x = 0;
        y = 0;
        SceneCase[][] sceneCases = sceneGame.getCases();
        ImageView imageView = new ImageView();
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                if (sceneCase.getCaseContent(Pacman.class.toString()) != null && sceneCase.getCaseContent(Pacman.class.toString()).size() > 0) {
                    ArrayList<Image> pacman_textures = new PacManView().getPacmanView((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0));
                    // CREE UNE ANIMATION
                    imageView = new ImageView();
                    setupScene.setImageView(imageView,x * CASE_SIZE + originXEntity,y * CASE_SIZE + originYEntity,TEXTURE_ENTITY_SIZE,TEXTURE_ENTITY_SIZE,pacman_textures.get(0),true);
                    pane.getChildren().add(imageView);
                }

                if (sceneCase.getCaseContent(Ghost.class.toString()) != null && sceneCase.getCaseContent(Ghost.class.toString()).size() > 0) {
                    for (Object o : sceneCase.getCaseContent(Ghost.class.toString())) {
                        Ghost ghost = (Ghost) o;
                        ArrayList<Image> ghost_textures = new GhostView().getGhostView(ghost);
                        // CREE UNE ANIMATION
                        imageView = new ImageView();
                        setupScene.setImageView(imageView,x * CASE_SIZE + originXEntity,y * CASE_SIZE + originYEntity,TEXTURE_ENTITY_SIZE,TEXTURE_ENTITY_SIZE,ghost_textures.get(0),true);
                        pane.getChildren().add(imageView);
                    }
                }
                imageView = new ImageView();

                if (sceneCase.getCaseContent(NormalFruit.class.toString()) != null && sceneCase.getCaseContent(NormalFruit.class.toString()).size() > 0) {
                    Image fruit_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(NormalFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originX, y * CASE_SIZE + originY, TEXTURE_SIZE, TEXTURE_SIZE, fruit_texture, true);
                }

                if (sceneCase.getCaseContent(PacgumFruit.class.toString()) != null && sceneCase.getCaseContent(PacgumFruit.class.toString()).size() > 0) {
                    Image pac_gum_texture = new ItemView().getItemView((Item) sceneCase.getCaseContent(PacgumFruit.class.toString()).get(0));
                    setupScene.setImageView(imageView, x * CASE_SIZE + originX, y * CASE_SIZE + originY, TEXTURE_SIZE, TEXTURE_SIZE, pac_gum_texture, true);
                }

                pane.getChildren().add(imageView);
                y++;
            }
            y = 0;
            x++;
        }
    }

}
