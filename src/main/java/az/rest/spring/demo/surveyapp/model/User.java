package az.rest.spring.demo.surveyapp.model;

import az.rest.spring.demo.surveyapp.enums.QuestionType;
import az.rest.spring.demo.surveyapp.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name", length = 45)
    private String name;

    @NotNull
    @Column(name = "surname", length = 60)
    private String surname;

    @NotNull
    @Column(name = "email", length = 100)
    private String email;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Enumerated
    Roles role;

}