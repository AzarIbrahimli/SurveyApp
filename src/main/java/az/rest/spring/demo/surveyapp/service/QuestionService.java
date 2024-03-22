package az.rest.spring.demo.surveyapp.service;

import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;

public interface QuestionService {
    QuestionResponse getAll();
    QuestionDto getQuestionById(int id);
    void insert(QuestionDto questionDto);
    void updateSome(int id, QuestionDto questionDto);
    void updateAll(int id, QuestionDto questionDto);
    void deleteById(int id);
}
