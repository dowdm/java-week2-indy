package dao;

import models.Member;
import models.Team;
import org.sql2o.*;
import java.util.List;

public class Sql2oTeamDao implements TeamDao {
    private final Sql2o sql2o;
    public Sql2oTeamDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Team team) {
        String sql = "INSERT INTO teams (teamName, teamDescription) VALUES (:teamName, :teamDescription)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(team)
                    .executeUpdate()
                    .getKey();
            team.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Team> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM teams")
                    .executeAndFetch(Team.class);
        }
    }

    @Override
    public void update(int id, String newTeamName, String newTeamDescription){
        String sql = "UPDATE members SET (teamName, teamDescription) = (:teamName, :teamDescription) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("teamName", newTeamName)
                    .addParameter("teamName", newTeamDescription)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Team findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM teams WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Team.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from teams WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Member> getAllMembersByTeamId(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM members WHERE teamId = :teamId")
                    .addParameter("teamId", id)
                    .executeAndFetch(Member.class);
        }
    }


}
