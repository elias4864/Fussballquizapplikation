package org.example.controller;

import org.example.model.Answer;
import org.example.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/answers")
public class AnswerController {


    /**
     * AnswerService der alle Methoden  fpr die AnswerController initialisiert
     */
    private final AnswerService answerService;

    /**
     * Konstruktor mit Dependency Incetion der zur  AnswerService
     */
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }




    @GetMapping("/allanswers")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }


    /**
     * Filtert alle  Datensätze aus der Answer List  basierend auf der Id der zugehörigen Frage und füg
     * @param id
     * @return Alle Datensätze welche eine zugehörigen Frage anhand der Id angehören werden durch mit einem Stream gefiltert und mit eien Lamda Expression abefragt ob sie eine bestimtem Id entsprechen und dann zu einer neuen Liste hinzugefügt
     */

    @GetMapping("/question/{id}")
    public List<Answer> getAnswersByQuestion(@PathVariable Integer id) {
        // Falls du eine Methode im Repository definierst:
        // return answerRepository.findByQuestionId(questionId);
        return answerService.getAnswersForQuestion(id).stream()
                .filter(a -> a.getQuestion().getId().equals(id))
                .toList();
    }


}
