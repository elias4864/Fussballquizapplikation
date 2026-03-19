package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

/**
 * The type Team.
 */
@Entity
@Table(name = "team")
public class Team {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "team_name", nullable = false, length = 100)
    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    @JsonBackReference(value="league-teams") // NEU: Damit die Liga-Teams Beziehung auch einen Namen hat
    private League league;

    /**
     * Liste aller Spieler, die diesem Team angehören.
     */
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Player> players;


    /**
     * EIn Spieler gehört zu mehrenr Fragen in der Quesiton Liste
     */
    @OneToMany(mappedBy = "team")
    @JsonManagedReference(value="team-questions")
    private List<Question> questions;


    /**
     * Instantiates a new Team.
     */
    public  Team(){

    }

    /**
     * Instantiates a new Team.
     *
     * @param id        the id
     * @param teamName  the team name
     * @param league    the league
     * @param questions the questions
     */
    public Team(Integer id, String teamName, League league,List<Question> questions) {
        this.id = id;
        this.teamName =teamName;
        this.league = league;
        this.questions = questions;
    }

    /**
     * Instantiates a new Team.
     *
     * @param questions the questions
     */
    public Team(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Gets questions.
     *
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets questions.
     *
     * @param questions the questions
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
// GETTER / SETTER
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
     * Gets team name.
     *
     * @return the team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets team name.
     *
     * @param teamName the team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Gets league.
     *
     * @return the league
     */


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

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
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", league=" + league +
                ", players=" + players +
                ", questions=" + questions +
                '}';
    }
}



