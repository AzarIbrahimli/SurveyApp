package az.rest.spring.demo.surveyapp.repository;

import az.rest.spring.demo.surveyapp.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
}