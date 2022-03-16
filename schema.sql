CREATE TABLE todo_list
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255),
    creation_date TIMESTAMP,
    CONSTRAINT pk_todolist PRIMARY KEY (id)
);

CREATE TABLE todo
(
    id_todo       BIGINT NOT NULL,
    label         VARCHAR(255),
    done          BOOLEAN,
    creation_date TIMESTAMP,
    todo_list_id  BIGINT,
    CONSTRAINT pk_todo PRIMARY KEY (id_todo)
);

ALTER TABLE todo
    ADD CONSTRAINT FK_TODO_ON_TODOLIST FOREIGN KEY (todo_list_id) REFERENCES todo_list (id);