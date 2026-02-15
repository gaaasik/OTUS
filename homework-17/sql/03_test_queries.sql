-- Запросы для проверки работоспособности БД

-- 1. Все вопросы
SELECT * FROM questions;

-- 2. Все ответы
SELECT * FROM answers;

-- 3. Вопросы с их ответами
SELECT 
    q.question_text,
    a.answer_text,
    a.is_correct
FROM questions q
JOIN answers a ON q.id = a.question_id;

-- 4. Только правильные ответы
SELECT 
    q.question_text,
    a.answer_text
FROM questions q
JOIN answers a ON q.id = a.question_id
WHERE a.is_correct = TRUE;
