package az.rest.spring.demo.surveyapp.service.impl;

import az.rest.spring.demo.surveyapp.model.User;
import az.rest.spring.demo.surveyapp.repository.UserRepository;
import az.rest.spring.demo.surveyapp.rest.model.dto.UserDto;
import az.rest.spring.demo.surveyapp.rest.model.response.UserResponse;
import az.rest.spring.demo.surveyapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse getAllUsers() {
        List<UserDto> users = userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return makeUserResponse(users);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        return convertToDto(user);
    }

    @Override
    public void insertUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.save(user);
    }

    @Override
    public void updateSome(int id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow();

        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getSurname() != null) {
            user.setSurname(userDto.getSurname());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }
        if (userDto.getRole() != null) {
            user.setRole(userDto.getRole());
        }
        userRepository.save(user);
    }


    @Override
    public void deleteUserById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public UserResponse makeUserResponse(List<UserDto> userDtos) {
        return UserResponse.builder()
                .users(userDtos)
                .build();
    }
}
