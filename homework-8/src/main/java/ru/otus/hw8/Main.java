package ru.otus.hw8;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        String[][] array = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = String.valueOf(random.nextInt(20) + 1);
            }
        }

        System.out.println("Массив сгенерирован");
        System.out.print("Введите значение для последнего элемента [" + (rows - 1) + "][" + (cols - 1) + "]: ");
        array[rows - 1][cols - 1] = scanner.next();

        try {
            int result = processArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (AppArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Причина: сработало исключение " + e.getClass().getSimpleName());
        } catch (AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Причина: сработало исключение " + e.getClass().getSimpleName());
        }

        scanner.close();
    }

    public static int processArray(String[][] array) throws AppArraySizeException, AppArrayDataException {
        if (array.length != 4) {
            throw new AppArraySizeException("Массив должен быть размером 4x4, получено строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new AppArraySizeException("Массив должен быть размером 4x4, в строке " + i + " столбцов: " + array[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum = sum + value;
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }

        return sum;
    }
}
