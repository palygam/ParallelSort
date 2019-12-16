package application;

import sorting.ParallelSort;
import sorting.Service;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        int[] array = service.fillArray(30);
        ExecutorService executor = Executors.newFixedThreadPool(service.calculateChunksCount());

        try {
            for (int i = 0; i < service.getChunksCount(); ++i) {
                Future future = executor.submit(new ParallelSort(array, i));
                System.arraycopy(future.get(), 0, array, i* Service.getMaxSize(), service.calculateLength());
            }
            executor.shutdown();
            System.out.println((Arrays.toString(array)));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
