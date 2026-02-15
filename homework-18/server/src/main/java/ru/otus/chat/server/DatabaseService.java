package ru.otus.chat.server;

import java.sql.*;

public class DatabaseService {
    private static final String DB_URL = "jdbc:sqlite:chat.db";
    private Connection connection;

    public DatabaseService() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            createTables();
            insertDefaultUsers();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе данных", e);
        }
    }

    private void createTables() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL UNIQUE, " +
                "password TEXT NOT NULL, " +
                "role TEXT NOT NULL)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createUsersTable);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка создания таблиц", e);
        }
    }

    private void insertDefaultUsers() {
        String checkQuery = "SELECT COUNT(*) FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(checkQuery)) {
            if (rs.next() && rs.getInt(1) == 0) {
                String insertAdmin = "INSERT INTO users (username, password, role) VALUES ('admin', 'admin', 'ADMIN')";
                String insertUser1 = "INSERT INTO users (username, password, role) VALUES ('user', 'user', 'USER')";
                String insertUser2 = "INSERT INTO users (username, password, role) VALUES ('dan', 'dan', 'USER')";
                statement.execute(insertAdmin);
                statement.execute(insertUser1);
                statement.execute(insertUser2);
                System.out.println("Созданы тестовые пользователи: admin/admin, user/user, dan/dan");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка вставки тестовых пользователей", e);
        }
    }

    public User authenticate(String username, String password) {
        String query = "SELECT id, username, role FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String user = rs.getString("username");
                String roleStr = rs.getString("role");
                Role role = Role.valueOf(roleStr);
                return new User(id, user, role);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка аутентификации: " + e.getMessage());
        }
        return null;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка закрытия соединения: " + e.getMessage());
        }
    }
}
