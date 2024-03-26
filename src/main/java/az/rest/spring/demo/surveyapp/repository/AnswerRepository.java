package az.rest.spring.demo.surveyapp.repository;

import az.rest.spring.demo.surveyapp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}