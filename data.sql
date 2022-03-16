INSERT INTO todo_list (name, creation_date)
VALUES ('todo professional', NOW()),
                       ('todo Morgan', NOW()),
                       ('todo Harris', NOW()),
                       ('todo Bryan', NOW()),
                       ('todo Rhodes', NOW());

INSERT INTO todo (label, done, creation_date, todo_list_id)
VALUES ('task1', FALSE, NOW(), 1),
       ('task2', TRUE, NOW(), 1),
       ('task3', FALSE, NOW(), 2),
       ('task4', FALSE, NOW(), 4),
       ('task5', TRUE, NOW(), 3);