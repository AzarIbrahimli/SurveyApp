package az.rest.spring.demo.surveyapp.controller;

import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;
import az.rest.spring.demo.surveyapp.service.impl.QuestionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    QuestionServiceImpl questionService;

    @GetMapping
    public QuestionResponse getAll(){
        return questionService.getAll();
    }
}
