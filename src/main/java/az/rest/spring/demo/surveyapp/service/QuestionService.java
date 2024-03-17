package az.rest.spring.demo.surveyapp.service;

import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;

public interface QuestionService {
    QuestionResponse getAll();
}
