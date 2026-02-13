package ru.otus.hw7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // АВТОМАТИЧЕСКАЯ ДЕМОНСТРАЦИЯ
        automaticDemo();

        // ИНТЕРАКТИВНЫЙ РЕЖИМ
        interactiveMode();
    }

    public static void automaticDemo() {
        Human human = new Human("Даня", 50);

        Car car = new Car(50);
        Horse horse = new Horse(30);
        Bicycle bicycle = new Bicycle();
        AllTerrainVehicle atv = new AllTerrainVehicle(100);

        System.out.println("Человек идет пешком");
        human.move(5, TerrainType.PLAIN);
        System.out.println();

        System.out.println("Человек садится в машину");
        human.setTransport(car);
        human.move(10, TerrainType.PLAIN);
        human.move(20, TerrainType.DENSE_FOREST);
        human.move(15, TerrainType.SWAMP);
        human.move(25, TerrainType.PLAIN);
        System.out.println();

        System.out.println("Человек пересаживается на лошадь");
        human.setTransport(horse);
        human.move(10, TerrainType.PLAIN);
        human.move(5, TerrainType.DENSE_FOREST);
        human.move(10, TerrainType.SWAMP);
        human.move(20, TerrainType.PLAIN);
        System.out.println();

        System.out.println("Человек пересаживается на велосипед");
        human.setTransport(bicycle);
        human.move(15, TerrainType.PLAIN);
        human.move(10, TerrainType.DENSE_FOREST);
        human.move(5, TerrainType.SWAMP);
        human.move(30, TerrainType.PLAIN);
        System.out.println();

        System.out.println("Человек пересаживается на вездеход");
        human.setTransport(atv);
        human.move(20, TerrainType.PLAIN);
        human.move(30, TerrainType.DENSE_FOREST);
        human.move(25, TerrainType.SWAMP);
        human.move(40, TerrainType.PLAIN);
        System.out.println();

        System.out.println("Человек слезает с транспорта");
        human.removeTransport();
        human.move(3, TerrainType.SWAMP);
        System.out.println();
    }

    public static void interactiveMode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Хотите протестировать самостоятельно? (y/n):");
        String choice = scanner.nextLine();

        if (!choice.equalsIgnoreCase("y")) {
            System.out.println("Демонстрация завершена.");
            scanner.close();
            return;
        }

        System.out.print("Введите имя человека: ");
        String name = scanner.nextLine();

        System.out.print("Введите начальную выносливость человека: ");
        int stamina = scanner.nextInt();

        Human human = new Human(name, stamina);

        System.out.print("Введите начальное количество бензина для машины: ");
        int carFuel = scanner.nextInt();
        Car car = new Car(carFuel);

        System.out.print("Введите начальную выносливость лошади: ");
        int horseStamina = scanner.nextInt();
        Horse horse = new Horse(horseStamina);

        Bicycle bicycle = new Bicycle();

        System.out.print("Введите начальное количество бензина для вездехода: ");
        int atvFuel = scanner.nextInt();
        AllTerrainVehicle atv = new AllTerrainVehicle(atvFuel);

        boolean running = true;
        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1 - Сесть в машину");
            System.out.println("2 - Сесть на лошадь");
            System.out.println("3 - Сесть на велосипед");
            System.out.println("4 - Сесть в вездеход");
            System.out.println("5 - Слезть с транспорта");
            System.out.println("6 - Переместиться");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    human.setTransport(car);
                    break;
                case 2:
                    human.setTransport(horse);
                    break;
                case 3:
                    human.setTransport(bicycle);
                    break;
                case 4:
                    human.setTransport(atv);
                    break;
                case 5:
                    human.removeTransport();
                    break;
                case 6:
                    System.out.print("Введите расстояние: ");
                    int distance = scanner.nextInt();
                    System.out.println("Выберите местность:");
                    System.out.println("1 - Равнина (PLAIN)");
                    System.out.println("2 - Густой лес (DENSE_FOREST)");
                    System.out.println("3 - Болото (SWAMP)");
                    System.out.print("Ваш выбор: ");
                    int terrainChoice = scanner.nextInt();

                    TerrainType terrain = TerrainType.PLAIN;
                    if (terrainChoice == 2) {
                        terrain = TerrainType.DENSE_FOREST;
                    } else if (terrainChoice == 3) {
                        terrain = TerrainType.SWAMP;
                    }

                    boolean result = human.move(distance, terrain);
                    System.out.println("Результат перемещения: " + (result ? "успех" : "неудача"));
                    break;
                case 0:
                    running = false;
                    System.out.println("Завершение работы.");
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }

        scanner.close();
    }
}
