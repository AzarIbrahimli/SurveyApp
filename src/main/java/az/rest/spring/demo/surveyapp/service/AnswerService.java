package az.rest.spring.demo.surveyapp.service;

import az.rest.spring.demo.surveyapp.rest.model.dto.AnswerDto;
import az.rest.spring.demo.surveyapp.rest.model.response.AnswerResponse;

public interface AnswerService {
    AnswerResponse getAllAnswers();
    AnswerDto getAnswerById(int id);
    void insertAnswer(AnswerDto answerDto);
    void updateAnswer(int id, AnswerDto answerDto);
    void deleteAnswerById(int id);
}
