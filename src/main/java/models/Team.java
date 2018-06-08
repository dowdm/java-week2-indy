package models;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private String teamDescription;
    private int id;


    public Team(String teamName, String teamDescription) {
        this.teamName = teamName;
        this.teamDescription = teamDescription;

    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getTeamName() {
        return teamName;
    }


    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }
    public String getTeamDescription() {
        return teamDescription;
    }


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }











}
