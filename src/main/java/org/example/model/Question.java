package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;

    @Column(name = "wrong_answer1")
    private String wronganswer1;

    @Column(name = "wrong_answer2")
    private String wronganswer2;

    @Column(name = "wrong_answer3")
    private String wronganswer3;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; // <--- Dieser Name muss mit 'mappedBy' übereinstimmen!
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Answer> answers = new ArrayList<>();

    public enum Difficulty { leicht, mittel, schwer }

    // Standard-Konstruktor (für JPA)
    public Question() {}

    // Konstruktor für deine Logik
    public Question(String question, String correctAnswer, String wronganswer1, String wronganswer2, String wronganswer3, Difficulty difficulty, Category category) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wronganswer1 = wronganswer1;
        this.wronganswer2 = wronganswer2;
        this.wronganswer3 = wronganswer3;
        this.difficulty = difficulty;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getId() {
        return id;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    public String getWronganswer1() {
        return wronganswer1;
    }

    public void setWronganswer1(String wronganswer1) {
        this.wronganswer1 = wronganswer1;
    }

    public String getWronganswer2() {
        return wronganswer2;
    }

    public void setWronganswer2(String wronganswer2) {
        this.wronganswer2 = wronganswer2;
    }

    public String getWronganswer3() {
        return wronganswer3;
    }

    public void setwronganswer3(String wronganswer3) {
        this.wronganswer3 = wronganswer3;
    }
}



