package Gameplay;

public interface TeamManager {

    boolean addTeam(Team team);
    boolean removeTeam(Team team);
    Team getTeam(String teamName);
}
