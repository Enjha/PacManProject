package engines.graphic.view;

import gameplay.Item;
import javafx.scene.image.Image;
import pacman.NormalFruit;
import pacman.PacgumFruit;
import pacman.texture.items.TextureFruit;
import pacman.texture.items.TexturePacGum;

public class ItemView {

    public ItemView() {

    }

    public Image getItemView(Item item) {
        if (item instanceof NormalFruit) {
            return new TextureFruit().getTexture();
        } else if (item instanceof PacgumFruit) {
            return new TexturePacGum().getTexture();
        }
        return null;
    }
}
