package application;

import sorting.ParallelSort;
import sorting.ArraysManager;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        ArraysManager arraysManager = new ArraysManager(30);
        ExecutorService executor = Executors.newFixedThreadPool(arraysManager.getChunksCount());
        try {
            for (int i = 0; i < arraysManager.getChunksCount(); ++i) {
                Future future = executor.submit(new ParallelSort(arraysManager.getArray(), i));
                System.arraycopy(future.get(), 0, arraysManager.getArray(), i * ArraysManager.MAX_CHUNK_SIZE, arraysManager.getChunksLength());
            }
            executor.shutdown();
            System.out.println((Arrays.toString(arraysManager.getArray())));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}