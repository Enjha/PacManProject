package ghost.texture.wall;

import ghost.view.Texture;
import javafx.scene.image.Image;

import java.io.File;

public class TextureWallVerticalCorridor implements Texture {

    public Image getTexture(){
        return new Image(new File("ressources/textures/wall/corridor/W_vertical_corridor.gif").toURI().toString());
    }
}
