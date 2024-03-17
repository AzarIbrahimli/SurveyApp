package az.rest.spring.demo.surveyapp.service;

import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;

public interface QuestionService {
    QuestionResponse getAll();
    QuestionDto getQuestionById(long id);
    void insert(QuestionDto questionDto);
    void updateSome(long id, QuestionDto questionDto);
    void updateAll(long id, QuestionDto questionDto);
    void deleteById(long id);
}
