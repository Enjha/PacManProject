package ghost;

import gameplay.Team;

public class ClassicTeam implements Team {

    private final String teamName;
    private final boolean collision;

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
