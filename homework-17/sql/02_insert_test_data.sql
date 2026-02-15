-- Вставка тестовых данных

-- Вопрос 1
INSERT INTO questions (question_text) VALUES 
('Какой язык программирования используется для backend разработки?');

INSERT INTO answers (question_id, answer_text, is_correct) VALUES 
(1, 'HTML', FALSE),
(1, 'CSS', FALSE),
(1, 'Java', TRUE),
(1, 'Photoshop', FALSE);

-- Вопрос 2
INSERT INTO questions (question_text) VALUES 
('Что такое JVM?');

INSERT INTO answers (question_id, answer_text, is_correct) VALUES 
(2, 'Java Virtual Machine', TRUE),
(2, 'Java Variable Method', FALSE),
(2, 'Just Very Much', FALSE);

-- Вопрос 3
INSERT INTO questions (question_text) VALUES 
('Какой оператор используется для создания объекта в Java?');

INSERT INTO answers (question_id, answer_text, is_correct) VALUES 
(3, 'create', FALSE),
(3, 'new', TRUE),
(3, 'make', FALSE),
(3, 'init', FALSE),
(3, 'object', FALSE);
