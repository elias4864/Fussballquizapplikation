package org.example.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "category_name", nullable = false)
    private String name;
    @Column(name="team")
    private String team;
    @Column(name="position")
    private String position;
    @Column(name="nationality")
    private String nationality;

    //One to Many Beziehung eien Kategorie hat mehrere Fragen
        @OneToMany(mappedBy = "category")
    private List<Question> questions;

    public Category(){

    }


    public Category(String name, String team, String position, String nationality) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.nationality = nationality;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
