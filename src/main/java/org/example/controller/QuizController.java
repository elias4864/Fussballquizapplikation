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


    /**  Kontrollilert das QuestionRepostory und ladet alle bentöig Methoden für di ANser ujd Question Tabelle
     * Dependency Incjection
     */
    private final QuestionRepository questionRepository;
    //Kontrolliert das AnswerRepository
    private final AnswerRepository answerRepository;

    /**
     * KOnstruktor der QuizController KLasse
     * @param questionRepository
     * @param answerRepository
     */
    public QuizController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }


    /**
     * Gibt eine Liste Questions mti allen Fragen der Datenbank wird ausgegeben
     *
     * @return questions alle Fragen
     *
     *
     * */

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }




    /**
     * Speichert eine neue Antwort eines Spielers in der Datenbank ab
     * @param
     * @retun
     */


    @GetMapping("/questions/{questionId}/answers")
    public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable Integer questionId) {
        List<Answer> answers = answerRepository.findAll().stream()
                .filter(a -> a.getQuestion() != null && a.getQuestion().getId().equals(questionId))
                .toList();
        return ResponseEntity.ok(answers);
    }
}
