package Gameplay;

import Scene.SceneCase;

public interface Entity {

    boolean isCharacter();
    boolean isItem();
    boolean canInteractWithItem();
    SceneCase getPosition();
}
