package org.example.controller;

import org.example.model.Answer;
import org.example.model.Team;
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
     * Konstruktor mit Dependency Injections für Verknüpfung von Repository und Service Komponenten
     */
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }



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

    @GetMapping("/question/{id}")
    public List<Answer> getAnswersByQuestion(@PathVariable Integer id) {
        // Die Liste enthält automatisch 1 korrekte und 3 falsche Antworten
        return answerService.getAnswersForQuestion(id);
    }

    /**
     * ALle möglichen Antworten der Datenbank werden mit der Meethoden von JPA vordefinierten Methdoe findALl ausgegeben
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

    @GetMapping("/team/{answerId}")
    public Team getTeamByAnswerId(@PathVariable Integer answerId) {
        Answer answer = answerService.getAnswerById(answerId);
        if (answer != null && answer.getTeam() != null) {
            return answer.getTeam();
        }
        return null;
    }







}
