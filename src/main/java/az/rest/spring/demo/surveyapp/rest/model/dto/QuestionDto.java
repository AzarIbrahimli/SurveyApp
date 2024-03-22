package az.rest.spring.demo.surveyapp.rest.model.dto;

import az.rest.spring.demo.surveyapp.enums.QuestionType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String body;
    QuestionType type;
}
