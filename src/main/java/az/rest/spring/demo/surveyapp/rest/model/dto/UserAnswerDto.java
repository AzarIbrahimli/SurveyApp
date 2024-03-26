package az.rest.spring.demo.surveyapp.rest.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAnswerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  Integer userID;
    private  Integer questionID;
    private  Integer answerID;
    private  String openQuestionAnswer;
}