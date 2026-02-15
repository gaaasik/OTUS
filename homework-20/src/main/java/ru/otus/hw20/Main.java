package ru.otus.hw20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите искомую последовательность символов: ");
        String searchString = scanner.nextLine();

        try {
            int count = countOccurrences(fileName, searchString);
            System.out.println("Количество вхождений \"" + searchString + "\" в файле \"" + fileName + "\": " + count);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int countOccurrences(String fileName, String searchString) throws IOException {
        if (searchString.isEmpty()) {
            return 0;
        }

        int count = 0;
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        String text = content.toString();
        int index = 0;

        while ((index = text.indexOf(searchString, index)) != -1) {
            count++;
            index += searchString.length();
        }

        return count;
    }
}
