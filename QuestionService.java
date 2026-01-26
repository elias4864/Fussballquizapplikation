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
     * Finalisierter Service Controller
     */

    private final QuestionRepository questionRepository;

    /**
     * Instantiates a new Question service.
     *
     * @param questionRepository the question repository
     */
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    /**
     * Gets question.
     *
     * @param id the id
     * @return the question
     */
    public Question getQuestion(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    /**
     * Add question question.
     *
     * @param q the q
     * @return the question
     */
    public Question addQuestion(Question q) {
        return questionRepository.save(q);
    }

    /**
     * Delete question.
     *
     * @param id the id
     */
    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    /**
     * Gets random quiz.
     *
     * @param amount the amount
     * @return the random quiz
     */
    public List<Question> getRandomQuiz(int amount) {
        return questionRepository.findRandomQuestions(amount);
    }


}
