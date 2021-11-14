package engines.graphic;

public class Colors {

    private int red;
    private int green;
    private int blue;

    public Colors(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public javafx.scene.paint.Color getJavafxColor(){
//        return .getJavafxColor(red,green,blue);
        return getJavafxColor();
    }

/*
    A mettre dans l'API lors du rendu du jeu
    getJavafxColor(int red, int green, int blue){
        return new Colors(red, green, blue);
    }
*/
}

