package application;

import sorting.ParallelSort;
import sorting.Manager;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        int[] array = manager.fillArray(2000);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < Manager.getNumberOfChunks(); ++i) {
            Future future = executor.submit(new ParallelSort(array, i, Manager.getNumberOfChunks()));
            int chunkSize = (int) Math.ceil((double) array.length / Manager.getNumberOfChunks());
            int start = i * chunkSize;
            int length = Math.min(array.length - start, chunkSize);
            try {
                System.arraycopy(future.get(), 0, array, start, length);
            } catch (InterruptedException  | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println((Arrays.toString(array)));
    }
}
