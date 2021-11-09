package Gameplay;

public interface Entity {

    boolean isCharacter();
    boolean isItem();
    boolean canInteractWithItem();
    boolean isEnemy();
    SceneCase getPosition();
}
