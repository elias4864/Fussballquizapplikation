package org.example.service;

import org.example.model.Answer;
import org.example.repository.AnswerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnswerService {

    /**
     * Service-Klasse für die Verwaltung von Antworten (Answers).
     * Diese Klasse enthält die Geschäftslogik und dient als Schnittstelle
     * zwischen dem AnswerController und dem AnswerRepository.
     *
     */

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public List<Answer> getAnswersForQuestion(int questionId) {
        return answerRepository.findAll()
                .stream()
                .filter(a -> a.getQuestion() != null
                        && a.getQuestion().getCorrectAnswer() != null
                        && a.getId() == questionId)
                .toList();
    }



    public Answer addAnswer(Answer a) {
        return answerRepository.save(a);
    }

    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }
}
