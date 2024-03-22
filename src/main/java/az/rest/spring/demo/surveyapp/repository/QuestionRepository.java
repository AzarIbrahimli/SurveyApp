package az.rest.spring.demo.surveyapp.repository;

import az.rest.spring.demo.surveyapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
