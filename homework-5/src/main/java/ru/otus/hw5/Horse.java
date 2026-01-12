package ru.otus.hw5;

public class Horse extends Animal {

    public Horse(String name) {
        super(name, "Лошадь", 20, 3, 80);
    }

    @Override
    public int swim(int distance) {
        int cost = distance * 4;
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
