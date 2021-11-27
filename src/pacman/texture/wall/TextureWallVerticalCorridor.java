package pacman.texture.wall;

import engines.graphic.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallVerticalCorridor implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/wall/corridor/W_vertical_corridor.gif").toURI().toString());
    }
}
