package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

/**
 * The type Answer.
 */
@Entity
@Table(name = "answer")
public class Answer {

    /**
     * @param id
     * @return id
     *Automatisch
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;





    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference(value = "question-answer")
    private Question question;


    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "category-answers") // NEU
    private Category category;



    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    @ManyToOne
    @JoinColumn(name = "league_id",columnDefinition = "VARCHAR(10)")
    private League league;


    /**
     * Instantiates a new Answer.
     */
// Standard-Konstruktor
    public Answer() {

    }

    /**
     * Instantiates a new  Answer Konstruktor
     *
     * @param id       the id
     * @param question the question
     * @param category the category
     * @param player   the player
     * @param team     the team
     * @param league   the league
     */
    public Answer(Integer id, Question  question,Category category,Player player, Team team, League league) {
        this.id = id;
        this.question = question;
        this.category = category;
        this.player = player;
        this.team = team;
        this.league = league;


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
     * Gets question.
     *
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Sets question.
     *
     * @param question the question
     */
    public void setQuestion(Question question) {
        this.question = question;
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

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", question=" + question +
                ", category=" + category +
                ", player=" + player +
                ", team=" + team +
                ", league=" + league +
                '}';
    }
}



