package ru.otus.hw6;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            fullness = true;
            System.out.println(name + " поел");
        } else {
            System.out.println(name + " не смог поесть");
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }
}
