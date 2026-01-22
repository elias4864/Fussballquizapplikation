package org.example.controller;

import org.example.model.Answer;
import org.example.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }



    @GetMapping("/allanswers")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/question/{id}")
    public List<Answer> getAnswersForQuestion(@PathVariable int id) {
        return answerService.getAnswersForQuestion(id);
    }

    @PostMapping("/addanswer")
    public Answer addAnswer(@RequestBody Answer answer) {
        return answerService.addAnswer(answer);
    }


}
