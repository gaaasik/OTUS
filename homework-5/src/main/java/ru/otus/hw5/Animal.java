package ru.otus.hw5;

public class Animal {
    protected String name;
    protected String type;
    protected int runSpeed;
    protected int swimSpeed;
    protected int stamina;
    protected int maxStamina;
    protected boolean tired;

    public Animal(String name, String type, int runSpeed, int swimSpeed, int stamina) {
        this.name = name;
        this.type = type;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.stamina = stamina;
        this.maxStamina = stamina;
        this.tired = false;
    }

    public int run(int distance) {
        int cost = distance * 1;
        if (stamina < cost) {
            tired = true;
            System.out.println(name + " устал и не может бежать");
            return -1;
        }
        stamina = stamina - cost;
        int time = distance / runSpeed;
        System.out.println(name + " пробежал " + distance + " метров за " + time + " секунд");
        return time;
    }

    public int swim(int distance) {
        System.out.println(name + " не умеет плавать");
        return -1;
    }

    public void info() {
        System.out.println("Животное: " + type);
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега: " + runSpeed + " м/с");
        System.out.println("Скорость плавания: " + swimSpeed + " м/с");
        System.out.println("Выносливость: " + stamina + "/" + maxStamina);
        System.out.println("Устал: " + (tired ? "да" : "нет"));
    }
}
