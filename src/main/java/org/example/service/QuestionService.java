package org.example.service;

import org.example.model.Question;

import org.example.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servie Klawse für die Gechäftslogik mit Servic ANnotation welche SPring darafu hinweis das es eien Srevice KLasse handelt
 */
@Service

public class QuestionService {

    /**Geschäftslogik welche die Verwaltun der Fragen  mit dne HTPT Requeste zuerst zur Repository SHcihts schickt welche die Methodn ausführt und danch zu der Servif welh die Daten auruft und die Methdo verknüpft  udn dann endgültig an den Question Cotnroller weiterschikt und dann an den Webserver der sie in JSOn FOrmat umwandelt
     * Dependency Injection der Question Repository  welche alle Methoden für die Frageliste welche zum QuestionCOntroller gehört initailisiert aufruft
     */

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question getQuestion(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question addQuestion(Question q) {
        return questionRepository.save(q);
    }

    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    public List<Question> getRandomQuiz(int amount) {
        return questionRepository.findRandomQuestions(amount);
    }
}
