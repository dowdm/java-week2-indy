package dao;

import models.Member;
import models.Team;

import java.util.List;

public interface TeamDao {
    // LIST
    List<Team> getAll();

    // CREATE
    void add(Team team);

    // READ
    Team findById(int id);

    // UPDATE
    void update(int id, String teamName, String teamDescription);

    // DELETE
    void deleteById(int id);

    //Other
    List<Member> getAllMembersByTeamId(int teamId);
}
