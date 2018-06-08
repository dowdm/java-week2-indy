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

    @Test
    public void setTeamName_setsName_thedogs() throws Exception {
        Team newTeam =setupNewTeam();
        newTeam.setTeamName("The Dogs");
        assertEquals("The Dogs", newTeam.getTeamName());
    }



    @Test
    public void setTeamDescription_setsTeamDescription_werock() throws Exception {
        Team newTeam =setupNewTeam();
        newTeam.setTeamDescription("We are the best.");
        assertEquals("We are the best.", newTeam.getTeamDescription());
    }

    @Test
    public void getId_returnsId_1() throws Exception {
        Team newTeam =setupNewTeam();
        newTeam.setId(1);
        assertEquals(1, newTeam.getId());
    }

}