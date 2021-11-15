package engines.graphic;

import apiUser.FxAPIUser;

public abstract class Cover extends FxAPIUser {

    protected abstract void cover(GraphicEntity graphicEntity);

    protected abstract void update();

    public abstract Cover clone();
}
