package org.example.controller;

import org.example.model.Answer;
import org.example.model.Team;
import org.example.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.Arrays.stream;

/**
 * The type Answer controller.
 */
@RestController
@RequestMapping("/answers")
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
     * Filtert alle  Datensätze aus der Answer List  basierend auf der Id der zugehörigen Frage und füg
     * @param id
     * @return Alle Datensätze welche eine zugehörigen Frage anhand der Id angehören werden durch mit einem Stream gefiltert und mit eien Lamda Expression abefragt ob sie eine bestimtem Id entsprechen und dann zu einer neuen Liste hinzugefügt
     */


    /**
     * ALle möglichen Antworten der Datenbank werden mit der Meethoden von JPA vordefinierten Methdoe findALl ausgegeben
     *
     * @return List Answer mit allen Antworten
     */
    @GetMapping("/allanswers")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }


    /**
     * Gibt das zugehörige Team einer bestimmten Antwort zurück dafür wird ein neue ANswer Objet vom Ansew Servic initialisier tmit der vim Sevci definerit methode  geAnswerById welc zu eien m Tema die  Frage eanhand der Id sucht
     * @param answerId Die ID der Antwort
     * @return Das Team-Objekt, zu dem die Antwort gehört
     */








}
