package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void NewMemberInstantiatesCorrectly_true() throws Exception {
        Member newMember = new Member("Billy Bob");
        assertEquals(true, newMember instanceof Member);
    }

    @Test
    public void setId_setsMemberId_1() {
        Member newMember = new Member("Billy Bob");
        newMember.setId(1);
        assertEquals(1, newMember.getId());
    }

    @Test
    public void setName() {
    }
}