package az.rest.spring.demo.surveyapp.controller;

import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;
import az.rest.spring.demo.surveyapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public QuestionResponse getAll(){
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public QuestionDto getQuestionById(@PathVariable("id") int id){
        return questionService.getQuestionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody QuestionDto questionDto){
        questionService.insert(questionDto);
    }

    @PatchMapping("/{id}")
    public void updateSome(@PathVariable("id") int id, @RequestBody QuestionDto questionDto){
        questionService.updateSome(id, questionDto);
    }

    @PutMapping("/{id}")
    public void updateAll(@PathVariable("id") int id,@RequestBody QuestionDto questionDto){
        questionService.updateAll(id, questionDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        questionService.deleteById(id);
    }
}
