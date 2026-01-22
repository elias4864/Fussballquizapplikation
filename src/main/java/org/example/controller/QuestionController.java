package org.example.controller;


import org.example.model.Question;
import org.example.repository.QuestionRepository;
import org.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/questions")
public class QuestionController {



    @Autowired
    private QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // GET: Alle Fragen abrufen
    @GetMapping("/allquestions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    /**
     * Bestimmte Frage nach  ID abfragen
     *
     * @return
     */
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        // Jetzt ist questionRepository nicht mehr null
        return questionRepository.findById(id).orElse(null);
    }

    @PutMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }


    /**
     * Neue Fragen hinzufügen
     */



    /**
     *
     *
     */
    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        // void, da delete keinen Rückgabewert hat
        questionRepository.deleteById(id);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }






    }

