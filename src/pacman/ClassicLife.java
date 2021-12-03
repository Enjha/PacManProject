package pacman;

import apiUser.SetupScene;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.File;
import java.util.ArrayList;

public class ClassicLife implements Life {
    private final Label labelVie = new Label();
    private int numberOfLife = 3;
    private Pane pane;
    private ArrayList<ImageView> imageViews;

    public ClassicLife() {
        new SetupScene().setLabel(labelVie, "Vie(s) restante(s) : ", Pos.CENTER_LEFT, 500, -20, 80, 300, new Font(15), Paint.valueOf("black"), true);
        labelVie.setId("labelVie");
        imageViews = new ArrayList<>();
        printLife();
    }


    public ArrayList<ImageView> getImageViews() {
        return imageViews;
    }

    public int getNumberOfLife() {
        return numberOfLife;
    }

    public void setNumberOfLife(int value) {
        numberOfLife = value;
        Platform.runLater(
                () -> {
                    for (int i = 0; i < numberOfLife; i++) {
                        imageViews.get(i).setVisible(true);
                    }
                    for (int j = numberOfLife; j < imageViews.size(); j++) {
                        imageViews.get(j).setVisible(false);
                    }
                });
    }

    public Pane getSceneLife() {
        return pane;
    }

    private void printLife() {
        for (int i = 0; i < numberOfLife; i++) {
            ImageView coeur = new ImageView();
            new SetupScene().setImageView(coeur, 630 + (25 * i), 7, 30, 30, new Image(new File("ressources/textures/coeur.png").toURI().toString()), true);
            imageViews.add(coeur);
        }
    }

    public void setSceneLife(Pane pane) {
        this.pane = pane;
        pane.getChildren().add(labelVie);
        pane.getChildren().addAll(imageViews);
    }
}
