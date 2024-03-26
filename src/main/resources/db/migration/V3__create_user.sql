CREATE TABLE user
(
    id       INT          NOT NULL,
    name     VARCHAR(45)  NOT NULL,
    surname  VARCHAR(60)  NOT NULL,
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    `role`   SMALLINT     NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);