package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

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
    @JsonBackReference
    private League league;

    /**
     * Liste aller Spieler, die diesem Team angehören.
     */
    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Player> players;

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Question> questions;


    public  Team(){

    }

    public Team(Integer id, String teamName, League league,List<Question> questions) {
        this.id = id;
        this.teamName =teamName;
        this.league = league;
        this.questions = questions;
    }

    public Team(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // GETTER / SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}


