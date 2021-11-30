package pacman.animations;

import apiUser.SetupScene;
import engines.graphic.ImageViewEntities;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import pacman.Pacman;
import pacman.view.PacManView;

import java.io.File;
import java.util.ArrayList;

public class PacManAnimation implements EntityAnimation {

    @Override
    public void movementAnimation(ImageViewEntities entity) {
        Pacman pacman = (Pacman) entity.getEntity();
        ImageView image_pacman = entity.getImageView();

        switch (pacman.getDirection()) {
            case North:
                new Timeline(
                        new KeyFrame(Duration.seconds(0), event -> image_pacman.setImage(pacman.getTextures().get(0))),
                        new KeyFrame(Duration.seconds(0.025), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.05), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.075), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setImage(pacman.getTextures().get(1))),
                        new KeyFrame(Duration.seconds(0.125), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.15), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.175), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setY(image_pacman.getY() - 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setImage(pacman.getTextures().get(0)))
                ).play();
                break;
            case East:
                new Timeline(
                        new KeyFrame(Duration.seconds(0), event -> image_pacman.setImage(pacman.getTextures().get(0))),
                        new KeyFrame(Duration.seconds(0.025), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.05), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.075), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setImage(pacman.getTextures().get(1))),
                        new KeyFrame(Duration.seconds(0.125), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.15), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.175), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setX(image_pacman.getX() + 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setImage(pacman.getTextures().get(0)))
                ).play();
                break;
            case South:
                new Timeline(
                        new KeyFrame(Duration.seconds(0), event -> image_pacman.setImage(pacman.getTextures().get(0))),
                        new KeyFrame(Duration.seconds(0.025), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.05), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.075), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setImage(pacman.getTextures().get(1))),
                        new KeyFrame(Duration.seconds(0.125), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.15), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.175), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setY(image_pacman.getY() + 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setImage(pacman.getTextures().get(0)))
                ).play();
                break;
            case West:
                new Timeline(
                        new KeyFrame(Duration.seconds(0), event -> image_pacman.setImage(pacman.getTextures().get(0))),
                        new KeyFrame(Duration.seconds(0.025), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.05), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.075), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setImage(pacman.getTextures().get(1))),
                        new KeyFrame(Duration.seconds(0.125), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.15), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.175), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setX(image_pacman.getX() - 4)),
                        new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setImage(pacman.getTextures().get(0)))
                ).play();
                break;
        }
    }

    @Override
    public void deadAnimation(ImageViewEntities entity) {
        Pacman pacman = (Pacman) entity.getEntity();
        ImageView image_pacman = entity.getImageView();
        new Timeline(
                new KeyFrame(Duration.seconds(0), event -> image_pacman.setImage(pacman.getTextures().get(0))),
                new KeyFrame(Duration.seconds(0.1), event -> image_pacman.setImage(pacman.getTextures().get(1))),
                new KeyFrame(Duration.seconds(0.2), event -> image_pacman.setImage(pacman.getTextures().get(2))),
                new KeyFrame(Duration.seconds(0.3), event -> image_pacman.setImage(pacman.getTextures().get(3))),
                new KeyFrame(Duration.seconds(0.4), event -> image_pacman.setImage(pacman.getTextures().get(4))),
                new KeyFrame(Duration.seconds(0.5), event -> image_pacman.setImage(pacman.getTextures().get(5))),
                new KeyFrame(Duration.seconds(0.6), event -> image_pacman.setImage(pacman.getTextures().get(6))),
                new KeyFrame(Duration.seconds(0.7), event -> image_pacman.setImage(pacman.getTextures().get(7))),
                new KeyFrame(Duration.seconds(0.8), event -> image_pacman.setImage(pacman.getTextures().get(8))),
                new KeyFrame(Duration.seconds(0.9), event -> image_pacman.setImage(pacman.getTextures().get(9))),
                new KeyFrame(Duration.seconds(1.1), event -> image_pacman.setImage(pacman.getTextures().get(10))),
                new KeyFrame(Duration.seconds(1.3), event -> image_pacman.setVisible(false))
        ).play();
    }
}
