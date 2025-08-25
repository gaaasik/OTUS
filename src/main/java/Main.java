import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Домашнее задание по основам Java");
        System.out.println("Выберите номер метода для выполнения (1-5):");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1: greetings(); break;
            case 2: 
                int a = random.nextInt(100) - 50;
                int b = random.nextInt(100) - 50;
                int c = random.nextInt(100) - 50;
                System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                checkSign(a, b, c);
                break;
            case 3: selectColor(); break;
            case 4: compareNumbers(); break;
            case 5:
                int initValue = random.nextInt(100);
                int delta = random.nextInt(20) + 1;
                boolean increment = random.nextBoolean();
                System.out.println("initValue = " + initValue + ", delta = " + delta + ", increment = " + increment);
                addOrSubtractAndPrint(initValue, delta, increment);
                break;
            default:
                System.out.println("Неверный номер! Выполняю все методы:");
                greetings();
                checkSign(10, 20, 30);
                selectColor();
                compareNumbers();
                addOrSubtractAndPrint(50, 10, true);
        }
        scanner.close();
    }
    
    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }
    
    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    
    public static void selectColor() {
        int data = 15;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    
    public static void compareNumbers() {
        int a = 25;
        int b = 15;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    
    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            int result = initValue + delta;
            System.out.println("Результат сложения: " + result);
        } else {
            int result = initValue - delta;
            System.out.println("Результат вычитания: " + result);
        }
    }
}
