package gameplay;

import scene.SceneCase;

public interface Entity {

    boolean isCharacter();
    boolean isItem();
    boolean canInteractWithItem();
    SceneCase getPosition();
}
