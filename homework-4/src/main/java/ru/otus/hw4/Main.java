package ru.otus.hw4;

import java.time.Year;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int currentYear = Year.now().getValue();
        User[] users = new User[] {
            new User("Иванов", "Иван", "Иванович", 1980, "ivanov@example.com"),
            new User("Петров", "Пётр", "Петрович", 1995, "petrov@example.com"),
            new User("Сидоров", "Сидор", "Сидорович", 1979, "sidorov@example.com"),
            new User("Смирнова", "Анна", "Игоревна", 2000, "smirnova@example.com"),
            new User("Кузнецов", "Николай", "Алексеевич", 1983, "kuznetsov@example.com"),
            new User("Васильев", "Василий", "Егорович", 1990, "vasiliev@example.com"),
            new User("Новикова", "Мария", "Андреевна", 1975, "novikova@example.com"),
            new User("Попов", "Дмитрий", "Сергеевич", 1984, "popov@example.com"),
            new User("Соколова", "Елена", "Викторовна", 1992, "sokolova@example.com"),
            new User("Морозов", "Алексей", "Ильич", 1981, "morozov@example.com")
        };

        System.out.println("Пользователи старше 40:");
        for (User user : users) {
            if (user.getAge(currentYear) > 40) {
                user.printInfo();
                System.out.println();
            }
        }

        Box box = new Box(10, 5, 8, "красный");
        box.printInfo();
        box.open();
        box.putItem("книга");
        box.printInfo();
        box.close();
        box.repaint("синий");
        box.open();
        box.removeItem();
        box.printInfo();

        Random random = new Random();
        Box rndBox = new Box(
            5 + random.nextInt(6),
            5 + random.nextInt(6),
            5 + random.nextInt(6),
            random.nextBoolean() ? "зелёный" : "жёлтый"
        );
        rndBox.open();
        rndBox.putItem(random.nextBoolean() ? "мяч" : "ножницы");
        rndBox.printInfo();
    }
}
