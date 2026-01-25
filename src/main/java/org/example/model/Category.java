package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentiert eine Quiz-Kategorie (z. B. Nationalität, Verein).
 * Verwaltet die bidirektionalen Beziehungen zu Fragen und Antworten
 * mittels Jackson-Referenzen zur Vermeidung von Rekursionen.
 * Mit At Tbael erstltl einen Tabelle Category
 */
@Entity
@Table(name = "category")
public class Category {


    /**
     * Automatisch geneirtet Attribut id  das Primary Key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /**
     *Attribut name
     */
    @Column(name = "category_name", nullable = false)
    private String name;

    /**
     *Team Attribut wird hinzugefügt
     */
    @Column(name="team")
    private String team;




    /**
     * Positition Attibut
     */
    @Column(name="position")
    private String position;
    @Column(name="nationality")
    private String nationality;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference // "Managed" bedeutet: Zeig mir die Antworten
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    @JsonManagedReference// "Managed" bedeutet: Zeig mir die Fragen
    private List<Question> questions = new ArrayList<>();




    public Category(){

    }


    public Category( Integer id, String name, String team, String position, String nationality) {
        this.id = id;
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


    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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


}
