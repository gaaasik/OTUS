package ru.otus.hw6;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(50);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик", 10);
        cats[1] = new Cat("Мурзик", 15);
        cats[2] = new Cat("Пушок", 30);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        System.out.println();
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].isFullness()) {
                System.out.println(cats[i].getName() + ": сыт");
            } else {
                System.out.println(cats[i].getName() + ": голоден");
            }
        }

        System.out.println();
        plate.info();
    }
}
