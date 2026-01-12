package ru.otus.hw5;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, "Собака", 15, 5, 100);
    }

    @Override
    public int swim(int distance) {
        int cost = distance * 2;
        if (stamina < cost) {
            tired = true;
            System.out.println(name + " устал и не может плыть");
            return -1;
        }
        stamina = stamina - cost;
        int time = distance / swimSpeed;
        System.out.println(name + " проплыл " + distance + " метров за " + time + " секунд");
        return time;
    }
}
