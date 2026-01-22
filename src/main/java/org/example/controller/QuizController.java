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


    /**  Kontrollilert das QuestionRepostory
     *
     */
    private final QuestionRepository questionRepository;
    //Kontrolliert das AnswerRepository
    private final AnswerRepository answerRepository;

        //Quiz KOntroller KOnstruktor
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
     * Speichert eine neue Antwort eines Spielers in der Datenbank ab.
     */
    @PostMapping("/answers")
    public Answer submitAnswer(@RequestBody Answer answer) {
        return answerRepository.save(answer);
    }

    /**
     * Erstellt eine neue Frage (z.B. für einen Admin-Bereich).
     */
    @GetMapping("/questions/{questionId}/answers")
    public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable Integer questionId) {
        List<Answer> answers = answerRepository.findAll().stream()
                .filter(a -> a.getQuestion() != null && a.getQuestion().getId().equals(questionId))
                .toList();
        return ResponseEntity.ok(answers);
    }
}
