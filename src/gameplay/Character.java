package gameplay;

public interface Character extends Entity {

    Team getTeam();
    void setTeam(Team team);
}
