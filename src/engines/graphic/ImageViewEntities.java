package engines.graphic;

import gameplay.Entity;
import javafx.scene.image.ImageView;


public class ImageViewEntities {

    private Entity entity;
    private ImageView imageView;

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
