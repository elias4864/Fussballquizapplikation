package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Question.
 */
@Entity
@Table(name = "question")
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String question;

    private String correctAnswer;

    private String wrong_answer1;

    private String wrong_answer2;

        private String wrong_answer3;

        @Enumerated(EnumType.STRING)
        private Difficulty difficulty;

        @ManyToOne
        @JoinColumn(name = "category_id")
        @JsonBackReference("category-questions")
        private Category category;


        @ManyToOne
        @JoinColumn(name = "team_id")
        @JsonBackReference(value="team-questions")
        private Team team;
        /**
         * Jeder SPieler wird eine
         */




        // <--- Dieser Name muss mit 'mappedBy' übereinstimmen!

        @OneToOne(mappedBy = "question")
        @JsonManagedReference(value = "question-player") // Name für diese Beziehung
        private Player player;


        @ManyToOne
        @JoinColumn(name = "league_id",columnDefinition = "VARCHAR(10)")
        @JsonBackReference("league-questions") // Passend zur League
        private League league;

        @OneToMany(mappedBy = "question",  cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonManagedReference(value="question-answer")
        private List<Answer> answers = new ArrayList<>();




        /**
         * The enum Difficulty.
         */
        public enum Difficulty {
            /**
             * Leicht difficulty.
             */
            leicht,
            /**
             * Mittel difficulty.
             */
            mittel,
            /**
             * Schwer difficulty.
             */
            schwer};


        /**
         * Instantiates a new Question.
         */
    // Standard-Konstruktor (für JPA)
        public Question() {
            // Muss vorhanden sein!
        }

        /**
         * Instantiates a new Question.
         *
         * @param question      the question
         * @param correctAnswer the correct answer
         * @param wrong_answer1 the wrong answer 1
         * @param wrong_answer2 the wrong answer 2
         * @param wrong_answer3 the wrong answer 3
         * @param difficulty    the difficulty
         * @param category      the category
         * @param team          the team
         * @param answers       the answers
         * @param player        the player
         */
    // Konstruktor für deine Logik mit Attributen
        public Question(String question, String correctAnswer, String wrong_answer1, String wrong_answer2, String wrong_answer3, Difficulty difficulty, Category category, Team team,List<Answer> answers,Player player) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.wrong_answer1 = wrong_answer1;
            this.wrong_answer2 = wrong_answer2;
            this.wrong_answer3 = wrong_answer3;
            this.difficulty = difficulty; // Jetzt korrekt vom Typ Difficulty
            this.category = category;
            this.team = team;
            this.player = player;
            this.answers = answers;
        }

        /**
         * Instantiates a new Question.
         *
         * @param team the team
         */
        public Question(Team team) {
            this.team = team;
        }

        /**
         * Gets id.
         *
         * @return the id
         */
        public Integer getId() {
            return id;
        }

        /**
         * Sets id.
         *
         * @param id the id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * Gets team.
         *
         * @return the team
         */
        public Team getTeam() {
            return team;
        }

        /**
         * Sets team.
         *
         * @param team the team
         */
        public void setTeam(Team team) {
            this.team = team;
        }

        /**
         * Gets question.
         *
         * @return the question
         */
        public String getQuestion() {
            return question;
        }


        /**
         * Sets question.
         *
         * @param question the question
         */
        public void setQuestion(String question) {
            this.question = question;
        }

        /**
         * Gets correct answer.
         *
         * @return the correct answer
         */
        public String getCorrectAnswer() {
            return correctAnswer;
        }

        /**
         * Sets correct answer.
         *
         * @param correctAnswer the correct answer
         */
        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        /**
         * Gets wrong answer 1.
         *
         * @return the wrong answer 1
         */
        public String getWrong_answer1() {
            return wrong_answer1;
        }

        /**
         * Sets wrong answer 1.
         *
         * @param wrong_answer1 the wrong answer 1
         */
        public void setWrong_answer1(String wrong_answer1) {
            this.wrong_answer1 = wrong_answer1;
        }

        /**
         * Gets wrong answer 2.
         *
         * @return the wrong answer 2
         */
        public String getWrong_answer2() {
            return wrong_answer2;
        }

        /**
         * Sets wrong answer 2.
         *
         * @param wrong_answer2 the wrong answer 2
         */
        public void setWrong_answer2(String wrong_answer2) {
            this.wrong_answer2 = wrong_answer2;
        }

        /**
         * Gets wrong answer 3.
         *
         * @return the wrong answer 3
         */
        public String getWrong_answer3() {
            return wrong_answer3;
        }

        /**
         * Sets wrong answer 3.
         *
         * @param wrong_answer3 the wrong answer 3
         */
        public void setWrong_answer3(String wrong_answer3) {
            this.wrong_answer3 = wrong_answer3;
        }

        /**
         * Gets league.
         *
         * @return the league
         */
        public League getLeague() {
            return league;
        }

        /**
         * Sets league.
         *
         * @param league the league
         */
        public void setLeague(League league) {
            this.league = league;
        }

        /**
         * Gets difficulty.
         *
         * @return the difficulty
         */
        public Difficulty getDifficulty() {
            return difficulty;
        }

        /**
         * Sets difficulty.
         *
         * @param difficulty the difficulty
         */
        public void setDifficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
        }

        /**
         * Gets category.
         *
         * @return the category
         */
        public Category getCategory() {
            return category;
        }

        /**
         * Sets category.
         *
         * @param category the category
         */
        public void setCategory(Category category) {
            this.category = category;
        }

        /**
         * Gets player.
         *
         * @return the player
         */
        public Player getPlayer() {
            return player;
        }

        /**
         * Sets player.
         *
         * @param player the player
         */
        public void setPlayer(Player player) {
            this.player = player;
        }

        /**
         * Gets answers.
         *
         * @return the answers
         */
        public List<Answer> getAnswers() {
            return answers;
        }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", wrong_answer1='" + wrong_answer1 + '\'' +
                ", wrong_answer2='" + wrong_answer2 + '\'' +
                ", wrong_answer3='" + wrong_answer3 + '\'' +
                ", difficulty=" + difficulty +
                ", category=" + category +
                ", team=" + team +
                ", player=" + player +
                ", league=" + league +
                ", answers=" + answers +
                '}';
    }

    /**
         * Sets answers.
         *
         * @param answers the answers
         */
        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }
    }





