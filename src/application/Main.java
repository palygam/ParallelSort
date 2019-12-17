import sorting.ParallelSort;
import sorting.ArraysManager;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        ArraysManager arraysManager = new ArraysManager(3000);
        int[] array = arraysManager.fillArray();
        ExecutorService executor = Executors.newFixedThreadPool(arraysManager.calculateChunksCount());

        try {
            for (int i = 0; i < arraysManager.getChunksCount(); ++i) {
                Future future = executor.submit(new ParallelSort(array, i));
                System.arraycopy(future.get(), 0, array, i * ArraysManager.getMaxSize(), arraysManager.calculateChunksLength());
            }
            executor.shutdown();
            System.out.println((Arrays.toString(array)));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

