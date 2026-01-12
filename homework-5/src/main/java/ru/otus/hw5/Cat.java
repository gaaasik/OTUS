package ru.otus.hw5;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, "Кот", 10, 0, 50);
    }

    @Override
    public int swim(int distance) {
        System.out.println(name + " не умеет плавать, это же кот!");
        return -1;
    }
}
