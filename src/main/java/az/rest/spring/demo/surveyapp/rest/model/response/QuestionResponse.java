package az.rest.spring.demo.surveyapp.rest.model.response;

import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    List<QuestionDto> questions;
}
