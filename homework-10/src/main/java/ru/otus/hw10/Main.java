package ru.otus.hw10;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "123-45-67");
        phoneBook.add("Иванов", "890-12-34");
        phoneBook.add("Петров", "555-55-55");
        phoneBook.add("Сидоров", "777-77-77");
        phoneBook.add("Петров", "666-66-66");

        Set<String> ivanovPhones = phoneBook.find("Иванов");
        System.out.println("Иванов: " + ivanovPhones);

        Set<String> petrovPhones = phoneBook.find("Петров");
        System.out.println("Петров: " + petrovPhones);

        Set<String> sidorovPhones = phoneBook.find("Сидоров");
        System.out.println("Сидоров: " + sidorovPhones);

        System.out.println("Телефон 123-45-67 есть: " + phoneBook.containsPhoneNumber("123-45-67"));
        System.out.println("Телефон 999-99-99 есть: " + phoneBook.containsPhoneNumber("999-99-99"));
    }
}
