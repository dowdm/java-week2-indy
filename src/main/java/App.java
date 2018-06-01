import java.util.*;
import models.Team;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> teams = Team.getTeamInstances();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> teams = Team.getTeamInstances();
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
            String memberOne = request.queryParams("memberOne");
            String memberTwo = request.queryParams("memberTwo");
            String memberThree = request.queryParams("memberThree");
            String memberFour = request.queryParams("memberFour");
            Team newTeam = new Team(teamName, teamDescription);
            newTeam.addTeamMember(memberOne);
            newTeam.addTeamMember(memberTwo);
            newTeam.addTeamMember(memberThree);
            newTeam.addTeamMember(memberFour);
            model.put("teams", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Team foundTeam = Team.findById(idOfTeamToFind);
            model.put("team", foundTeam);
            return new ModelAndView(model, "team-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            return new ModelAndView(model, "newteam-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("name");
            String teamDescription = request.queryParams("description");
            String memberOne = request.queryParams("memberOne");
            String memberTwo = request.queryParams("memberTwo");
            String memberThree = request.queryParams("memberThree");
            String memberFour = request.queryParams("memberFour");
            int idOfTeamToEdit = Integer.parseInt(request.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            editTeam.update(teamName, teamDescription);
            editTeam.addTeamMember(memberOne);
            editTeam.addTeamMember(memberTwo);
            editTeam.addTeamMember(memberThree);
            editTeam.addTeamMember(memberFour);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
