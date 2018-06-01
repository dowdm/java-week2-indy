package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeamTest {

    @Before
    public void setUp() throws Exception {
    }

    public Team setupNewTeam(){
        List<String> teamMembers = new ArrayList<String>();
        teamMembers.add("Mike Smith");
        teamMembers.add("Frankie Hazel");
        return new Team("The Tigers", "Coders with cats, creating pet apps");
    }

    @After
    public void tearDown() throws Exception {
        Team.clearAllTeams();
    }

    @Test
    public void NewTeamInstantiatesCorrectly_true() throws Exception {
        Team newTeam =setupNewTeam();
        assertEquals(true, newTeam instanceof Team);
    }

    @Test
    public void setTeamName_setsName_thedogs() throws Exception {
        Team newTeam =setupNewTeam();
        newTeam.setTeamName("The Dogs");
        assertEquals("The Dogs", newTeam.getTeamName());
    }

    @Test
    public void setTeamMembers_setsTeamMembers_3() throws Exception {
        Team newTeam =setupNewTeam();
        List<String> teamMembers = new ArrayList<String>();
        teamMembers.add("Willy Wonka");
        newTeam.setTeamMembers(teamMembers);
        assertEquals(1, newTeam.getTeamMembers().size());
    }

    @Test
    public void setTeamDescription_setsTeamDescription_werock() throws Exception {
        Team newTeam =setupNewTeam();
        newTeam.setTeamDescription("We are the best.");
        assertEquals("We are the best.", newTeam.getTeamDescription());
    }

    @Test
    public void getTeamId_returnsTeamId_1() throws Exception {
        Team newTeam =setupNewTeam();
        assertEquals(1, newTeam.getId());
    }

    @Test
    public void getTeamInstances_returnsTeamInstances_1() throws Exception {
        Team newTeam =setupNewTeam();
        assertEquals(1, Team.getTeamInstances().size());
    }
}