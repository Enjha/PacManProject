package engines.graphic;

public class TextureCut {
    /**
     * Lien du fichier
     */
    private final String link;

    /**
     * Liste des sous-textures
     */
    private final Texture[][] textures;

    protected TextureCut(String link, int height, int width) {
        this.link = link;
        this.textures = new Texture[height][width];
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                textures[row][col] = new Texture(this, row, col);
    }

    protected Texture getTexture(int row, int col) {
        return textures[row - 1][col - 1];
    }

    protected String getLink() {
        return link;
    }
}
