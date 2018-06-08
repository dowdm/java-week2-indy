SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS teams (
    id int PRIMARY KEY auto_increment,
    teamName VARCHAR,
    teamDescription VARCHAR,
);

CREATE TABLE IF NOT EXISTS members (
    id int PRIMARY KEY auto_increment,
    teamId INTEGER,
    name VARCHAR,
);