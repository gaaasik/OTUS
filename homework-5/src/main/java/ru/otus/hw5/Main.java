package ru.otus.hw5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Cat cat = new Cat("Мурзик");
        Dog dog = new Dog("Бобик");
        Horse horse = new Horse("Буцефал");
        
        System.out.println("=== Тестирование животных ===");
        System.out.println();
        
        System.out.print("Введите дистанцию для бега (метров): ");
        int runDistance = scanner.nextInt();
        
        System.out.print("Введите дистанцию для плавания (метров): ");
        int swimDistance = scanner.nextInt();
        
        System.out.println();
        System.out.println("=== Информация о животных ===");
        cat.info();
        System.out.println();
        dog.info();
        System.out.println();
        horse.info();
        
        System.out.println();
        System.out.println("=== Тест бега на " + runDistance + " метров ===");
        int time1 = cat.run(runDistance);
        if (time1 >= 0) System.out.println("Время: " + time1 + " секунд");
        int time2 = dog.run(runDistance);
        if (time2 >= 0) System.out.println("Время: " + time2 + " секунд");
        int time3 = horse.run(runDistance);
        if (time3 >= 0) System.out.println("Время: " + time3 + " секунд");
        
        System.out.println();
        System.out.println("=== Тест плавания на " + swimDistance + " метров ===");
        int time4 = cat.swim(swimDistance);
        if (time4 >= 0) System.out.println("Время: " + time4 + " секунд");
        int time5 = dog.swim(swimDistance);
        if (time5 >= 0) System.out.println("Время: " + time5 + " секунд");
        int time6 = horse.swim(swimDistance);
        if (time6 >= 0) System.out.println("Время: " + time6 + " секунд");
        
        System.out.println();
        System.out.println("=== Состояние после нагрузки ===");
        cat.info();
        System.out.println();
        dog.info();
        System.out.println();
        horse.info();
        
        scanner.close();
    }
}
