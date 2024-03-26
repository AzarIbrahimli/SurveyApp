CREATE TABLE answer
(
    id          INT AUTO_INCREMENT NOT NULL,
    question_id INT NOT NULL,
    body        VARCHAR(255) NULL,
    CONSTRAINT pk_answer PRIMARY KEY (id)
);

ALTER TABLE answer
    ADD CONSTRAINT uc_answer_question UNIQUE (question_id);