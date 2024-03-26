package az.rest.spring.demo.surveyapp.controller;

import az.rest.spring.demo.surveyapp.rest.model.dto.AnswerDto;
import az.rest.spring.demo.surveyapp.rest.model.response.AnswerResponse;
import az.rest.spring.demo.surveyapp.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;


    @GetMapping
    public AnswerResponse getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public AnswerDto getAnswerById(@PathVariable("id") int id) {
        return answerService.getAnswerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertAnswer(@RequestBody AnswerDto answerDto) {
        answerService.insertAnswer(answerDto);
    }

    @PatchMapping("/{id}")
    public void updateAnswer(@PathVariable("id") int id, @RequestBody AnswerDto answerDto) {
        answerService.updateAnswer(id, answerDto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswerById(@PathVariable int id) {
        answerService.deleteAnswerById(id);
    }
}
