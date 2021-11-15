package api;

import engines.graphic.Colors;

import java.awt.*;

public class FxScene {
    public int height;
    public int width;
    public Color backgroundColor;
    int xLocation;
    int yLocation;

    protected FxScene(int height, int width) {
        this.height = height;
        this.width = width;
        this.xLocation = 0;
        this.yLocation = 0;
        this.backgroundColor = Color.black;
    }
    public void setLocation(int x, int y) {
        xLocation = x;
        yLocation = y;
    }

    public void setSize(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setBackgroundColor(int red, int green, int blue) {
        backgroundColor = new Color(red, green, blue);
        FxWindow.getInstance().setBackgroundColor(backgroundColor);
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public int getXLocation() { return xLocation; }

    public int getYLocation() { return yLocation; }
}
