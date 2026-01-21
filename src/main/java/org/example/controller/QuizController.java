package org.example.controller;


import org.example.model.Question;
import org.example.model.Answer;
import org.example.repository.QuestionRepository;
import org.example.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public QuizController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }


    /**
     * Gibt alle Fragen aus der Datenbank zurück.
     */
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    /**
     * Gibt eine spezifische Frage anhand der ID zurück.

    /**
     * Speichert eine neue Antwort eines Spielers in der Datenbank.
     */
    @PostMapping("/answers")
    public Answer submitAnswer(@RequestBody Answer answer) {
        return answerRepository.save(answer);
    }

    /**
     * Erstellt eine neue Frage (z.B. für einen Admin-Bereich).
     */
    @PostMapping("/questions")
    public Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

}
