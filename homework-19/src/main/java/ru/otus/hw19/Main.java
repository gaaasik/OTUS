package ru.otus.hw19;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 5; i++) {
            appleBox1.add(new Apple());
        }

        for (int i = 0; i < 3; i++) {
            appleBox2.add(new Apple());
        }

        for (int i = 0; i < 5; i++) {
            orangeBox.add(new Orange());
        }

        System.out.println("Коробка 1 (яблоки): " + appleBox1.count() + " шт, вес: " + appleBox1.weight());
        System.out.println("Коробка 2 (яблоки): " + appleBox2.count() + " шт, вес: " + appleBox2.weight());
        System.out.println("Коробка 3 (апельсины): " + orangeBox.count() + " шт, вес: " + orangeBox.weight());
        System.out.println();

        System.out.println("Сравнение коробки 1 и коробки 3: " + appleBox1.compare(orangeBox));
        System.out.println();

        System.out.println("Пересыпаем яблоки из коробки 1 в коробку 2");
        appleBox1.pourTo(appleBox2);
        System.out.println("Коробка 1 (яблоки): " + appleBox1.count() + " шт, вес: " + appleBox1.weight());
        System.out.println("Коробка 2 (яблоки): " + appleBox2.count() + " шт, вес: " + appleBox2.weight());
    }
}
