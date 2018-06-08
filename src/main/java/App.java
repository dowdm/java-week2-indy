import java.util.*;
import models.Member;
import models.Team;
import dao.Sql2oTeamDao;
import dao.Sql2oMemberDao;

import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/hikelist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);
        Sql2oMemberDao  memberDao = new Sql2oMemberDao(sql2o);


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Team> teams = teamDao.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Team> teams = teamDao.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newteam-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String teamName = request.queryParams("name");
            String teamDescription = request.queryParams("description");
            Team newTeam = new Team(teamName, teamDescription);
            teamDao.add(newTeam);
            int teamId = newTeam.getId();
            Member memberOne = new Member(request.queryParams("memberOne"), teamId);
            if(!memberOne.getName().equals("")){
                memberDao.add(memberOne);
            }
            Member memberTwo = new Member(request.queryParams("memberTwo"), teamId);
            if(!memberTwo.getName().equals("")){
                memberDao.add(memberTwo);
            }
            Member memberThree = new Member(request.queryParams("memberThree"), teamId);
            if(!memberThree.getName().equals("")){
                memberDao.add(memberThree);
            }
            Member memberFour = new Member(request.queryParams("memberFour"), teamId);
            if(!memberFour.getName().equals("")){
                memberDao.add(memberFour);
            }
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            model.put("team", foundTeam);
            List<Member> teamMembers = teamDao.getAllMembersByTeamId(idOfTeamToFind);
            model.put("members", teamMembers);
            return new ModelAndView(model, "team-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = teamDao.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            List<Member> teamMembers = teamDao.getAllMembersByTeamId(idOfTeamToEdit);
            model.put("members", teamMembers);
            return new ModelAndView(model, "newteam-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("name");
            String teamDescription = request.queryParams("description");
            int idOfTeamToEdit = Integer.parseInt(request.params("id"));
            teamDao.update(idOfTeamToEdit, teamName, teamDescription);
            Member memberOne = new Member(request.queryParams("memberOne"), idOfTeamToEdit);
            if(!memberOne.getName().equals("")){
                memberDao.add(memberOne);
            }
            Member memberTwo = new Member(request.queryParams("memberTwo"), idOfTeamToEdit);
            if(!memberTwo.getName().equals("")){
                memberDao.add(memberTwo);
            }
            Member memberThree = new Member(request.queryParams("memberThree"), idOfTeamToEdit);
            if(!memberThree.getName().equals("")){
                memberDao.add(memberThree);
            }
            Member memberFour = new Member(request.queryParams("memberFour"), idOfTeamToEdit);
            if(!memberFour.getName().equals("")){
                memberDao.add(memberFour);
            }
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/members/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfMemberToDelete = Integer.parseInt(req.params("id"));
            Member editedMember = memberDao.findById(idOfMemberToDelete);
            int teamId = editedMember.getTeamId();
            memberDao.deleteById(idOfMemberToDelete);
            res.redirect("/teams/" + teamId);
            return null;
        }, new HandlebarsTemplateEngine());

        get("/members/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfMemberToUpdate = Integer.parseInt(req.params("id"));
            Member editMember = memberDao.findById(idOfMemberToUpdate);
            model.put("editMember", editMember);
            return new ModelAndView(model, "editmember-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/members/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfMemberToUpdate = Integer.parseInt(req.params("id"));
            String name = req.queryParams("name");
            memberDao.update(idOfMemberToUpdate, name);
            Member editedMember = memberDao.findById(idOfMemberToUpdate);
            int teamId = editedMember.getTeamId();
            res.redirect("/teams/" + teamId);
            return null;
        }, new HandlebarsTemplateEngine());


        get("/teams/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToDelete = Integer.parseInt(req.params("id"));
            teamDao.deleteById(idOfTeamToDelete);
            memberDao.deleteAllByTeamId(idOfTeamToDelete);
            res.redirect("/teams");
            return null;
        }, new HandlebarsTemplateEngine());


    }
}
