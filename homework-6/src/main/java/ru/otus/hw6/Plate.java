package ru.otus.hw6;

public class Plate {
    private int maxFood;
    private int food;

    public Plate(int volume) {
        this.maxFood = volume;
        this.food = volume;
    }

    public void addFood(int amount) {
        food += amount;
        if (food > maxFood) {
            food = maxFood;
        }
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("В тарелке осталось: " + food);
    }
}
