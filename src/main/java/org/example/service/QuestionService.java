package org.example.service;

import org.example.model.Question;

import org.example.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class QuestionService {

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
