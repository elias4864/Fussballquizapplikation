DROP DATABASE IF EXISTS fussball_quiz;
CREATE DATABASE fussball_quiz;
USE fussball_quiz;

-- 1. Basis-Tabellen
CREATE TABLE league (
                        id VARCHAR(10) PRIMARY KEY,
                        name VARCHAR(200) NOT NULL
);

CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          category_name VARCHAR(200)
);

-- 2. Hierarchische Tabellen (Teams & Spieler)
CREATE TABLE team (
                      id INT PRIMARY KEY,
                      team_name VARCHAR(100) NOT NULL,
                      league_id VARCHAR(10),
                      FOREIGN KEY (league_id) REFERENCES league(id)
);

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

-- 3. Kern-Tabelle (Fragen)
CREATE TABLE question (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          question TEXT NOT NULL,
                          correct_answer VARCHAR(200) NOT NULL,
                          wrong_answer1 VARCHAR(200),
                          wrong_answer2 VARCHAR(200),
                          wrong_answer3 VARCHAR(200),
                          player_id INT,
                          category_id INT,
                          team_id INT,
                          league_id VARCHAR(10),
                          difficulty ENUM('leicht','mittel','schwer'),
                          FOREIGN KEY (category_id) REFERENCES category(id),
                          FOREIGN KEY (player_id) REFERENCES player(id),
                          FOREIGN KEY (team_id) REFERENCES team(id),
                          FOREIGN KEY (league_id) REFERENCES league(id)
);

-- 4. Antwort-Tabelle (Schlankes Design)
CREATE TABLE answer (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        question_id INT NOT NULL,
                        answer_text VARCHAR(300) NOT NULL,
                        is_correct BOOLEAN,
                        FOREIGN KEY (question_id) REFERENCES question(id)
);

--- DATEN EINFÜGEN ---

INSERT INTO league (id, name) VALUES
                                  ('SL', 'Super League'), ('LL', 'La Liga'), ('BL', 'Bundesliga'), ('PL', 'Premier League'), ('CL', 'Champions League');

INSERT INTO team (id, team_name, league_id) VALUES
                                                (1, 'FC Basel', 'SL'), (2, 'Grasshopper Club', 'SL'), (7, 'Bayern München', 'BL'), (8, 'Real Madrid', 'LL'), (13, 'Inter Mailand', 'CL');

INSERT INTO category (id, category_name) VALUES
                                             (10,'Nationalität'), (20,'Verein'), (30,'Position'), (50,'Spielerstatus');

INSERT INTO player (id, first_name, last_name, birth_year, position, nationality, team_id, isactive) VALUES
                                                                                                         (10, 'Yann', 'Sommer', 1988, 'Torwart', 'Schweiz', 13, TRUE),
                                                                                                         (12, 'Diego', 'Maradona', 1960, 'Mittelfeld', 'Argentinien', 8, FALSE),
                                                                                                         (34, 'Cristiano', 'Ronaldo', 1985, 'Sturm', 'Portugal', 8, TRUE);

-- Beispielfragen
INSERT INTO question (id, question, correct_answer, player_id, category_id, team_id, league_id, difficulty) VALUES
                                                                                                                (1, 'Welche Position spielt Yann Sommer?','Torwart',10, 30, 13,'CL','mittel'),
                                                                                                                (2, 'Von welchem Land kommt Diego Maradona?', 'Argentinien', 12, 10, 8, 'LL', 'leicht');

-- Antworten (Nur Referenz auf Question-ID nötig)
INSERT INTO answer (question_id, answer_text, is_correct) VALUES
                                                              (1, 'Verteidiger', TRUE),
                                                              (1, 'Mittelfeld', FALSE),
                                                              (1, 'Torwart', FALSE),
                                                              (1,'Sturm', FALSE),
                                                              (2, 'Torwart', TRUE),




ALTER TABLE answer DROP FOREIGN KEY answer_ibfk_2;
ALTER TABLE answer DROP COLUMN category_id;

-- Rechte vergeben
CREATE USER IF NOT EXISTS 'fussball_elias' IDENTIFIED by 'momo9010';
GRANT ALL PRIVILEGES ON fussball_quiz.* TO 'fussball_elias'@'%';
FLUSH PRIVILEGES;