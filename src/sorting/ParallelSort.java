package sorting;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class ParallelSort implements Callable<int[]> {
    private int[] array;
    private int i;

    public ParallelSort(int[] array, int i) {
        this.array = array;
        this.i = i;
    }

    @Override
    public int[] call() {
        int start = i * ArraysManager.getMaxSize();
        array = Arrays.copyOfRange(array, start, start + ArraysManager.getMaxSize());
        Arrays.sort(array);
        System.out.println("New thread was executed " + Arrays.toString(array));
        return array;
    }
}