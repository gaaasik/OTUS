-- Создание таблицы тестов
CREATE TABLE tests (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT
);

-- Создание таблицы вопросов
CREATE TABLE questions_multi (
    id SERIAL PRIMARY KEY,
    test_id INTEGER NOT NULL,
    question_text TEXT NOT NULL,
    FOREIGN KEY (test_id) REFERENCES tests(id)
);

-- Создание таблицы вариантов ответов
CREATE TABLE answers_multi (
    id SERIAL PRIMARY KEY,
    question_id INTEGER NOT NULL,
    answer_text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    FOREIGN KEY (question_id) REFERENCES questions_multi(id)
);
