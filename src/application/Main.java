package application;

import sorting.ParallelSort;
import sorting.Manager;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        final int numberOfChunks = 10;
        Manager manager = new Manager();
        int[] array = manager.fillArray(1000);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfChunks; ++i) {
            executor.submit(new ParallelSort(array, i, numberOfChunks));}
        executor.shutdown();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
    }
}
