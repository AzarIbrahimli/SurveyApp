package az.rest.spring.demo.surveyapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_answer")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userID;

    @Column(name = "question_id", nullable = false)
    private Integer questionID;

    @Column(name = "answer_id")
    private Integer answerID;

    @Column(name = "open_question_answer", columnDefinition = "TEXT")
    private String openQuestionAnswer;

}