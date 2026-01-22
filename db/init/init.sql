DROP DATABASE IF EXISTS fussball_quiz;
CREATE DATABASE fussball_quiz;
USE fussball_quiz;


CREATE TABLE league (
                        id VARCHAR(10) PRIMARY KEY,
                        name VARCHAR(200) NOT NULL
);


-- alle Ligas der verwendet Spieler aus der Fragen in Leagu Tabelle eingefügt
INSERT INTO league (id, name) VALUES
                                  ('SL', 'Super League'),
                                  ('LL', 'La Liga'),
                                  ('EL', 'Europa League'),
                                  ('CH', 'Schweizer Meister'),
                                  ('BL', 'Bundesliga'),
                                  ('PL', 'Premier League'),
                                  ('CL', 'Champions League'),
                                  ('CA', 'Copa América');


CREATE TABLE team (
                      id INT PRIMARY KEY,
                      team_name VARCHAR(100) NOT NULL,
                      league_id VARCHAR(10),
                      FOREIGN KEY (league_id) REFERENCES league(id)
);

INSERT INTO team (id, team_name, league_id) VALUES
                                                (1, 'FC Basel', 'SL'),
                                                (2, 'Grasshopper Club Zürich', 'SL'),
                                                (3, 'BSC Young Boys', 'SL'),
                                                (4, 'FC Zürich', 'SL'),
                                                (5, 'FC St. Gallen', 'SL'),
                                                (6, 'FC Luzern', 'SL'),
                                                (7, 'FC Bayern München', 'BL'),
                                                (8, 'Real Madrid', 'LL'),
                                                (9, 'FC Barcelona', 'LL'),
                                                (10, 'Manchester City', 'PL'),
                                                (11, 'Liverpool FC', 'PL'),
                                                (12, 'Paris Saint-Germain', 'CL'),
                                                (13, 'Inter Mailand', 'CL'),
                                                (14, 'AS Rom', 'EL'),
                                                (15, 'Sevilla FC', 'EL'),
                                                (16, 'RB Leipzig', 'BL'),
                                                (17, 'FC Santos', 'CA'),
                                                (18, 'FC Porto', 'CL');


-- Player Table

CREATE TABLE player (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        first_name VARCHAR(100),
                        last_name VARCHAR(200),
                        birth_year YEAR,
                        position ENUM('Torwart','Verteidiger','Mittelfeld','Sturm'),
                        nationality VARCHAR(50),
                        team_id INT,
                        stats VARCHAR(200),
                        isactive BOOLEAN,
                        FOREIGN KEY (team_id) REFERENCES team(id)
);

INSERT INTO player (id, first_name, last_name, birth_year, position, nationality, team_id, stats, isactive) VALUES
                                                                                                                (10, 'Yann', 'Sommer', 1988, 'Torwart', 'Schweiz', 1, '100 Spiele gewonnen', TRUE),
                                                                                                                (12, 'Diego', 'Maradona', 1960, 'Mittelfeld', 'Argentinien', 10, 'pro Spiel mindestens 3 Tore', FALSE),
                                                                                                                (14, 'Xherdan', 'Shaqiri', 1991, 'Mittelfeld', 'Schweiz', 2, 'letztes Spiel 2 Tore', TRUE),
                                                                                                                (20, 'Manuel', 'Akanji', 1995, 'Verteidiger', 'Schweiz', 11, 'letztes Spiel 0 Tore', TRUE),
                                                                                                                (24, 'Ricardo', 'Rodriguez', 1992, 'Verteidiger', 'Schweiz', 3, 'letztes Spiel 1 Tor', TRUE),
                                                                                                                (26, 'Breel', 'Embolo', 1997, 'Sturm', 'Schweiz', 4, 'letztes Spiel 1 Tor', TRUE),
                                                                                                                (34, 'Cristiano', 'Ronaldo', 1985, 'Sturm', 'Portugal', 9, 'letztes Spiel 3 Tore', TRUE),
                                                                                                                (38, 'Kylian', 'Mbappe', 1998, 'Sturm', 'Frankreich', 12, 'letztes Spiel 4 Tore', TRUE),
                                                                                                                (53, 'Iker', 'Casillas', 1981, 'Torwart', 'Spanien', 8, 'WM 2010, EM 2008/2012', FALSE),
                                                                                                                (48, 'Pelé', '', 1940, 'Sturm', 'Brasilien', 17, 'pro Spiel etwa 2 Tore und mehrere Assists', FALSE),
                                                                                                                (80, 'Oliver', 'Kahn', 1980, 'Torwart', 'Deutschland', 7, 'pro Spiel etwa 20 Saves und eine Torwarteffizienz von 98%', FALSE);



CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          category_name VARCHAR(200) NOT NULL
);

-- Alle Kategorien welche bei den Fragen vorkommen könnten
INSERT INTO category (id, category_name) VALUES
                                             (10,'Nationalität'),
                                             (20,'Verein'),
                                             (30,'Position'),
                                             (40,'Karriere'),
                                             (50,'Spielerstatus'),
                                             (55,'Geburtsdatum'),
                                             (60,'Allgemeinwissen'),
                                             (14,'Legenden'),
                                             (21,'Aktive Spieler'),
                                             (35,'Spieler'),
                                             (45,'Team');


CREATE TABLE question (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          question TEXT NOT NULL,
                          correct_answer VARCHAR(200) NOT NULL,
                          wrong_answer1 VARCHAR(200),
                          wrong_answer2 VARCHAR(200),
                          wrong_answer3 VARCHAR(200),
                          player_id INT,category_id INT ,
                          team_id INT,
                          league_id VARCHAR(10),
                          difficulty ENUM('leicht','mittel','schwer'),
                          FOREIGN KEY (category_id) REFERENCES category(id),
                          FOREIGN KEY (player_id) REFERENCES player(id)
);


INSERT INTO question
(id, question, correct_answer, wrong_answer1, wrong_answer2, wrong_answer3, player_id, difficulty)
VALUES
    (1, 'Für welchen Klub spielt Yann Sommer aktuell ?',
     'Inter Mailand', 'FC Zürich', 'Grasshopper Club Zürich', 'FC Luzern', 10, 'leicht'),

    (2, 'Wie sieht die Torbilanz von Manuel Akanji vom letzten Spiel aus?',
     '2 Tore', '1 Tor', 'kein Tor', '1 Assist', 20, 'mittel'),

    (3, 'In welchem Klub spielt/spielte Ronaldo am längsten in seiner Fussballkarierre ?',
     'Real Madrid', 'Al Nassr Riad', 'Machester City', 'AC Mailand', 34, 'mittel'),

    (4, 'Welcher Spieler  ist aktuell inaktiv im Fussball?',
     'Pelé', 'Breel Embolo', 'Kylian Mbappe', 'Yann Sommer', 48, 'leicht'),

    (5, 'Welcher Spieler hat die EM 2008 und EM 2012 gewonnen?',
     'Iker Casillas', 'Oliver Kahn', 'Cristiano Ronaldo', 'Pelé', 53, 'mittel'),

    (6, 'Wie viele Tore erzielte Kylian Mbappé im letzten Spiel?',
     '4 Tore', '2 Tore', '3 Tore', '1 Tor', 38, 'schwer'),

    (7, 'Welche Position spielt Shaqiri?',
     'Mittelfeld', 'Sturm', 'Verteidiger', 'Torwart', 14, 'mittel'),  -- Korrigiert: "Torwart" statt zweites "Mittelfeld"

    (8, 'Was ist der Vorname des Spielers mit der Spieler Id 80?',
     'Thomas', 'Manuel', 'Oliver', 'Breel', 80, 'mittel'),

    (9, 'Von welchem Land kommt Diego Maradona?',
     'Argentinien', 'Brasilien', 'Kolumbien', 'Honduras', 12, 'leicht');


-- Constraints Team und Question, League und question anhand id
ALTER TABLE question
    ADD CONSTRAINT fk_question_team FOREIGN KEY (team_id) REFERENCES team(id),
    ADD CONSTRAINT fk_question_league FOREIGN KEY (league_id) REFERENCES league(id);


ALTER TABLE player ADD COLUMN question_id INT,
                   ADD CONSTRAINT fk_player_question FOREIGN KEY (question_id) REFERENCES question(id);


CREATE TABLE answer (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        question_id INT NOT NULL,
                        answer_text VARCHAR(300) NOT NULL,
                        is_correct BOOLEAN,
                        category_id INT,
                        player_id INT,
                        team_id INT,
                        league_id VARCHAR(10),
                        FOREIGN KEY (question_id) REFERENCES question(id),
                        FOREIGN KEY (category_id) REFERENCES category(id),
                        FOREIGN KEY (player_id) REFERENCES player(id),
                        FOREIGN KEY (team_id) REFERENCES team(id) ,
                        FOREIGN KEY (league_id) REFERENCES league(id)
);

INSERT INTO answer (question_id, answer_text, is_correct, category_id, player_id, team_id, league_id)
VALUES
-- Antworten zu Frage 1 (Yann Sommer)
(1, 'Inter Mailand', TRUE, 20, 10, 13, 'CL'),  -- Inter Mailand existiert (id=13)
(1, 'FC Zürich', FALSE, 20, 10, 4, 'SL'),      -- FC Zürich existiert (id=4)
(1, 'Grasshopper Club Zürich', FALSE, 20, 10, 2, 'SL'),  -- Grasshopper existiert (id=2)
(1, 'FC Luzern', FALSE, 20, 10, 6, 'SL'),

(2, '0 Tore', TRUE, 35, 20, 11, 'PL'),
(2, '1 Tor', FALSE, 35, 20, 11, 'PL'),
(2, '2 Tore', FALSE, 35, 20, 11, 'PL'),
(2, '1 Assist', FALSE, 35, 20, 11, 'PL'),

(3, 'Real Madrid', TRUE, 20, 34, 9, 'LL'),
(3, 'Al Nassr Riad', FALSE, 20, 34, 10, 'PL'),
(3, 'Machester City', FALSE, 20, 34, 11, 'PL'),
(3, 'AC Mailand', FALSE, 20, 34, NULL, NULL),

-- Frage 4: Inaktiver Spieler (Kategorie: 50 Spielerstatus)
(4, 'Pelé', TRUE, 50, 48, 17, 'CA'),
(4, 'Breel Embolo', FALSE, 50, 26, 4, 'SL'),
(4, 'Kylian Mbappe', FALSE, 50, 38, 12, 'CL'),
(4, 'Yann Sommer', FALSE, 50, 10, 1, 'SL'),

-- Frage 5: EM Sieger 2008/2012 (Kategorie: 14 Legenden)
(5, 'Iker Casillas', TRUE, 14, 53, 8, 'LL'),
(5, 'Oliver Kahn', FALSE, 14, 80, 7, 'BL'),
(5, 'Cristiano Ronaldo', FALSE, 14, 34, 9, 'LL'),
(5, 'Pelé', FALSE, 14, 48, 17, 'CA'),

-- Frage 6: Mbappé Tore (Kategorie: 35 Spieler)
(6, '4 Tore', TRUE, 35, 38, 12, 'CL'),
(6, '2 Tore', FALSE, 35, 38, 12, 'CL'),
(6, '3 Tore', FALSE, 35, 38, 12, 'CL'),
(6, '1 Tor', FALSE, 35, 38, 12, 'CL'),

-- Frage 7: Shaqiri Position (Kategorie: 30 Position)
(7, 'Mittelfeld', TRUE, 30, 14, 2, 'SL'),
(7, 'Sturm', FALSE, 30, 14, 2, 'SL'),
(7, 'Verteidiger', FALSE, 30, 14, 2, 'SL'),
(7, 'Torwart', FALSE, 30, 14, 2, 'SL'),

-- Frage 8: Vorname ID 80 (Kategorie: 35 Spieler)
(8, 'Oliver', TRUE, 35, 80, 7, 'BL'),
(8, 'Thomas', FALSE, 35, 80, 7, 'BL'),
(8, 'Manuel', FALSE, 35, 80, 7, 'BL'),
(8, 'Breel', FALSE, 35, 80, 7, 'BL'),

-- Frage 9: Maradona Herkunft (Kategorie: 10 Nationalität)
(9, 'Argentinien', TRUE, 10, 12, 10, 'PL'),
(9, 'Brasilien', FALSE, 10, 12, 10, 'PL'),
(9, 'Kolumbien', FALSE, 10, 12, 10, 'PL'),
(9, 'Honduras', FALSE, 10, 12, 10, 'PL');


-- Category id und Teamid udn league_id Attribute abfüllen mit werten gemäss Constraints und werte dr einzelen Tabllen
UPDATE question
SET category_id = 20, team_id = 13, league_id = 'CL'
WHERE id = 1;

-- Frage 2: Manuel Akanji (Kategorie: Spieler, Team: Liverpool FC, Liga: Premier League)
UPDATE question
SET category_id = 35, team_id = 11, league_id = 'PL'
WHERE id = 2;

-- Frage 3: Cristiano Ronaldo (Kategorie: Verein, Team: FC Barcelona, Liga: La Liga)
UPDATE question
SET category_id = 20, team_id = 9, league_id = 'LL'
WHERE id = 3;

-- Frage 4: Pelé/Inaktivität (Kategorie: Spielerstatus, Team: FC Santos, Liga: Copa América) Daten der Tableln Kategory, Team und league abgefüllt
UPDATE question
SET category_id = 50, team_id = 17, league_id = 'CA'
WHERE id = 4;

-- Frage 5: Iker Casillas (Kategorie: Legenden, Team: Real Madrid, Liga: La Liga)
UPDATE question
SET category_id = 14, team_id = 8, league_id = 'LL'
WHERE id = 5;

-- Frage 6: Mbappé Tore (Kategorie: Spieler, Team: Paris Saint-Germain, Liga: Champions League)
UPDATE question
SET category_id = 35, team_id = 12, league_id = 'CL'
WHERE id = 6;

-- Frage 7: Shaqiri Position (Kategorie: Position, Team: Grasshopper Club, Liga: Super League)
UPDATE question
SET category_id = 30, team_id = 2, league_id = 'SL'
WHERE id = 7;

-- Frage 8: Oliver Kahn Vorname (Kategorie: Spieler, Team: FC Bayern München, Liga: Bundesliga)
UPDATE question
SET category_id = 35, team_id = 7, league_id = 'BL'
WHERE id = 8;

-- Frage 9: Maradona Herkunft (Kategorie: Nationalität, Team: Manchester City, Liga: Premier League)
UPDATE question
SET category_id = 10, team_id = 10, league_id = 'PL'
WHERE id = 9;


-- User fussball_elias Erstelle und alle Berechtigungen verteilt
CREATE USER IF NOT EXISTS 'fussball_elias' IDENTIFIED by 'momo9010';
GRANT ALL PRIVILEGES ON fussball_quiz.* TO 'fussball_elias'@'%';
FLUSH PRIVILEGES;                                                                                          (1, 'FC Zürich', FALSE, 20, 10, 4, 'SL');