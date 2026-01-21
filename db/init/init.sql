DROP DATABASE IF EXISTS fussball_quiz;
CREATE DATABASE fussball_quiz;
USE fussball_quiz;

-- 1. LEAGUE
CREATE TABLE league (
                        id VARCHAR(10) PRIMARY KEY,
                        name VARCHAR(200) NOT NULL
);

-- 2. CATEGORY (Erweitert um die Felder, die Hibernate laut Log erwartet)
CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          category_name VARCHAR(255) NOT NULL,
                          nationality VARCHAR(255),
                          position VARCHAR(255),
                          team VARCHAR(255)
);

-- 3. TEAM
CREATE TABLE team (
                      id INT PRIMARY KEY,
                      team_name VARCHAR(100) NOT NULL,
                      league_id VARCHAR(10),
                      FOREIGN KEY (league_id) REFERENCES league(id)
);

-- 4. PLAYER (Zirkelbezug-Vermeidung: question_id wird später per ALTER hinzugefügt)
CREATE TABLE player (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        first_name VARCHAR(100),
                        last_name VARCHAR(200),
                        birth_year INT, -- Von YEAR auf INT geändert für Hibernate Kompatibilität
                        position ENUM('Torwart','Verteidiger','Mittelfeld','Sturm'),
                        nationality VARCHAR(255),
                        team_id INT,
                        stats VARCHAR(255),
                        isactive BOOLEAN,
                        question_id INT,
                        FOREIGN KEY (team_id) REFERENCES team(id)
);

-- 5. QUESTION (category_id direkt integriert, damit NOT NULL Constraint klappt)
CREATE TABLE question (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          question TEXT NOT NULL,
                          correct_answer VARCHAR(255) NOT NULL,
                          wrong_answer1 VARCHAR(255),
                          wrong_answer2 VARCHAR(255),
                          wrong_answer3 VARCHAR(255),
                          player_id INT,
                          team_id INT,
                          league_id VARCHAR(10),
                          category_id INT NOT NULL, -- Pflichtfeld für Hibernate
                          difficulty ENUM('leicht','mittel','schwer') DEFAULT 'leicht',
                          FOREIGN KEY (player_id) REFERENCES player(id),
                          FOREIGN KEY (team_id) REFERENCES team(id),
                          FOREIGN KEY (league_id) REFERENCES league(id),
                          FOREIGN KEY (category_id) REFERENCES category(id)
);

-- 6. PLAYER-QUESTION Zirkelschluss schließen
ALTER TABLE player ADD CONSTRAINT fk_player_question FOREIGN KEY (question_id) REFERENCES question(id);

-- 7. ANSWER
CREATE TABLE answer (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        question_id INT NOT NULL,
                        answer_text VARCHAR(255) NOT NULL,
                        is_correct BOOLEAN,
                        category_id INT,
                        player_id INT,
                        team_id INT,
                        league_id VARCHAR(10),
                        FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE,
                        FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE SET NULL,
                        FOREIGN KEY (player_id) REFERENCES player(id) ON DELETE SET NULL,
                        FOREIGN KEY (team_id) REFERENCES team(id) ON DELETE SET NULL,
                        FOREIGN KEY (league_id) REFERENCES league(id) ON DELETE SET NULL
);

-- DATEN EINFÜGEN (Reihenfolge beachten!)
INSERT INTO league (id, name) VALUES ('SL', 'Super League'), ('LL', 'La Liga'), ('BL', 'Bundesliga'), ('CL', 'Champions League');
INSERT INTO category (id, category_name) VALUES (10, 'Allgemein'), (20, 'Verein');
INSERT INTO team (id, team_name, league_id) VALUES (1, 'FC Basel', 'SL'), (13, 'Inter Mailand', 'CL');

-- WICHTIG: Erst Player, dann Question (wegen IDs)
INSERT INTO player (id, first_name, last_name, birth_year, position, nationality, team_id, isactive)
VALUES (10, 'Yann', 'Sommer', 1988, 'Torwart', 'Schweiz', 1, TRUE);

-- Questions mit korrekter category_id (10 oder 20)
INSERT INTO question (id, question, correct_answer, wrong_answer1, player_id, category_id, difficulty)
VALUES (1, 'Klub von Yann Sommer?', 'Inter Mailand', 'FC Zürich', 10, 20, 'leicht');

INSERT INTO answer (question_id, answer_text, is_correct, category_id)
VALUES (1, 'Inter Mailand', TRUE, 20);

-- BERECHTIGUNGEN
CREATE USER IF NOT EXISTS 'fussball_elias'@'%' IDENTIFIED BY 'momo9010';
GRANT ALL PRIVILEGES ON fussball_quiz.* TO 'fussball_elias'@'%';
FLUSH PRIVILEGES;                                                                                           (1, 'FC Zürich', FALSE, 20, 10, 4, 'SL');