package org.example.controller;


import org.example.model.Question;
import org.example.model.Answer;
import org.example.repository.QuestionRepository;
import org.example.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Gehirn für die Web-Anfragen  welche alle Anfagen anzeigt udn starte ein neues Quiz
 */
import java.util.ArrayList;
import java.util.List;

/**
 * The type Quiz controller.
 */
@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:5173")

public class QuizController {


    /**  Kontrollilert das QuestionRepostory und ladet alle bentöig Methoden für di ANser ujd Question Tabelle
     * Dependency Incjection
     */
    private final QuestionRepository questionRepository;
    //Kontrolliert das AnswerRepository
    private final AnswerRepository answerRepository;

    /**
     * KOnstruktor der QuizController KLasse
     *
     * @param questionRepository the question repository
     * @param answerRepository   the answer repository
     */
    public QuizController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }





    /**
     * Speichert eine neue Antwort eines Spielers in der Datenbank anhand des Attributs quetsstio
     * @param questionId
     * @return List Answe gibt gefilterte Fragen welche dies Id entsprechen zurück und fügt sie zu einer neuen Liste hinzu
     */


    /**
     * Alle ANtowrtne zu eienr bestimet Frage werden angezeiut und ein Stream wird erzeugt der alle Antowrten welche zu einer Frage anhan der questionId gehören gefoltert werden un dzu der neune LIset hinzufgüt werde un diese Aufgegebn werdi im ReponseBody
     *
     * @param questionId the question id
     * @return List answers der Entitität Answer mit gefilterten Frage we
     */
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable Integer questionId) {
        List<Answer> answers = answerRepository.findAll().stream()
                .filter(a -> a.getQuestion() != null && a.getQuestion().getId().equals(questionId))
                .toList();
        return ResponseEntity.ok(answers);
    }


    /**
     * GIbt in eienr Liste die allen möglichen Antworten an ewlcher zu eienr bestimmten Id gehören
     *
     * @param id the id
     * @return Liste mit Antworten aus den mögliche Antworteen welche inm Question Kosnturktor  abgebilern Atribut der Atnworten zu einer  neu e Liste erstel wird und dies Atrivuet   hinzgefüt werdne und dan im Body asugegebn werden
     */
    @GetMapping("/options/{id}")
    public ResponseEntity<List<String>> getAnswerOptions(@PathVariable Integer id) {
        return questionRepository.findById(id)
                .map(q -> {
                    List<String> options = new ArrayList<>();
                    options.add("Korrekte Antwort:"+""+q.getCorrectAnswer());
                    options.add("Falsche Antwort:"+""+q.getWrong_answer1());
                    options.add("Falsche Antwort"+""+q.getWrong_answer2());
                    options.add("Falsche Antwort"+""+q.getWrong_answer3());


                    return ResponseEntity.ok(options);
                }).orElse(ResponseEntity.notFound().build());

    }


}
