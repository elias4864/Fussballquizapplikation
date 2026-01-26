package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type League.
 */
@Entity
@Table(name = "league")

public class League {

    @Id
    @Column(length = 10) // Verhindert den Versuch, auf 255 zu ändern
    private String id;

    private String name;

    @OneToMany(mappedBy = "league")
    @JsonManagedReference // Zeigt die Liste der Teams an, wenn eine Liga geladen wird
    private List<Team> teams = new ArrayList<>();


    /**
     * Alle Ligen haben mehrere Questions
     */
    @OneToMany(mappedBy = "league")
    @JsonManagedReference
    private List<Question> questions = new ArrayList<>();


    /**
     * Mehrere Antworten gehören zu einer spzezifischen Liga
     */

    @OneToMany(mappedBy = "league")
    @JsonManagedReference
    private  List<Answer> answers = new ArrayList<>();


    /**
     * Instantiates a new League.
     */
    public League(){

    }

    /**
     * Instantiates a new League.
     *
     * @param id   the id
     * @param name the name
     */
    public League(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * Sets teams.
     *
     * @param teams the teams
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "League{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
