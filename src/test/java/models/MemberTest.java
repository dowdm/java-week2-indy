package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void NewMemberInstantiatesCorrectly_true() throws Exception {
        Member newMember = new Member("Billy Bob",1);
        assertEquals(true, newMember instanceof Member);
    }

    @Test
    public void setId_setsMemberId_1() {
        Member newMember = new Member("Billy Bob", 1);
        newMember.setId(1);
        assertEquals(1, newMember.getId());
    }

    @Test
    public void setName_nameIsSetCorrectly_bobbarker() {
        Member newMember = new Member("Billy Bob", 1);
        newMember.setName("Bob Barker");
        assertEquals("Bob Barker", newMember.getName());
    }

    @Test
    public void setTeamId_setsTeamId_1() {
        Member newMember = new Member("Billy Bob", 1);
        newMember.setTeamId(1);
        assertEquals(1, newMember.getTeamId());
    }
}