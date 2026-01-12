package ru.otus.hw6;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int amount) {
        food = food + amount;
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food = food - amount;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("В тарелке осталось: " + food);
    }
}
