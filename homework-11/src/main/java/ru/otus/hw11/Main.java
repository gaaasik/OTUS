package ru.otus.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Фиксированный тест:");
        List<Integer> sortedList = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(sortedList);

        System.out.println("Поиск 7: " + tree.find(7));
        System.out.println("Поиск 11: " + tree.find(11));
        System.out.println("Поиск 20: " + tree.find(20));
        System.out.println("Поиск 1: " + tree.find(1));

        List<Integer> result = tree.getSortedList();
        System.out.println("Отсортированный список: " + result);

        System.out.println();
        System.out.print("Хотите тест с рандомными числами? (y/n): ");
        
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                System.out.print("Сколько чисел генерировать? (например, 15): ");
                int count = scanner.nextInt();

                System.out.print("Максимальное значение числа? (например, 100): ");
                int maxValue = scanner.nextInt();

                Random random = new Random();
                List<Integer> randomList = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    randomList.add(random.nextInt(maxValue) + 1);
                }

                Collections.sort(randomList);
                System.out.println("Сгенерированный отсортированный список: " + randomList);

                BinarySearchTree<Integer> randomTree = new BinarySearchTree<>(randomList);

                System.out.println();
                System.out.println("Тестируем поиск:");
                for (int i = 0; i < 5; i++) {
                    int searchValue = random.nextInt(maxValue) + 1;
                    Integer found = randomTree.find(searchValue);
                    if (found != null) {
                        System.out.println("Поиск " + searchValue + ": найден");
                    } else {
                        System.out.println("Поиск " + searchValue + ": не найден");
                    }
                }

                System.out.println();
                System.out.println("Отсортированный список из дерева: " + randomTree.getSortedList());
            }
            scanner.close();
        }
    }
}
