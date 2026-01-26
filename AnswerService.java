package org.example.service;

import org.example.model.Answer;
import org.example.repository.AnswerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * The type Answer service.
 */
@Service
public class AnswerService {

    /**
     * Service-Klasse für die Verwaltung von Antworten (Answers).
     * Diese Klasse enthält die Geschäftslogik und dient als Schnittstelle
     * zwischen dem AnswerController und dem AnswerRepository.
     *
     */

    private final AnswerRepository answerRepository;

    /**
     * Instantiates a new Answer service.
     *
     * @param answerRepository the answer repository
     */
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    /**
     * Gets all answers.
     *
     * @return the all answers
     */
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    /**
     * Gets answers for question.
     *
     * @param questionId the question id
     * @return the answers for question
     */
    public List<Answer> getAnswersForQuestion(int questionId) {
        return answerRepository.findAll()
                .stream()
                .filter(a -> a.getQuestion() != null
                        && a.getQuestion().getCorrectAnswer() != null
                        && a.getId() == questionId)
                .toList();
    }


    /**
     * Gets answer by id.
     *
     * @param id the id
     * @return the answer by id
     */
    public Answer getAnswerById(Integer id) {
        return answerRepository.findById(id).orElse(null);
    }


    /**
     * Add answer der Answer Liste answer.
     *
     * @param a the a
     * @return the answer
     */
    public Answer addAnswer(Answer a) {
        return answerRepository.save(a);
    }

    /**
     * Delete an answeranswer.
     *
     * @param id the id
     */
    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }
}
