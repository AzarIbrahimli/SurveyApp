package az.rest.spring.demo.surveyapp.rest.model.response;

import az.rest.spring.demo.surveyapp.rest.model.dto.AnswerDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponse {
    List<AnswerDto> answers;
}
