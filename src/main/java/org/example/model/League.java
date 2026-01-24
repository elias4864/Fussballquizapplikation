package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "league")
    @JsonManagedReference
    private List<Question> questions = new ArrayList<>();



    @OneToMany(mappedBy = "league")
    @JsonManagedReference
    private  List<Answer> answers = new ArrayList<>();

    public League(){

    }
    public League(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

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
