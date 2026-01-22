package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "answer")
@AllArgsConstructor // Erstellt Konstruktor für alle Felder
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;


    @OneToOne
    @JoinColumn(name = "category_id") // Dies erzeugt die Spalte category_id in der Tabelle answer
    @JsonBackReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonBackReference // Korrekt: Player ist "Elternteil"
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id") // Verweist auf team(id) in der DB
    private Team team;


    @ManyToOne
    @JoinColumn(name = "league_id",columnDefinition = "VARCHAR(10)")
    private League league;


    // Standard-Konstruktor
    public Answer() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}



