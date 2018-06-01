package models;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<String> teamMembers = new ArrayList<String>();
    private String teamDescription;
    private int id;



    private static ArrayList<Team> teamInstances = new ArrayList<>();

    public Team(String teamName, String teamDescription) {
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        teamInstances.add(this);
        this.id = teamInstances.size();
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<String> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Team> getTeamInstances() {
        return teamInstances;
    }

    public static void setTeamInstances(ArrayList<Team> teamInstances) {
        Team.teamInstances = teamInstances;
    }


}
