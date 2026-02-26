-- 1. Datenbank sauber neu aufsetzen
DROP DATABASE IF EXISTS fussball_quiz;
CREATE DATABASE fussball_quiz;
USE fussball_quiz;

-- 2. Tabelle Liga
CREATE TABLE league (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

INSERT INTO league (id, name) VALUES
('SL', 'Super League'), ('LL', 'La Liga'), ('EL', 'Europa League'),
('BL', 'Bundesliga'), ('PL', 'Premier League'), ('CL', 'Champions League'),
('CA', 'Copa América'), ('SA','Serie A');

-- 3. Tabelle Team
CREATE TABLE team (
    id INT PRIMARY KEY,
    team_name VARCHAR(100) NOT NULL,
    league_id VARCHAR(10),
    FOREIGN KEY (league_id) REFERENCES league(id) ON DELETE SET NULL
);

INSERT INTO team (id, team_name, league_id) VALUES
(7, 'FC Bayern München', 'BL'),
(8, 'Real Madrid', 'LL'),
(9, 'FC Barcelona', 'LL'),
(11, 'Manchester City', 'PL'),
(12, 'Paris Saint-Germain', 'CL'),
(13, 'Inter Mailand', 'SA'),
(14, 'Chicago Fire', 'PL'),
(17, 'FC Santos', 'CA');

-- 4. Tabelle Player
CREATE TABLE player (
    id INT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(200),
    birth_year YEAR,
    position ENUM('Torwart','Verteidiger','Mittelfeld','Sturm'),
    nationality VARCHAR(50),
    team_id INT,
    stats VARCHAR(200),
    isactive BOOLEAN,
    FOREIGN KEY (team_id) REFERENCES team(id) ON DELETE SET NULL
);

INSERT INTO player (id, first_name, last_name, birth_year, position, nationality, team_id, stats, isactive) VALUES
(10, 'Yann', 'Sommer', 1988, 'Torwart', 'Schweiz', 13, 'Stammtorwart', TRUE),
(12, 'Diego', 'Maradona', 1960, 'Mittelfeld', 'Argentinien', 9, 'Legende', FALSE),
(14, 'Xherdan', 'Shaqiri', 1991, 'Mittelfeld', 'Schweiz', 14, 'Spielmacher', TRUE),
(20, 'Manuel', 'Akanji', 1995, 'Verteidiger', 'Schweiz', 11, '0 Tore im letzten Spiel', TRUE),
(34, 'Cristiano', 'Ronaldo', 1985, 'Sturm', 'Portugal', 8, 'Meiste Tore bei Real', TRUE),
(38, 'Kylian', 'Mbappe', 1998, 'Sturm', 'Frankreich', 12, '4 Tore im letzten Spiel', TRUE),
(48, 'Pelé', '', 1940, 'Sturm', 'Brasilien', 17, '3-facher Weltmeister', FALSE),
(53, 'Iker', 'Casillas', 1981, 'Torwart', 'Spanien', 8, 'EM Sieger 2008/2012', FALSE),
(80, 'Oliver', 'Kahn', 1969, 'Torwart', 'Deutschland', 7, 'Titan', FALSE);

-- 5. Tabelle Kategorie
CREATE TABLE category (
    id INT PRIMARY KEY,
    category_name VARCHAR(200)
);

INSERT INTO category (id, category_name) VALUES
(10,'Nationalität'), (20,'Verein'), (30,'Position'), (50,'Spielerstatus'), (35,'Spieler'), (14,'Legenden'),(55, 'Geburtsdatum'),(45, 'Team');


-- 6. Tabelle Question
CREATE TABLE question (
    id INT PRIMARY KEY,
    question TEXT NOT NULL,
    correct_answer VARCHAR(200) NOT NULL,
    player_id INT,
    category_id INT,
    difficulty ENUM('leicht','mittel','schwer'),
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE,
    FOREIGN KEY (player_id) REFERENCES player(id) ON DELETE SET NULL
);

INSERT INTO question (id, question, correct_answer, player_id, category_id, difficulty) VALUES
(1, 'Für welchen Klub spielt Yann Sommer aktuell?', 'Inter Mailand', 10, 20, 'leicht'),
(2, 'Wie viele Tore schoss Manuel Akanji laut Statistik im letzten Spiel?', '0 Tore', 20, 35, 'mittel'),
(3, 'Bei welchem Klub verbrachte Ronaldo seine erfolgreichste Zeit?', 'Real Madrid', 34, 20, 'mittel'),
(4, 'Welche Legende ist bereits verstorben/inaktiv?', 'Pelé', 48, 50, 'leicht'),
(5, 'Welcher Torwart gewann die EM 2008 und 2012?', 'Iker Casillas', 53, 14, 'mittel'),
(6, 'Wie viele Tore erzielte Mbappé im letzten Spiel?', '4 Tore', 38, 35, 'schwer'),
(7, 'Welche Position spielt Shaqiri?', 'Mittelfeld', 14, 30, 'mittel'),
(8, 'Was ist der Vorname des Keepers mit ID 80?', 'Oliver', 80, 35, 'mittel'),
(9, 'Aus welchem Land stammt Maradona?', 'Argentinien', 12, 10, 'leicht');

-- 7. Tabelle Answer (Antwort-Optionen)
CREATE TABLE answer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT,
    answer_text VARCHAR(300),
    is_correct BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE
);

-- Beispiel-Antworten (Hier nur ein Teil zur Übersicht, Rest folgt dem selben Schema)
INSERT INTO answer (question_id, answer_text, is_correct) VALUES
(1, 'Inter Mailand', TRUE), (1, 'FC Basel', FALSE), (1, 'Bayern München', FALSE), (1, 'Borussia M.', FALSE),
(2, '0 Tore', TRUE), (2, '1 Tor', FALSE), (2, '2 Tore', FALSE), (2, '1 Assist', FALSE),
(3, 'Real Madrid', TRUE), (3, 'Manchester United', FALSE), (3, 'Juventus', FALSE), (3, 'Sporting', FALSE),
(4, 'Pelé', TRUE), (4, 'Kylian Mbappé', FALSE), (4, 'Cristiano Ronaldo', FALSE), (4, 'Lionel Messi', FALSE),
(5, 'Iker Casillas', TRUE), (5, 'Gianluigi Buffon', FALSE), (5, 'Manuel Neuer', FALSE), (5, 'Edwin van der Sar', FALSE),
(6, '4 Tore', TRUE), (6, '3 Tore', FALSE), (6, '2 Tore', FALSE), (6, '5 Tore', FALSE),
(7, 'Mittelfeld', TRUE), (7, 'Sturm', FALSE), (7, 'Verteidiger', FALSE), (7, 'Torwart', FALSE),
(8, 'Oliver', TRUE), (8, 'Manuel', FALSE), (8, 'Jens', FALSE), (8, 'Sepp', FALSE),
(9, 'Argentinien', TRUE), (9, 'Brasilien', FALSE), (9, 'Uruguay', FALSE), (9, 'Mexiko', FALSE);

-- 8. Benutzerberechtigungen
-- Falls du auf einem lokalen Server bist, stelle sicher, dass du DB-Admin Rechte hast
CREATE USER IF NOT EXISTS 'fussball_elias'@'%' IDENTIFIED BY 'momo9010';
GRANT ALL PRIVILEGES ON fussball_quiz.* TO 'fussball_elias'@'%';
FLUSH PRIVILEGES;

-- Test-Abfrage
SELECT * FROM question;

