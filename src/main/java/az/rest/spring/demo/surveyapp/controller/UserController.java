package az.rest.spring.demo.surveyapp.controller;

import az.rest.spring.demo.surveyapp.rest.model.dto.UserDto;
import az.rest.spring.demo.surveyapp.rest.model.response.UserResponse;
import az.rest.spring.demo.surveyapp.service.UserService;
import az.rest.spring.demo.surveyapp.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public UserResponse getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void insertUser(@RequestBody UserDto userDto) {
        userService.insertUser(userDto);
    }


    @PatchMapping("/{id}")
    public void updateSome(@PathVariable int id, @RequestBody UserDto userDto) {
        userService.updateSome(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
