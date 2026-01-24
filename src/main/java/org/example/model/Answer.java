package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "answer")
@AllArgsConstructor // Erstellt Konstruktor für alle Felder
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
    @JsonBackReference
    private Question question;


    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "category-answer")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonBackReference// WICHTIG: Verhindert, dass die Antwort den Spieler erneut lädt
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id")
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



