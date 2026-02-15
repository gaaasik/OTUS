package ru.otus.hw19;

public abstract class Fruit {
    private final double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
