package engines.graphic;

import gameplay.Entity;
import javafx.scene.image.ImageView;


public class ImageViewEntities {

    private final Entity entity;
    private final ImageView imageView;

    public ImageViewEntities(Entity entity,ImageView imageView){
        this.entity = entity;
        this.imageView = imageView;
    }

    public Entity getEntity(){
        return entity;
    }

    public ImageView getImageView(){
        return imageView;
    }
}
