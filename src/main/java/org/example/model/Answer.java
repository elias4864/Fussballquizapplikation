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

    @Column(name = "answer_text", nullable = false, length = 300)
    private String answerText;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    @JsonBackReference
    private Question question;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Standard-Konstruktor
    public Answer() {}


    // Getter & Setter
    public Integer getId() { return id; }
    public String getAnswerText() { return answerText; }
    public void setAnswerText(String answerText) { this.answerText = answerText; }
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}
