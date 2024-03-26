package az.rest.spring.demo.surveyapp.service;

import az.rest.spring.demo.surveyapp.model.UserAnswer;
import az.rest.spring.demo.surveyapp.rest.model.dto.UserAnswerDto;
import az.rest.spring.demo.surveyapp.rest.model.response.UserAnswerResponse;

public interface UserAnswerService {
    UserAnswerResponse getAll();
    UserAnswerDto getUserAnswerById(int id);
    void insert(UserAnswerDto userAnswerDto);
    void update(int id, UserAnswerDto userAnswerDto);
    void deleteUserAnswerById(int id);
}
