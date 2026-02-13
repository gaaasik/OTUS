package ru.otus.hw9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Список от 3 до 9:");
        ArrayList<Integer> range = createList(3, 9);
        System.out.println(range);
        System.out.println();

        System.out.println("2. Сумма элементов больше 5:");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(2);
        numbers.add(9);
        numbers.add(5);
        System.out.println(numbers);
        System.out.println("Сумма: " + sumGreaterThanFive(numbers));
        System.out.println();

        System.out.println("3. Заполнение списка числом 10:");
        ArrayList<Integer> listToFill = new ArrayList<>();
        listToFill.add(1);
        listToFill.add(2);
        listToFill.add(3);
        System.out.println("До: " + listToFill);
        fillList(10, listToFill);
        System.out.println("После: " + listToFill);
        System.out.println();

        System.out.println("4. Увеличение каждого элемента на 5:");
        ArrayList<Integer> listToIncrease = new ArrayList<>();
        listToIncrease.add(1);
        listToIncrease.add(2);
        listToIncrease.add(3);
        System.out.println("До: " + listToIncrease);
        increaseList(5, listToIncrease);
        System.out.println("После: " + listToIncrease);
        System.out.println();

        System.out.println("5. Работа с сотрудниками:");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иван", 30));
        employees.add(new Employee("Мария", 25));
        employees.add(new Employee("Петр", 35));
        employees.add(new Employee("Анна", 28));
        System.out.println();

        System.out.println("6. Имена сотрудников:");
        System.out.println(getNames(employees));
        System.out.println();

        System.out.println("7. Сотрудники старше 30:");
        ArrayList<Employee> filtered = filterByAge(employees, 30);
        System.out.println(getNames(filtered));
        System.out.println();

        System.out.println("8. Средний возраст больше 28:");
        System.out.println(checkAverageAge(employees, 28));
        System.out.println();

        System.out.println("9. Самый молодой сотрудник:");
        Employee youngest = getYoungest(employees);
        System.out.println(youngest.getName() + " - " + youngest.getAge() + " лет");
    }

    public static ArrayList<Integer> createList(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int sumGreaterThanFive(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            if (num > 5) {
                sum = sum + num;
            }
        }
        return sum;
    }

    public static void fillList(int value, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    public static void increaseList(int value, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + value);
        }
    }

    public static ArrayList<String> getNames(ArrayList<Employee> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee e : employees) {
            names.add(e.getName());
        }
        return names;
    }

    public static ArrayList<Employee> filterByAge(ArrayList<Employee> employees, int minAge) {
        ArrayList<Employee> filtered = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getAge() >= minAge) {
                filtered.add(e);
            }
        }
        return filtered;
    }

    public static boolean checkAverageAge(ArrayList<Employee> employees, int minAvgAge) {
        int sum = 0;
        for (Employee e : employees) {
            sum = sum + e.getAge();
        }
        double average = (double) sum / employees.size();
        return average > minAvgAge;
    }

    public static Employee getYoungest(ArrayList<Employee> employees) {
        Employee youngest = employees.get(0);
        for (Employee e : employees) {
            if (e.getAge() < youngest.getAge()) {
                youngest = e;
            }
        }
        return youngest;
    }
}
