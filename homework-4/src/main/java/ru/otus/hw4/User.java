package ru.otus.hw4;

public class User {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final int birthYear;
    private final String email;

    public User(String lastName, String firstName, String middleName, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public int getAge(int currentYear) {
        return Math.max(0, currentYear - birthYear);
    }

    public void printInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + middleName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
    }
}
