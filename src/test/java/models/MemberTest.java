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
    public void setId() {
    }

    @Test
    public void setName() {
    }
}