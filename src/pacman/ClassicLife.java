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

/**
 * A classic life's information of a entity
 */
public class ClassicLife implements Life {

    /**
     * The life's label
     */
    private final Label labelVie;

    /**
     * The number max of life point
     */
    private int numberMaxOfLife;

    /**
     * The current number of life point
     */
    private int numberOfLife;

    /**
     * The pane to show the life point
     */
    private Pane pane;

    /**
     * The life point image
     */
    private ArrayList<ImageView> imageViews;

    /**
     * <b>Constructor of ClassicLife</b>
     * @param numberMaxOfLife
     *      the number max of life point
     */
    public ClassicLife(int numberMaxOfLife) {
        assert numberMaxOfLife > 0 : "error : the number max of life point must be > 0";
        this.numberMaxOfLife = numberMaxOfLife;
        numberOfLife = numberMaxOfLife;
        labelVie = new Label();
        new SetupScene().setLabel(labelVie, "Vie(s) restante(s) : ", Pos.CENTER_LEFT, 500, 0, 40, 300, new Font(15), Paint.valueOf("black"), true);
        labelVie.setId("labelVie");
        initLifePoint();
    }

    /**
     * Return all image for the life point
     * @return a array list of object type of ImageView
     */
    public ArrayList<ImageView> getImageViews() {
        return imageViews;
    }

    /**
     * Return the current number of life point
     * @return a integer value
     */
    public int getNumberOfLife() {
        return numberOfLife;
    }

    /**
     * Add life point to the current life point without exceed the number max of life point and update the display
     * @param value
     *      the life point to add
     */
    public void addLifePoint(int value) {
        assert value > 0 : "Error : the number of life point to add must be > 0";
        if(numberOfLife + value > numberMaxOfLife){
            numberOfLife = numberMaxOfLife;
        }
        else {
            numberOfLife += value;
        }
       updateLifePoint();
    }

    /**
     * Remove life point to the current life point without exceed 0 and update the display
     * @param value
     *      the life point to remove
     */
    public void removeLifePoint(int value){
        assert value > 0 : "Error : the number of life point te remove must be > 0";
        if(numberOfLife - value < 0){
            numberOfLife = 0;
        }
        else {
            numberOfLife -= value;
        }
        updateLifePoint();
    }

    /**
     * Upgrade the display who show the current life point
     */
    private void updateLifePoint(){
        Platform.runLater(
                () -> {
                    System.out.println("life update : " + numberOfLife);
                    for (int i = 0; i < numberOfLife; i++) {
                        imageViews.get(i).setVisible(true);
                    }
                    for (int j = numberOfLife; j < imageViews.size(); j++) {
                        imageViews.get(j).setVisible(false);
                    }
                });
    }

    /**
     * Return the pane
     * @return a object type of Pane
     */
    public Pane getSceneLife() {
        return pane;
    }

    /**
     * Init the display for the life point
     */
    private void initLifePoint() {
        imageViews = new ArrayList<>();
        for (int i = 0; i < numberMaxOfLife; i++) {
            ImageView coeur = new ImageView();
            Image lifeImage = new Image(new File("ressources/textures/coeur.png").toURI().toString());
            assert !lifeImage.isError() : "Error : a image has not load";
            new SetupScene().setImageView(coeur, 630 + (25 * i), 7, 30, 30, lifeImage, true);
            imageViews.add(coeur);
        }
    }

    /**
     * Modify the pane, add the label and the life's image to this new pane
     * @param pane
     *      a new pane
     */
    public void setSceneLife(Pane pane) {
        assert pane != null : "Error : the new pane must be not null";
        this.pane = pane;
        pane.getChildren().add(labelVie);
        pane.getChildren().addAll(imageViews);
    }

    /**
     * Modify the number max of life point with a new value > 0
     * @param numberMaxOfLife
     *      a new number of life point
     */
    public void setNumberMaxOfLife(int numberMaxOfLife){
        assert numberMaxOfLife > 0 : "error : the number max of life point must be > 0";
        this.numberMaxOfLife = numberMaxOfLife;
    }

    /**
     * Return the number max of life point
     * @return a integer value
     */
    public int getNumberMaxOfLife(){
        return numberMaxOfLife;
    }
}
