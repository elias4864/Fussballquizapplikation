package org.example.controller;


import org.example.model.Question;
import org.example.repository.QuestionRepository;
import org.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/questions")
public class QuestionController {


    /**
     * ALle für die COntroller benötigten Methoden der Question Liste und Abhängigkeiten werden initialisiert
     */
    private final QuestionRepository questionRepository;


    /**
     * KOnstruktor der Questioncontroller Klasse mit Dependency Injeciton zum Repository
     * @param questionRepository
     */
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * Alle Fragen der Questions Liste abfragen aus Datenbank
     *
     * @return List Question
     */

    @GetMapping("/allquestions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }




    /**
     * Filtert aus der Question Liste  anhand der  von JPA vordefinierten Methode getQuestionsById  mit einer bestimmten Id anhand des Primarykeys id mit Typ Integer
     *
     * @param id
     * @return Neue Liste Question welche anhand von zugehörigen id zurückgegeben wird
     */
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
        return questionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Neue Frage wird zur Questions Liste hinzugefügt
     * @param question
     * @return
     */




    /**
     *
     * @param  id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        // void, da delete keinen Rückgabewert hat
        questionRepository.deleteById(id);
    }


    @GetMapping("/quiz")
    public List<Question> getQuiz(@RequestParam(defaultValue = "10") int size) {
        return questionRepository.findRandomQuestions(size);
    }




    }

