package apiUser;

import engines.graphic.Color;
import javafx.scene.layout.GridPane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FxRender extends GridPane {

    private static FxRender instance;

    private FxRender() {
    }

    public static FxRender getInstance() {
        if (instance == null) instance = new FxRender();
        return instance;
    }

    /**
     * Textures chargées
     */
    private final Map<String, BufferedImage> loadedTextures = new HashMap<>();

    public void renderRect(int height, int width, int x, int y, java.awt.Color color) {
       /* Graphics2D graphics2D = getCurrentGraphics();
        if (graphics2D != null) {
            graphics2D.setColor(color);
          //  x += getCurrentScene().getX();
           // y += getCurrentScene().getY();
            graphics2D.fillRect(x, y, width, height);
        }*/
    }

    /*public void renderTexturedRect(int height, int width, int x, int y, String link) {
        Graphics2D graphics2D = this.;
        if (graphics2D != null) {
            x += getCurrentScene().getX();
            y += getCurrentScene().getY();
            graphics2D.drawImage(loadedTextures.get(link), x, y, width, height, null);
        }
    }*/

    /*public void renderText(String text, java.awt.Color color, int fontSize, boolean center, int x, int y, int height, int width) {
        Graphics2D graphics2D = getCurrentGraphics();
        if (graphics2D != null) {
            graphics2D.setFont(new Font("Arial", Font.PLAIN, fontSize));
            if (center) {
                FontMetrics metrics = graphics2D.getFontMetrics();
                x = x + (width - metrics.stringWidth(text)) / 2;
                y = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
            }
            x += getCurrentScene().getX();
            y += getCurrentScene().getY();
            graphics2D.setColor(color);
            graphics2D.drawString(text, x, y);
        }
    }*/

    public void loadTexture(String link) {
        BufferedImage texture = getBufferedImage(link);
        loadedTextures.put(link, texture);
        texture.flush();
    }

    public void loadSpriteSheet(String link, int sheetHeight, int sheetWidth) {
        BufferedImage texture = getBufferedImage(link);
        int partWidth = texture.getWidth() / sheetWidth;
        int partHeight = texture.getHeight() / sheetHeight;
        for (int row = 0; row < sheetHeight; row++) {
            for (int col = 0; col < sheetWidth; col++) {
                int cropX = col * partWidth;
                int cropY = row * partHeight;
                loadedTextures.put(link + row + "-" + col, texture.getSubimage(cropX, cropY, partWidth, partHeight));
            }
        }
        texture.flush();
    }

    private BufferedImage getBufferedImage(String link) {
        BufferedImage texture = null;
        try {
            texture = ImageIO.read(Objects.requireNonNull(FxRender.class.getResourceAsStream("/" + link)));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return texture;
    }

    public boolean isTextureLoaded(String link) {
        return loadedTextures.containsKey(link);
    }

    public Color getFxColor(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    // GETTERS //
   /* public Graphics2D getCurrentGraphics() {
        if (FxWindow.getInstance().getCurrentScene() != null)
            return FxWindow.getInstance().getCurrentScene().get2DGraphics();
        return null;
    }

    public Scene getCurrentScene() {
        return FxWindow.getInstance().getCurrentScene();
    }*/
}
