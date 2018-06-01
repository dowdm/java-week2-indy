package models;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<String> teamMembers = new ArrayList<String>();
    private String teamDescription;
    private static ArrayList<Team> teamInstances = new ArrayList<>();

    public Team(String teamName, String teamDescription) {
        this.teamMembers = teamMembers;
        this.teamName = teamName;
        this.teamDescription = teamDescription;
    }

}
