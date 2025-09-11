import java.util.Random;
import java.util.Scanner;

public class Main {
    
    // Печатает строку указанное количество раз
    public static void printStringMultipleTimes(int count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    
    // Суммирует элементы массива больше 5
    public static void sumElementsGreaterThanFive(int[] array) {
        int sum = 0;
        for (int element : array) {
            if (element > 5) {
                sum += element;
            }
        }
        System.out.println("Сумма элементов больше 5: " + sum);
    }
    
    // Заполняет массив указанным числом
    public static void fillArray(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
        System.out.print("Заполненный массив: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Увеличивает каждый элемент массива на указанное число
    public static void increaseArrayElements(int increment, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += increment;
        }
    }
    
    // Сравнивает суммы половин массива
    public static void compareArrayHalves(int[] array) {
        int middle = array.length / 2;
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        
        for (int i = 0; i < middle; i++) {
            firstHalfSum += array[i];
        }
        
        for (int i = middle; i < array.length; i++) {
            secondHalfSum += array[i];
        }
        
        System.out.println("Сумма первой половины: " + firstHalfSum);
        System.out.println("Сумма второй половины: " + secondHalfSum);
        
        if (firstHalfSum > secondHalfSum) {
            System.out.println("Сумма первой половины больше");
        } else if (secondHalfSum > firstHalfSum) {
            System.out.println("Сумма второй половины больше");
        } else {
            System.out.println("Суммы половин равны");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Интерактивная демонстрация 5 методов ===");
        
        // 1. Печать строки указанное количество раз
        System.out.println("\n1. Печать строки указанное количество раз");
        System.out.print("Введите количество повторений: ");
        int count = scanner.nextInt();
        System.out.print("Введите текст для печати: ");
        scanner.nextLine(); // очистка буфера
        String text = scanner.nextLine();
        printStringMultipleTimes(count, text);
        
        // 2. Суммирование элементов больше 5
        System.out.println("\n2. Суммирование элементов больше 5");
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array1 = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }
        sumElementsGreaterThanFive(array1);
        
        // 3. Заполнение массива указанным числом
        System.out.println("\n3. Заполнение массива указанным числом");
        System.out.print("Введите размер массива: ");
        int size2 = scanner.nextInt();
        System.out.print("Введите число для заполнения: ");
        int fillValue = scanner.nextInt();
        int[] array2 = new int[size2];
        fillArray(fillValue, array2);
        
        // 4. Увеличение элементов массива на указанное число
        System.out.println("\n4. Увеличение элементов массива на указанное число");
        System.out.print("Введите размер массива: ");
        int size3 = scanner.nextInt();
        int[] array3 = new int[size3];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size3; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array3[i] = scanner.nextInt();
        }
        System.out.print("Введите число для увеличения: ");
        int increment = scanner.nextInt();
        System.out.println("Массив до увеличения:");
        for (int i = 0; i < size3; i++) {
            System.out.print(array3[i] + " ");
        }
        System.out.println();
        increaseArrayElements(increment, array3);
        System.out.println("Массив после увеличения на " + increment + ":");
        for (int i = 0; i < size3; i++) {
            System.out.print(array3[i] + " ");
        }
        System.out.println();
        
        // 5. Сравнение половин массива
        System.out.println("\n5. Сравнение половин массива");
        System.out.print("Введите размер массива: ");
        int size4 = scanner.nextInt();
        int[] array4 = new int[size4];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size4; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array4[i] = scanner.nextInt();
        }
        compareArrayHalves(array4);
        
        scanner.close();
        
    }
}