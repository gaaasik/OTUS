-- Тестовые данные для нескольких тестов

-- Тест 1: Java Basic
INSERT INTO tests (title, description) VALUES 
('Java Basic', 'Базовые вопросы по Java');

INSERT INTO questions_multi (test_id, question_text) VALUES 
(1, 'Какой язык программирования используется для backend разработки?'),
(1, 'Что такое JVM?');

INSERT INTO answers_multi (question_id, answer_text, is_correct) VALUES 
(1, 'HTML', FALSE),
(1, 'Java', TRUE),
(1, 'CSS', FALSE);

INSERT INTO answers_multi (question_id, answer_text, is_correct) VALUES 
(2, 'Java Virtual Machine', TRUE),
(2, 'Java Variable Method', FALSE);

-- Тест 2: SQL Basic
INSERT INTO tests (title, description) VALUES 
('SQL Basic', 'Базовые вопросы по SQL');

INSERT INTO questions_multi (test_id, question_text) VALUES 
(2, 'Что означает SQL?'),
(2, 'Какая команда используется для выборки данных?');

INSERT INTO answers_multi (question_id, answer_text, is_correct) VALUES 
(3, 'Structured Query Language', TRUE),
(3, 'Simple Question Language', FALSE);

INSERT INTO answers_multi (question_id, answer_text, is_correct) VALUES 
(4, 'GET', FALSE),
(4, 'SELECT', TRUE),
(4, 'FETCH', FALSE);
