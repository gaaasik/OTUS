package ru.otus.hw14;

public class Main {
    private static final int ARRAY_SIZE = 100_000_000;

    public static void main(String[] args) {
        System.out.println("Размер массива: " + ARRAY_SIZE);
        System.out.println();

        // Реализация №1: Однопоточное заполнение
        System.out.println("=== Реализация №1: Однопоточное заполнение ===");
        long startTime1 = System.currentTimeMillis();
        double[] array1 = fillSingleThread();
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;
        System.out.println("Время выполнения: " + duration1 + " мс");
        System.out.println();

        // Реализация №2: Многопоточное заполнение (4 потока)
        System.out.println("=== Реализация №2: Многопоточное заполнение (4 потока) ===");
        long startTime2 = System.currentTimeMillis();
        double[] array2 = fillMultiThread();
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        System.out.println("Время выполнения: " + duration2 + " мс");
        System.out.println();

        // Сравнение
        System.out.println("=== Сравнение ===");
        System.out.println("Однопоточное: " + duration1 + " мс");
        System.out.println("Многопоточное: " + duration2 + " мс");
        double speedup = (double) duration1 / duration2;
        System.out.println("Ускорение: " + String.format("%.2f", speedup) + "x");
    }

    // Реализация №1: Однопоточное заполнение
    private static double[] fillSingleThread() {
        double[] array = new double[ARRAY_SIZE];
        
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        
        return array;
    }

    // Реализация №2: Многопоточное заполнение (4 потока)
    private static double[] fillMultiThread() {
        double[] array = new double[ARRAY_SIZE];
        int threadsCount = 4;
        int chunkSize = ARRAY_SIZE / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int t = 0; t < threadsCount; t++) {
            final int threadIndex = t;
            final int startIndex = threadIndex * chunkSize;
            final int endIndex = (threadIndex == threadsCount - 1) ? ARRAY_SIZE : (threadIndex + 1) * chunkSize;

            threads[t] = new Thread(() -> {
                for (int i = startIndex; i < endIndex; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });

            threads[t].start();
        }

        // Ожидание завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Поток прерван: " + e.getMessage());
            }
        }

        return array;
    }
}
