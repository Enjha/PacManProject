package engines.graphic;

public class Texture extends Cover{

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

    @Override
    protected void cover(GraphicEntity graphicEntity) {
       // FxRender.getInstance().renderTexturedRect(graphicEntity.getHeight(), graphicEntity.getWidth(),
             //   graphicEntity.getX(), graphicEntity.getY(), link);
    }

    @Override
    protected void update() {}

    @Override
    public Cover clone() {
        return this;
    }

    public String getLink() {
        return link;
    }
}
