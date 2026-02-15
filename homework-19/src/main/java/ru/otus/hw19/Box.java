package ru.otus.hw19;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public double weight() {
        double totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> other) {
        return Math.abs(this.weight() - other.weight()) < 0.0001;
    }

    public void pourTo(Box<T> other) {
        other.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public int count() {
        return fruits.size();
    }
}
