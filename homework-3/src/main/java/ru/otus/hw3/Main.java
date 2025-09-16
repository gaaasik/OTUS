package ru.otus.hw3;

import java.util.Random;

public class Main {
    
    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }
    
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    public static void zeroDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array[i].length) {
                array[i][i] = 0;
            }
        }
    }
    
    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }
    
    public static int sumSecondRow(int[][] array) {
        if (array.length < 2) {
            return -1;
        }
        int sum = 0;
        for (int j = 0; j < array[1].length; j++) {
            sum += array[1][j];
        }
        return sum;
    }
    
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] generateRandomArray(int rows, int cols, int minValue, int maxValue, Random random) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = minValue + random.nextInt(maxValue - minValue + 1);
            }
        }
        return array;
    }
    
    public static int[][] generatePositiveBiasedArray(int rows, int cols, Random random) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (random.nextDouble() < 0.75) {
                    array[i][j] = random.nextInt(31); // 0..30
                } else {
                    array[i][j] = -10 + random.nextInt(21); // -10..10
                }
            }
        }
        return array;
    }
    
    public static void main(String[] args) {
        System.out.println("HW3 demo");
        Random random = new Random();

        System.out.println("1) sumOfPositiveElements");
        int[][] a1 = generatePositiveBiasedArray(3 + random.nextInt(3), 4 + random.nextInt(3), random);
        printArray(a1);
        System.out.println("sum = " + sumOfPositiveElements(a1));

        System.out.println("\n2) printSquare");
        int size = 3 + random.nextInt(6);
        System.out.println("size = " + size);
        printSquare(size);

        System.out.println("\n3) zeroDiagonal");
        int[][] a2 = generatePositiveBiasedArray(3 + random.nextInt(3), 3 + random.nextInt(3), random);
        printArray(a2);
        zeroDiagonal(a2);
        System.out.println("after:");
        printArray(a2);

        System.out.println("\n4) findMax");
        int[][] a3 = generatePositiveBiasedArray(4 + random.nextInt(3), 5 + random.nextInt(3), random);
        printArray(a3);
        System.out.println("max = " + findMax(a3));

        System.out.println("\n5) sumSecondRow");
        int[][] a4 = generatePositiveBiasedArray(2 + random.nextInt(4), 4 + random.nextInt(4), random);
        printArray(a4);
        System.out.println("row2sum = " + sumSecondRow(a4));
    }
}
