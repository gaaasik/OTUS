package ru.otus.hw13;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Подключено к серверу " + SERVER_HOST + ":" + SERVER_PORT);

            // Получаем список операций от сервера
            String operations = in.readLine();
            System.out.println(operations);

            System.out.println();
            System.out.println("Введите выражение в формате: число операция число");
            System.out.println("Например: 10 + 5");
            System.out.println("Для выхода введите: exit");
            System.out.println();

            // Цикл ввода от пользователя
            while (true) {
                System.out.print("Введите выражение: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    out.println("exit");
                    String response = in.readLine();
                    System.out.println(response);
                    break;
                }

                // Отправляем запрос на сервер
                out.println(input);

                // Получаем результат от сервера
                String result = in.readLine();
                System.out.println(result);
                System.out.println();
            }

        } catch (UnknownHostException e) {
            System.out.println("Ошибка: сервер не найден - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка подключения к серверу: " + e.getMessage());
        }
    }
}
