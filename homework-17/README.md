# Homework 17 - Проектирование схемы базы данных для тестов

## Описание

Схема базы данных для хранения тестов с вопросами и вариантами ответов.

Реализовано 2 варианта:
1. **Один тест** (базовый вариант)
2. **Несколько тестов** (опциональный вариант)

---

## Вариант 1: Один тест

### Структура таблиц:

**questions** (вопросы)
- `id` — первичный ключ
- `question_text` — текст вопроса
- `created_at` — дата создания

**answers** (варианты ответов)
- `id` — первичный ключ
- `question_id` — внешний ключ на questions
- `answer_text` — текст ответа
- `is_correct` — правильный ли ответ (TRUE/FALSE)
- `created_at` — дата создания

### Файлы:

- `01_create_single_test_schema.sql` — создание таблиц
- `02_insert_test_data.sql` — тестовые данные
- `03_test_queries.sql` — примеры запросов для проверки

---

## Вариант 2: Несколько тестов (опционально)

### Структура таблиц:

**tests** (тесты)
- `id` — первичный ключ
- `title` — название теста
- `description` — описание теста
- `created_at` — дата создания

**questions_multi** (вопросы)
- `id` — первичный ключ
- `test_id` — внешний ключ на tests
- `question_text` — текст вопроса
- `created_at` — дата создания

**answers_multi** (варианты ответов)
- `id` — первичный ключ
- `question_id` — внешний ключ на questions_multi
- `answer_text` — текст ответа
- `is_correct` — правильный ли ответ (TRUE/FALSE)
- `created_at` — дата создания

### Файлы:

- `04_create_multi_test_schema.sql` — создание таблиц
- `05_insert_multi_test_data.sql` — тестовые данные

---

## Установка и запуск

### 1. Установка PostgreSQL (если еще не установлен)

```bash
sudo apt update
sudo apt install postgresql postgresql-contrib
```

### 2. Запуск PostgreSQL

```bash
sudo service postgresql start
```

### 3. Подключение к PostgreSQL

```bash
sudo -u postgres psql
```

### 4. Создание базы данных

```sql
CREATE DATABASE test_db;
\c test_db
```

### 5. Выполнение скриптов

#### Вариант 1 (один тест):

```sql
\i /home/daniil/PycharmProjects/OTUS/cursor_otus/homework-17/sql/01_create_single_test_schema.sql
\i /home/daniil/PycharmProjects/OTUS/cursor_otus/homework-17/sql/02_insert_test_data.sql
\i /home/daniil/PycharmProjects/OTUS/cursor_otus/homework-17/sql/03_test_queries.sql
```

#### Вариант 2 (несколько тестов):

```sql
\i /home/daniil/PycharmProjects/OTUS/cursor_otus/homework-17/sql/04_create_multi_test_schema.sql
\i /home/daniil/PycharmProjects/OTUS/cursor_otus/homework-17/sql/05_insert_multi_test_data.sql
```

---

## Проверка работоспособности

### Вариант 1:

```sql
-- Все вопросы
SELECT * FROM questions;

-- Вопросы с ответами
SELECT 
    q.question_text,
    a.answer_text,
    a.is_correct
FROM questions q
JOIN answers a ON q.id = a.question_id;

-- Только правильные ответы
SELECT 
    q.question_text,
    a.answer_text
FROM questions q
JOIN answers a ON q.id = a.question_id
WHERE a.is_correct = TRUE;
```

### Вариант 2:

```sql
-- Все тесты
SELECT * FROM tests;

-- Все вопросы конкретного теста
SELECT * FROM questions_multi WHERE test_id = 1;

-- Вопросы с ответами для теста
SELECT 
    t.title,
    q.question_text,
    a.answer_text,
    a.is_correct
FROM tests t
JOIN questions_multi q ON t.id = q.test_id
JOIN answers_multi a ON q.id = a.question_id
WHERE t.id = 1;
```

---

## Особенности реализации

✅ Использованы `SERIAL` для автоинкремента ID  
✅ Внешние ключи с `ON DELETE CASCADE` (при удалении вопроса удаляются его ответы)  
✅ Индексы для ускорения поиска  
✅ Комментарии к таблицам и полям  
✅ Проверка: у каждого вопроса от 2 до 5 вариантов ответа  
✅ Проверка: у каждого вопроса есть хотя бы один правильный ответ  

---

## Диаграмма БД (Вариант 2)

```
tests
  └─── questions_multi
         └─── answers_multi
```

---

## Критерии оценки

✅ Разработана структура БД для хранения теста  
✅ Тест состоит из вопросов с 2-5 вариантами ответа  
✅ Один вариант правильный  
✅ Набор DDL скриптов создан  
✅ (Опционально) Структура для нескольких тестов  

**Статус: Готово к сдаче!** 🎯
