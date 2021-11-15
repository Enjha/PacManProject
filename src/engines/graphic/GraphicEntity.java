package engines.graphic;

import com.sun.prism.Texture;

import java.awt.*;

public class GraphicEntity {

    //Position
    private int x;
    private int y;

    //Taille
    private int width;
    private int height;

    //Couleur
    private Colors color;

    //Texture
    private Texture texture;

    //Scene
    private Scene scene;


    public GraphicEntity(int x, int y, int width, int height, Colors color, Texture texture, Scene scene) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.texture = texture;
        this.scene = scene;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
