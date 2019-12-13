package application;

import sorting.ParallelSort;
import sorting.Manager;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Manager manager = new Manager();
        int[] array = manager.fillArray(20);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < Manager.getNumberOfChunks(); ++i) {
            Future future = executor.submit(new ParallelSort(array, i, Manager.getNumberOfChunks()));
            int chunkSize = (int) Math.ceil(array.length / Manager.getNumberOfChunks());
            int start = i * chunkSize;
            int length = Math.min(array.length - start, chunkSize);
            System.arraycopy(future.get(), 0, array, start, length);
        }
        executor.shutdown();
        System.out.println((Arrays.toString(array)));
    }
}
