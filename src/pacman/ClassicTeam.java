package pacman;

import gameplay.Team;

public class ClassicTeam implements Team {

    private String teamName;
    private boolean collision;

    public ClassicTeam(String teamName, boolean collision){
        this.teamName = teamName;
        this.collision = collision;
    }

    public String getTeamName(){
        return teamName;
    }

    public  boolean getCollision(){
        return collision;
    }
}
