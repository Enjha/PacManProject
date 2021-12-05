package apiUser;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * Setup the different element in a scene
 */
public class SetupScene {

    /**
     * Setup a label in a scene
     * @param label
     *      a label
     * @param text
     *      the text of the label
     * @param position
     *      the alignment of the label
     * @param layoutX
     *      the position x of the label
     * @param layoutY
     *      the position y of the label
     * @param prefHeight
     *      the height of the label
     * @param prefWidth
     *      the width of the label
     * @param font
     *      the font of the text's label
     * @param textColor
     *      the color of the text's label
     * @param visible
     *      the visibility of the label
     */
    public void setLabel(Label label, String text, Pos position, double layoutX, double layoutY, double prefHeight, double prefWidth, Font font, Paint textColor, boolean visible) {
        assert label != null : "Error : label null";
        assert text != null : "Error : text null";
        assert position != null : "Error : position null";
        assert layoutX >= 0 : "Error : layout x < 0";
        assert layoutY >= 0 : "Error : layout y < 0";
        assert prefHeight > 0 : "Error : pref height <= 0";
        assert prefWidth > 0 : "Error : pref width <= 0";
        assert font != null : "Error : font null";
        assert textColor != null : "Error : text color null";

        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        label.setPrefHeight(prefHeight);
        label.setPrefWidth(prefWidth);
        label.setFont(font);
        label.setText(text);
        label.setTextFill(textColor);
        label.setAlignment(position);
        label.setVisible(visible);
    }

    /**
     * Setup a button in a scene
     * @param button
     *      a button
     * @param text
     *      the text of the button
     * @param position
     *      the alignment of the button
     * @param layoutX
     *      the position x of the button
     * @param layoutY
     *      the position y of the button
     * @param prefHeight
     *      the height of the button
     * @param prefWidth
     *      the width of the button
     * @param font
     *      the font of the text's button
     * @param visible
     *      the visibility of the button
     */
    public void setButton(Button button, String text, Pos position, double layoutX, double layoutY, double prefHeight, double prefWidth, Font font, boolean visible) {
        assert button != null : "Error : button null";
        assert text != null : "Error : text null";
        assert position != null : "Error : position null";
        assert layoutX >= 0 : "Error : layout x < 0";
        assert layoutY >= 0 : "Error : layout y < 0";
        assert prefHeight > 0 : "Error : pref height <= 0";
        assert prefWidth > 0 : "Error : pref width <= 0";
        assert font != null : "Error : font null";

        button.setText(text);
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setAlignment(position);
        button.setFont(font);
        button.setPrefHeight(prefHeight);
        button.setPrefWidth(prefWidth);
        button.setVisible(visible);
    }

    /**
     * Setup a image view in a scene
     * @param imageView
     *      the image view
     * @param layoutX
     *      the position x of the image view
     * @param layoutY
     *      the position y of the image view
     * @param fitHeight
     *      the height of the image view
     * @param fitWidth
     *      the widht of the image view
     * @param image
     *      the image of the image view
     * @param visible
     *      the visibility of the image view
     */
    public void setImageView(ImageView imageView, double layoutX, double layoutY, double fitHeight, double fitWidth, Image image, boolean visible) {
        assert imageView != null : "Error : image view null";
        assert layoutX >= 0 : "Error : layout x < 0";
        assert layoutY >= 0 : "Error : layout y < 0";
        assert fitHeight > 0 : "Error : fit height <= 0";
        assert fitWidth > 0 : "Error : fit width <= 0";
        assert image != null : "Error : image null";

        imageView.setImage(image);
        imageView.setLayoutX(layoutX);
        imageView.setLayoutY(layoutY);
        imageView.setFitHeight(fitHeight);
        imageView.setFitWidth(fitWidth);
        imageView.setVisible(visible);
    }

    /**
     * Setup a slider in a scene
     * @param slider
     *      a slider
     * @param layoutX
     *      the position x of the slider
     * @param layoutY
     *      the position y of the slider
     * @param prefHeight
     *      the pref height of the slider
     * @param prefWidth
     *      the pref width of the slider
     * @param min
     *      the value minimal of the slider
     * @param max
     *      the value maximal of the slider
     * @param valueInit
     *      the value intial of the slider
     * @param visible
     *      the visibility of the slider
     */
    public void setSlider(Slider slider, double layoutX, double layoutY, double prefHeight, double prefWidth, double min, double max, double valueInit, boolean visible) {
        assert slider != null : "Error : slider null";
        assert layoutX >= 0 : "Error : layout x < 0";
        assert layoutY >= 0 : "Error : layout y < 0";
        assert prefHeight > 0 : "Error : pref height <= 0";
        assert prefWidth > 0 : "Error : pref width <= 0";
        assert min < max : "Error : min >= max";
        assert valueInit <= max : "Error : value init > max";
        assert valueInit >= min : "Error : value init < min";

        slider.setLayoutX(layoutX);
        slider.setLayoutY(layoutY);
        slider.setPrefWidth(prefWidth);
        slider.setPrefHeight(prefHeight);
        slider.setMax(max);
        slider.setMin(min);
        slider.setValue(valueInit);
        slider.setVisible(visible);
    }
}
