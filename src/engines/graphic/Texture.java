package engines.graphic;

public class Texture {
    /**
     * Nom du fichier de textures
     */
    private final TextureCut textureCut;
    /**
     * Lien vers la partie de la texture
     */
    private final String link;

    protected Texture(TextureCut textureCut, int row, int col) {
        this.textureCut = textureCut;
        this.link = textureCut.getLink() + row + "-" + col;
    }

    protected void cover(GraphicEntity graphicEntity) {
    }

    protected void update() {}

    public Texture clone() {
        return this;
    }

    public TextureCut getSpriteSheet() {
        return textureCut;
    }

    public String getLink() {
        return link;
    }
}
