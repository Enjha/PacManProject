package pacman.animations;

import engines.graphic.ImageViewEntities;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import pacman.Ghost;

/**
 * The ghost animation
 */
public class GhostAnimation implements EntityAnimation {

    /**
     * The animation of a movement
     * @param imageViewEntities
     *      a entity
     */
    public void movementAnimation(ImageViewEntities imageViewEntities) {
        assert imageViewEntities != null : "Error : image view entities null";
        Ghost ghost = (Ghost) imageViewEntities.getEntity();
        ImageView image_ghost = imageViewEntities.getImageView();
        assert image_ghost != null : "Error : image ghost null";

        //The ghost is alive
        if (ghost.isAlive()) {
            switch (ghost.getDirection()) {
                case North:
                    //The ghost is alive
                    if (ghost.isAlive()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setImage(ghost.getTextures().get(0)))
                        ).play();
                        //The ghost is afraid
                    } else if (ghost.isAfraid()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(2))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setImage(ghost.getTextures().get(3))),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setLayoutY(image_ghost.getY() - 4))
                        ).play();
                    } else {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setLayoutY(image_ghost.getY() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setLayoutY(image_ghost.getY() - 4))
                        ).play();
                    }
                    break;
                case East:
                    //The ghost is alive
                    if (ghost.isAlive()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setImage(ghost.getTextures().get(0)))
                        ).play();
                        //The ghost is afraid
                    } else if (ghost.isAfraid()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(2))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setImage(ghost.getTextures().get(3))),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setX(image_ghost.getX() + 4))
                        ).play();
                    } else {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setX(image_ghost.getX() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setX(image_ghost.getX() + 4))
                        ).play();
                    }
                    break;
                case South:
                    //The ghost is alive
                    if (ghost.isAlive()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setLayoutY(image_ghost.getLayoutY() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setImage(ghost.getTextures().get(0)))
                        ).play();
                        //The ghost is afraid
                    } else if (ghost.isAfraid()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(2))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setImage(ghost.getTextures().get(3))),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setY(image_ghost.getY() + 4))
                        ).play();
                    } else {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setY(image_ghost.getY() + 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setY(image_ghost.getY() + 4))
                        ).play();
                    }
                    break;
                case West:
                    //The ghost is alive
                    if (ghost.isAlive()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setLayoutX(image_ghost.getLayoutX() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setImage(ghost.getTextures().get(0)))
                        ).play();
                        //The ghost is afraid
                    } else if (ghost.isAfraid()) {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setImage(ghost.getTextures().get(1))),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setImage(ghost.getTextures().get(2))),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setImage(ghost.getTextures().get(3))),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setX(image_ghost.getX() - 4))
                        ).play();
                    } else {
                        new Timeline(
                                new KeyFrame(Duration.seconds(0), event -> image_ghost.setImage(ghost.getTextures().get(0))),
                                new KeyFrame(Duration.seconds(0.0225), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.45), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.675), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.09), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.1125), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.135), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.1575), event -> image_ghost.setX(image_ghost.getX() - 4)),
                                new KeyFrame(Duration.seconds(0.18), event -> image_ghost.setX(image_ghost.getX() - 4))
                        ).play();
                    }
                    break;
            }
        }
    }

    @Override
    public void deadAnimation(ImageViewEntities entity) {
    }
}
