package org.example.controller;


import org.example.model.Answer;
import org.example.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * The type Answer controller.
 */
@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "http://localhost:5173")

public class AnswerController {


    /**
     * AnswerService der alle Methoden  fpr die AnswerController initialisiert
     */
    private final AnswerService answerService;

    /**
     * Konstruktor mit Dependency Injections für Verknüpfung von Repository und Service Komponenten
     *
     * @param answerService the answer service
     */
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }


    /**
     * Zu einer Antowrten liste erhält man  bestimmte Answeroptionen welche mit dem  Parameter Integer  und questionId übergeben werden mit einem Stram der alle Fragen ewlche eienr Id entsprehcen abfragt
     *
     * @param questionId the question id
     * @return List Answer
     */
    @GetMapping("/question/options/{questionId}")
    public List<Answer> getAnswerOptions(@PathVariable Integer questionId) {
        // Wir holen alle Antworten vom Service und filtern sie
        return answerService.getAnswersForQuestion(questionId).stream()
                .filter(a -> a.getQuestion() != null && a.getQuestion().getId().equals(questionId))
                .toList();
    }


    /**
     * ALle möglichen Antworten der Datenbank werden mit der Methoden von JPA vordefinierten Methdoe findALl ausgegeben
     *
     * @return List Answer mit allen Antworten
     */
    @GetMapping("/allanswers")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }









}
