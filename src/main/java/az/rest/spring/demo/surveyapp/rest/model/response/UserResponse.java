package az.rest.spring.demo.surveyapp.rest.model.response;

import az.rest.spring.demo.surveyapp.rest.model.dto.UserDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    List<UserDto> users;
}
