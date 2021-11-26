package pacman;

import gameplay.Character;
import gameplay.Direction;
import gameplay.Team;
import scene.SceneCase;

public class Ghost implements Character {

    private SceneCase position;
    private Team team;
    private String entityName;
    private Direction direction = Direction.Stop;
    private boolean isAlive = true;
    private final
    GhostColor color;

    public Ghost(String entityName, GhostColor color) {
        this.entityName = entityName;
        this.color = color;
    }

    public boolean isCharacter() {
        return true;
    }

    public boolean isItem() {
        return false;
    }

    public boolean canInteractWithItem() {
        return false;
    }

    public SceneCase getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }

    public void setPosition(SceneCase position) {
        this.position = position;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getEntityName() {
        return entityName;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public GhostColor getColor() {
        return color;
    }
}