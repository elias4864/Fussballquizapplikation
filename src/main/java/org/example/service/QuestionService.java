package org.example.service;

import org.example.model.Question;
import org.example.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service-Klasse für die Geschäftslogik der Quiz-Fragen.
 * Diese Schicht dient als Vermittler zwischen dem Controller (API) und dem Repository (Datenbank).
 */
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    /**
     * Konstruktor-basierte Dependency Injection des QuestionRepositories.
     * Spring reicht die passende Implementierung automatisch hinein.
     */
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * Ruft alle Fragen aus der Datenbank ab.
     * @return Liste aller Fragen.
     */
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    /**
     * Sucht eine spezifische Frage anhand ihrer ID.
     * @param id Die ID der Frage.
     * @return Die Frage oder null, falls nicht gefunden.
     */
    public Question getQuestion(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    /**
     * Speichert eine neue Frage oder aktualisiert eine bestehende.
     * @param q Das Frage-Objekt.
     * @return Die gespeicherte Frage.
     */
    public Question addQuestion(Question q) {
        return questionRepository.save(q);
    }

    /**
     * Löscht eine Frage anhand ihrer ID.
     * @param id Die ID der zu löschenden Frage.
     */
    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    /**
     * Erstellt ein Quiz mit einer zufälligen Auswahl an Fragen.
     * @param amount Anzahl der gewünschten Fragen.
     * @return Liste zufälliger Fragen.
     */
    public List<Question> getRandomQuiz(int amount) {
        return questionRepository.findRandomQuestions(amount);
    }
}