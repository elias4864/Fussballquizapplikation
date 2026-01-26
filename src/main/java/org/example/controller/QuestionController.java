package org.example.controller;


import org.example.model.Answer;
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


/**
 * The type Question controller.
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {


    /**
     * ALle für die COntroller benötigten Methoden der Question Liste und Abhängigkeiten  für die HTTP Request werden initialisiert
     * Dependency Injections zu Questionrepository
     * Fragenverwaltung
     */
    private final QuestionRepository questionRepository;


    /**
     * KOnstruktor der Questioncontroller Klasse mit Dependency Injeciton zum Repository
     *
     * @param questionRepository the question repository
     */
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * Alle  vorhandenen Fragen der Questions Liste werden abgefragt und die  von JPA vordefinierten  Methode findALl  aufgerufen
     *
     * @return List Question mit allen Fragen wird ausgegeben
     */
    @GetMapping("/allquestions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    /**
     * Eine Frage wird anhand des Primary key id der Frage gelöscht mit der PathVariable id aus der Datenbank dauerhaft gelöscht
     *
     * @param id the id
     * @return Question
     */
    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        questionRepository.deleteById(id);
    }


    /**
     * Zufällige Fragen der Question Liste werden ausgegeben durch  mit einbem Defualt Wete von mindestens 10 Fragen mit der im Question Service initialisiertem Methode findRandomQuesitons
     *
     * @param size the size
     * @return LIst Questions mit zufälligen Fragen werden zurückgegeben
     */
    @GetMapping("/quiz")
    public List<Question> getQuiz(@RequestParam(defaultValue = "10") int size) {
        return questionRepository.findRandomQuestions(size);
    }






    }

