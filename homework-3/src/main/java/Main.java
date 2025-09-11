import java.util.Scanner;

public class Main {
    
    // Сумма положительных элементов двумерного массива
    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Сумма положительных элементов: " + sum);
        return sum;
    }
    
    // Печатает квадрат из звездочек
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    // Зануляет диагональные элементы
    public static void zeroDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 0;
                }
            }
        }
        System.out.println("Диагональные элементы занулены");
    }
    
    // Находит максимальный элемент
    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Максимальный элемент: " + max);
        return max;
    }
    
    // Сумма элементов второй строки
    public static int sumSecondRow(int[][] array) {
        if (array.length < 2) {
            System.out.println("Второй строки не существует, возвращаем -1");
            return -1;
        }
        int sum = 0;
        for (int j = 0; j < array[1].length; j++) {
            sum += array[1][j];
        }
        System.out.println("Сумма второй строки: " + sum);
        return sum;
    }
    
    // Печатает двумерный массив
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Демонстрация 5 методов с двумерными массивами ===");
        
        // 1. Сумма положительных элементов
        System.out.println("\n1. Сумма положительных элементов");
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();
        int[][] array1 = new int[rows][cols];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                array1[i][j] = scanner.nextInt();
            }
        }
        sumOfPositiveElements(array1);
        
        // 2. Печать квадрата
        System.out.println("\n2. Печать квадрата из звездочек");
        System.out.print("Введите размер квадрата: ");
        int size = scanner.nextInt();
        printSquare(size);
        
        // 3. Зануление диагональных элементов
        System.out.println("\n3. Зануление диагональных элементов");
        System.out.print("Введите количество строк: ");
        int rows2 = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols2 = scanner.nextInt();
        int[][] array2 = new int[rows2][cols2];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                array2[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Массив до зануления:");
        printArray(array2);
        zeroDiagonal(array2);
        System.out.println("Массив после зануления:");
        printArray(array2);
        
        // 4. Поиск максимального элемента
        System.out.println("\n4. Поиск максимального элемента");
        System.out.print("Введите количество строк: ");
        int rows3 = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols3 = scanner.nextInt();
        int[][] array3 = new int[rows3][cols3];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows3; i++) {
            for (int j = 0; j < cols3; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                array3[i][j] = scanner.nextInt();
            }
        }
        findMax(array3);
        
        // 5. Сумма второй строки
        System.out.println("\n5. Сумма второй строки");
        System.out.print("Введите количество строк: ");
        int rows4 = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols4 = scanner.nextInt();
        int[][] array4 = new int[rows4][cols4];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows4; i++) {
            for (int j = 0; j < cols4; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                array4[i][j] = scanner.nextInt();
            }
        }
        sumSecondRow(array4);
        
        scanner.close();
        System.out.println("\nПрограмма завершена!");
    }
}
