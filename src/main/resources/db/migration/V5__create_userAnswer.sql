CREATE TABLE user_answer
(
    id                   INT AUTO_INCREMENT NOT NULL,
    user_id              INT NOT NULL,
    question_id          INT NOT NULL,
    answer_id            INT NULL,
    open_question_answer TEXT NULL,
    CONSTRAINT pk_user_answer PRIMARY KEY (id)
);

ALTER TABLE answer
    MODIFY question_id INT NOT NULL;