package az.rest.spring.demo.surveyapp.rest.model.dto;

import az.rest.spring.demo.surveyapp.enums.Roles;
import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto  {
    private  Integer id;
    private  String name;
    private  String surname;
    private  String email;
    private  String password;
    private  Roles role;
}