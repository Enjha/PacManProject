package engines.graphic;

import com.sun.prism.Texture;

public class GraphicEntity {

    //Position
    private int x;
    private int y;

    //Taille
    private int width;
    private int height;

    //Couleur
    private Color color;

    //Texture
    private Texture texture;


    public GraphicEntity(int x, int y, int width, int height, Color color, Texture texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.texture = texture;
    }

    public int[] getBounds() { return new int[]{x, y, x + width, y + height}; }

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

}
