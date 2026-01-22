package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {


    /**
     * Auto generiertes Attribut id, damit Datn automatisch geladen werden
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

    //One to Many Beziehung eien Kategorie hat mehrere Fragen
        @OneToOne(mappedBy = "category")
       private Question question;


    @OneToOne(mappedBy = "category") // 'category' ist der Feldname in der Klasse Answer
    @JsonManagedReference
    private Answer answer;



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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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
