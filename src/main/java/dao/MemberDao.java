package dao;

import models.Member;

import java.util.List;

public interface MemberDao {
    // LIST
    List<Member> getAll();

    // CREATE
    void add(Member member);

    // READ
    Member findById(int id);

    // UPDATE
    void update(int id, String name);

    // DELETE
    void deleteById(int id);
    void deleteAllByTeamId(int teamId);
}
