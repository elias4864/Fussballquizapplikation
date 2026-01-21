package org.example.model;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "team")
public class Team {



    @Id
    private Integer id;

    @Column(name = "team_name", nullable = false, length = 100)
    private String teamName;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "league_id")
    private League league;

    public  Team(){

    }

    public Team(Integer id, String teamName, League league) {
        this.id = id;
        this.teamName =teamName;
        this.league = league;
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


