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
    }

    @Test
    public void NewTeamInstantiatesCorrectly_true() throws Exception {
        Team newTeam =setupNewTeam();
        assertEquals(true, newTeam instanceof Team);
    }
}