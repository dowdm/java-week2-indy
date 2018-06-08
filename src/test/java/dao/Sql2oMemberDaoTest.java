package dao;

import models.Member;
import org.junit.runner.notification.RunListener;
import org.sql2o.*;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oMemberDaoTest {

    private Sql2oMemberDao memberDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);
        conn = sql2o.open();
    }

    public Member setupNewMember(){
        return new Member("Mike Smith", 1);
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() {
        Member newMember = setupNewMember();
        int originalMemberId = newMember.getId();
        memberDao.add(newMember);
        assertNotEquals(originalMemberId, newMember.getId());
    }


    @Test
    public void findById(){
        Member newMember = setupNewMember();
        memberDao.add(newMember);
        Member foundMember = memberDao.findById(newMember.getId());
        assertEquals(newMember, foundMember);
    }

    @Test
    public void getAll(){
        Member newMember = setupNewMember();
        memberDao.add(newMember);
        assertEquals(1, memberDao.getAll().size());
    }

    @Test
    public void update(){
        Member newMember = setupNewMember();
        memberDao.add(newMember);
        int id = newMember.getId();
        memberDao.update(id, "Kenny Loggins");
        Member updatedMember = memberDao.findById(id);
        assertEquals("Kenny Loggins", updatedMember.getName());
    }

    @Test
    public void deleteById(){
        Member newMember = setupNewMember();
        Member newMemberTwo = setupNewMember();
        memberDao.add(newMember);
        memberDao.add(newMemberTwo);
        memberDao.deleteById(2);
        List<Member> allMembers = memberDao.getAll();
        assertEquals(1, allMembers.size());
        assertTrue(allMembers.contains(newMember));
        assertFalse(allMembers.contains(newMemberTwo));
    }
}