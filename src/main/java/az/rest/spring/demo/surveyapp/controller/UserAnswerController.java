package az.rest.spring.demo.surveyapp.controller;


import az.rest.spring.demo.surveyapp.rest.model.dto.UserAnswerDto;
import az.rest.spring.demo.surveyapp.rest.model.response.UserAnswerResponse;
import az.rest.spring.demo.surveyapp.service.impl.UserAnswerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAnswer")
@RequiredArgsConstructor
public class UserAnswerController {
    private final UserAnswerServiceImpl userAnswerService;


    @GetMapping
    public UserAnswerResponse getAll() {
        return userAnswerService.getAll();
    }

    @GetMapping("/{id}")
    public UserAnswerDto getUserAnswerById(@PathVariable("id") int id) {
        return userAnswerService.getUserAnswerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody UserAnswerDto userAnswerDto) {
        userAnswerService.insert(userAnswerDto);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody UserAnswerDto userAnswerDto) {
        userAnswerService.update(id, userAnswerDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        userAnswerService.deleteUserAnswerById(id);
    }
}
