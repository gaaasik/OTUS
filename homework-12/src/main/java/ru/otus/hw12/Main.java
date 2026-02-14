package ru.otus.hw12;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Шаг 1: Вывод списка текстовых файлов из корневого каталога проекта
            System.out.println("Текстовые файлы в корневом каталоге проекта:");
            // Поднимаемся на 4 уровня вверх: java -> main -> src -> homework-12 -> корень
            Path projectRoot = Paths.get("../../../../").toAbsolutePath().normalize();
            List<String> txtFiles = Files.list(projectRoot)
                    .filter(path -> path.toString().endsWith(".txt"))
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());

            if (txtFiles.isEmpty()) {
                System.out.println("Текстовые файлы не найдены.");
                return;
            }

            for (String fileName : txtFiles) {
                System.out.println("  - " + fileName);
            }

            // Шаг 2: Запрос имени файла
            System.out.println();
            System.out.print("Введите имя файла для работы: ");
            String fileName = scanner.nextLine().trim();

            if (fileName.isEmpty()) {
                System.out.println("Имя файла не может быть пустым.");
                return;
            }

            Path filePath = projectRoot.resolve(fileName);

            if (!Files.exists(filePath)) {
                System.out.println("Файл не найден: " + fileName);
                return;
            }

            if (!Files.isRegularFile(filePath)) {
                System.out.println("Это не файл: " + fileName);
                return;
            }

            // Шаг 3: Чтение и вывод содержимого файла
            System.out.println();
            System.out.println("Содержимое файла:");
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }

            // Шаг 4: Запись строк в файл
            System.out.println();
            System.out.println("Введите строки для добавления в файл (введите 'exit' для выхода):");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {
                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        break;
                    }
                    writer.write(input);
                    writer.newLine();
                    writer.flush(); // Сразу записываем в файл
                    System.out.println("Строка добавлена в файл.");
                }
            }

            System.out.println("Работа завершена.");

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
