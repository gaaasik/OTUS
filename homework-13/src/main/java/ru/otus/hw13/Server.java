package ru.otus.hw13;

import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Сервер запущен на порту " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress());

                // Обработка клиента в отдельном потоке для поддержки нескольких клиентов
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            // Отправляем список операций клиенту
            out.println("Доступные операции: +, -, *, /");

            // Обработка запросов от клиента
            String request;
            while ((request = in.readLine()) != null) {
                if (request.equalsIgnoreCase("exit")) {
                    out.println("Отключение от сервера");
                    break;
                }

                String result = calculate(request);
                out.println(result);
            }

            System.out.println("Клиент отключен: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            System.out.println("Ошибка при обработке клиента: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии сокета: " + e.getMessage());
            }
        }
    }

    private static String calculate(String request) {
        try {
            String[] parts = request.trim().split("\\s+");
            
            if (parts.length != 3) {
                return "Ошибка: неверный формат. Используйте: число операция число";
            }

            double num1 = Double.parseDouble(parts[0]);
            String operation = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            double result;
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        return "Ошибка: деление на ноль";
                    }
                    result = num1 / num2;
                    break;
                default:
                    return "Ошибка: неизвестная операция '" + operation + "'";
            }

            return "Результат: " + result;
        } catch (NumberFormatException e) {
            return "Ошибка: неверный формат числа";
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }
}
