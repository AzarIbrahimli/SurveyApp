package az.rest.spring.demo.surveyapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "question_id", nullable = false, unique = true)
    private Integer questionID;

    @Column(name = "body")
    private String body;

}