package pacman.texture.wall;

import pacman.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallHorizontalCorridor implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/corridor/W_horizontal_corridor.gif").toURI().toString());
    }
}
