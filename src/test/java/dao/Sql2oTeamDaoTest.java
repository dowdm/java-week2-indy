package dao;

import models.Member;
import models.Team;
import org.sql2o.*;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class Sql2oTeamDaoTest {

    private Sql2oMemberDao memberDao;
    private Sql2oTeamDao teamDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";

        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);
        teamDao = new Sql2oTeamDao(sql2o);
        conn = sql2o.open();
    }

    public Team setupNewTeam(){
        return new Team("The Winners", "We're going to win");
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() {
        Team newTeam = setupNewTeam();
        int originalTeamId = newTeam.getId();
        teamDao.add(newTeam);
        assertNotEquals(originalTeamId, newTeam.getId());
    }

    @Test
    public void getAll() {
        Team newTeam = setupNewTeam();
        teamDao.add(newTeam);
        assertEquals(1, teamDao.getAll().size());
    }

    @Test
    public void update() {
        Team newTeam = setupNewTeam();
        teamDao.add(newTeam);
        int id = newTeam.getId();
        teamDao.update(id, "The Superheroes","Comic book informed code brigade." );
        Team updatedTeam = teamDao.findById(id);
        assertEquals("The Superheroes", updatedTeam.getTeamName());
    }

    @Test
    public void findById() {
        Team newTeam = setupNewTeam();
        teamDao.add(newTeam);
        Team foundTeam = teamDao.findById(newTeam.getId());
        assertEquals(newTeam, foundTeam);
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void getAllMembersByTeamId() {
    }
}