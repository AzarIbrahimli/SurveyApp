package az.rest.spring.demo.surveyapp.service;

import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import az.rest.spring.demo.surveyapp.rest.model.dto.UserDto;
import az.rest.spring.demo.surveyapp.rest.model.response.UserResponse;

public interface UserService {
    UserResponse getAllUsers();
    UserDto getUserById(int id);
    void insertUser(UserDto userDto);
    void updateSome(int id, UserDto userDto);
    void deleteUserById(int id);
}
