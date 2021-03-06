# **Team-Tracker**

#### By Matt Dowdney

### This is web based application demonstrating principles of CRUD and REST, programmed in Java. Users may start a team for a Hackathon, initially submitting a team name, description and members. Next users can view a list of teams, select a specific team, and  view the details for that team. Users may also edit a team, edit or delete individual team members, and delete the team and all members of that team entirely.  

## Specifications

|Specification  | Input | Output |
| ----- | --- | --- |
| Enter team name | The Cats | Team name: The Cats |
| Enter a team description |Robot builders that like destruction. | Team description: Robot builders that like destruction |
| Enter members of team | Mike Smith, Bob Ross| Current Members: Mike Smith Bob Ross |
| Build a team from entries. | The Cats, Mike Smith, Bob Ross, Robot builders that like destruction  |  Team name: The Cats; Team description: Robot builders that like destruction; Current Members: Mike Smith Bob Ross   |
|Edit details of name or description |<del>The Cats</del> ....The Thundercats | Team Name: The Thundercats|
| Add members | Tommy Thompson | Current members: Mike Smith, Bob Ross, Tommy Thompson|
| Delete members | <del>Tommy Thompson</del> | Current members: Mike Smith, Bob Ross|
| Edit members | <del>Bob Ross</del>....Bob Villa | Current members: Mike Smith, Bob Villa|
|Delete a team |<del>The Cats</del> | team and members are permanently deleted from database|







## Setup/Installation Requirements
* To view project code, visit: https://github.com/dowdm/java-week2-indy.git
* To view project from build: clone or download project from https://github.com/dowdm/java-week2-indy.git . Install developer dependencies(Spark, Handlebars, JUnit, h2, sql2o). Compile the App.java file in a Java compiler or IDE such as IntelliJ. Run App. Open a browser to http://localhost:4567 . Enjoy. 






## Known Bugs

## Technologies Used

* Java 8 
* JUnit 4 
* IntelliJ Community 2018 
* Spark 2.6.0 
* Handlebars Spark Template 2.5.5
* h2 (simulating a Postgres DB)
* sql2o




## License

* GPL

Matt Dowdney © 2018