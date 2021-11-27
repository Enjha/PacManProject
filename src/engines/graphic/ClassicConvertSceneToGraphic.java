package engines.graphic;

import apiUser.FxAnimation;
import apiUser.SetupScene;
import engines.graphic.view.GhostView;
import engines.graphic.view.PacManView;
import javafx.animation.Timeline;
import pacman.Ghost;
import pacman.Pacman;
import pacman.WallViewPacman;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scene.Scene;
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
    public void setLabyrinthTextureScene(Scene scene) {
        SceneCase[][] sceneCases = scene.getCases();
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                Image wall_texture = new WallViewPacman().getWallView(sceneCase);
                setupScene.setImageView(new ImageView(), x * CASE_SIZE, y * CASE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, wall_texture, true);
                y++;
            }
            x++;
        }
    }

    // Cette méthode va mettre en place les textures des entitées sur la scene.
    @Override
    public void setEntityTextureScene(Scene scene) {
        SceneCase[][] sceneCases = scene.getCases();
        Timeline timeline = new Timeline();
        FxAnimation animation = new FxAnimation();
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                if (sceneCase.getCaseContent(Pacman.class.toString()).size() > 0) {
                    ArrayList<Image> pacman_textures = new PacManView().getPacmanView((Pacman) sceneCase.getCaseContent(Pacman.class.toString()).get(0));
                    animation.createAnimationWithImages(pacman_textures);
                }
                if (sceneCase.getCaseContent(Ghost.class.toString()).size() > 0) {
                    for (Object o : sceneCase.getCaseContent(Ghost.class.toString())) {
                        Ghost ghost = (Ghost) o;
                        ArrayList<Image> ghost_textures = new GhostView().getGhostView(ghost);
                        animation.createAnimationWithImages(ghost_textures);
                    }
                }

            }
        }
    }

}
