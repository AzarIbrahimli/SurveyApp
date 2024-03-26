package az.rest.spring.demo.surveyapp.repository;

import az.rest.spring.demo.surveyapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}