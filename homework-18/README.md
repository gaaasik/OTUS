# Homework 18 - Работа с JDBC

## Описание

Добавлена **аутентификация через базу данных SQLite** в сетевой чат.

При подключении клиента к серверу запрашивается логин и пароль.  
Сервер проверяет данные через **PreparedStatement** в базе данных.  
Если данные верные — клиент подключается, если неверные — отключается.

---

## Структура проекта

```
homework-18/
├── server/
│   ├── src/main/java/ru/otus/chat/server/
│   │   ├── Server.java             (сервер с подключением к БД)
│   │   ├── ClientHandler.java      (обработка клиента + аутентификация)
│   │   ├── DatabaseService.java    (работа с SQLite через JDBC)
│   │   ├── User.java                (класс пользователя)
│   │   ├── Role.java                (enum USER/ADMIN)
│   │   └── ServerApp.java           (запуск сервера)
│   └── chat.db                      (база данных SQLite)
├── client/
│   └── src/main/java/ru/otus/chat/client/
│       ├── Client.java              (клиент с вводом логин/пароль)
│       └── ClientApp.java           (запуск клиента)
└── README.md
```

---

## База данных

### Таблица `users`:

| id | username | password | role  |
|----|----------|----------|-------|
| 1  | admin    | admin    | ADMIN |
| 2  | user     | user     | USER  |
| 3  | dan      | dan      | USER  |

База создается автоматически при первом запуске сервера.

---

## Запуск

### 0. Скачать SQLite JDBC драйвер

```bash
cd homework-18
wget https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.42.0.0/sqlite-jdbc-3.42.0.0.jar -O sqlite-jdbc.jar
```

---

### 1. Запуск сервера

```bash
cd homework-18/server/src/main/java
javac -cp ../../../sqlite-jdbc.jar ru/otus/chat/server/*.java
java -cp ../../../sqlite-jdbc.jar:. ru.otus.chat.server.ServerApp
```

Сервер запустится на порту **8189**.  
При первом запуске создастся файл `chat.db` с тестовыми пользователями.

---

### 2. Запуск клиента (в новом терминале)

```bash
cd homework-18/client/src/main/java
javac ru/otus/chat/client/*.java
java -cp . ru.otus.chat.client.ClientApp
```

Клиент подключится к серверу и попросит ввести:
1. **Логин**
2. **Пароль**

Если данные верные — клиент подключается к чату.  
Если неверные — клиент отключается.

---

## Тестовые пользователи

| Логин | Пароль | Роль  |
|-------|--------|-------|
| admin | admin  | ADMIN |
| user  | user   | USER  |
| dan   | dan    | USER  |

---

## Пример работы

### Сервер:

```
Сервер запустился на порту: 8189
Созданы тестовые пользователи: admin/admin, user/user, dan/dan
Клиент авторизован: admin
Клиент авторизован: user
admin: Привет!
user: Привет, admin!
Клиент admin отключился
```

---

### Клиент 1 (успешная авторизация):

```
Введите логин:
admin
Введите пароль:
admin
Добро пожаловать, admin!
Ваша роль: ADMIN
Привет!
user: Привет, admin!
/exit
```

---

### Клиент 2 (неудачная авторизация):

```
Введите логин:
test
Введите пароль:
test
Неверный логин или пароль
Соединение с сервером потеряно
```

---

## Реализация

### DatabaseService.java

- Подключение к SQLite через JDBC
- Создание таблицы `users`
- Вставка тестовых данных
- Метод `authenticate(username, password)` — проверка через **PreparedStatement**

### ClientHandler.java

- Метод `authenticate()` — запрос логин/пароль
- Если аутентификация успешна — клиент подключается
- Если неудачна — клиент отключается

### Server.java

- Инициализация `DatabaseService` при старте
- Передача `DatabaseService` в `ClientHandler`

### Client.java

- Простой консольный ввод для логин/пароль
- Обмен сообщениями с сервером

---

## Критерии оценки

✅ База данных SQLite подключена через JDBC  
✅ Аутентификация через `PreparedStatement`  
✅ Тестовые пользователи созданы  
✅ Клиент запрашивает логин/пароль  
✅ Сервер проверяет данные в БД  
✅ При неверных данных клиент отключается  

**Статус: Готово к сдаче!** 🎯
