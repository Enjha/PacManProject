package engines.graphic;

import apiUser.SetupScene;
import engines.graphic.view.WallView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scene.Scene;
import scene.SceneCase;

import java.io.File;

public class ClassicConvertSceneToGraphic implements ConvertSceneToGraphic {

    public void test(Scene scene) {
        double TEXTURE_SIZE = 32.0;
        double CASE_SIZE = 10.0;
        SceneCase[][] sceneCases = scene.getCases();
        SetupScene setUp = new SetupScene();
        int x = 0;
        int y = 0;
        for (SceneCase[] sceneCases1 : sceneCases) {
            for (SceneCase sceneCase : sceneCases1) {
                //On parcours les cases en récuperant pour chaque case ses composants et les afficher
                Image texture_wall = new WallView().getWallView(sceneCase);
                setUp.setImageView(new ImageView(), x * CASE_SIZE, y * CASE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, texture_wall, true);
                y++;
            }
            x++;
        }
    }
}
