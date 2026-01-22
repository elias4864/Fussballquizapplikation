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

    @Autowired
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }



    @GetMapping("/allanswers")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }




    @GetMapping("/question/{id}")
    public List<Answer> getAnswersByQuestion(@PathVariable Integer question_id) {
        // Falls du eine Methode im Repository definierst:
        // return answerRepository.findByQuestionId(questionId);
        return answerService.getAnswersForQuestion(question_id).stream()
                .filter(a -> a.getQuestion().getId().equals(question_id))
                .toList();
    }

    @PutMapping("/addanswer")
    public Answer addAnswer(@RequestBody Answer answer) {
        return answerService.addAnswer(answer);
    }


}
