package engines.graphic;

public class Texture extends Cover{


    /**
     * Lien vers la texture
     */
    private final String link;

    protected Texture(String link) {
        this.link = link;
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
