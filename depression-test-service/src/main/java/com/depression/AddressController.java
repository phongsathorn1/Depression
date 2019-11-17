package com.depression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AddressController {
    private QuestionsFactory questionsFactory = new QuestionsFactory();

    @GetMapping("/")
    public String index() {
        return "Depression Test Service";
    }

    @GetMapping("/questions")
    public ArrayList<Question> getQuestions() {
        return questionsFactory.getQuestions();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestionByID(@PathVariable int id) {
        return questionsFactory.getQuestionByID(id);
    }

    @PostMapping("/interpretation")
    public Interpretation getInterpretation(@RequestBody Answers answers) {
        Interpretation interpretation = new Interpretation();
        for (Answer answer : answers.getAnswers()) {
            interpretation.addTotalScore(answer.getSelectedChoice());
        }
        return interpretation;
    }

}