package engines.graphic;

import apiUser.SetupScene;
import pacman.WallViewPacman;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scene.Scene;
import scene.SceneCase;

public class ClassicConvertSceneToGraphic implements ConvertSceneToGraphic {

    public void setTextureScene(Scene scene) {
        double TEXTURE_SIZE = 32.0;
        double CASE_SIZE = 10.0;
        SceneCase[][] sceneCases = scene.getCases();
        SetupScene setUp = new SetupScene();
        int x = 0;
        int y = 0;
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                //On parcours les cases en récuperant pour chaque case ses composants et les afficher
                Image texture_wall = new WallViewPacman().getWallView(sceneCase);
                setUp.setImageView(new ImageView(), x * CASE_SIZE, y * CASE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, texture_wall, true);
                y++;
            }
            x++;
        }
    }
}
