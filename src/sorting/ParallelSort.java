package sorting;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class ParallelSort implements Callable<int[]> {
    private int[] array;
    private int index;

    public ParallelSort(int[] array, int i) {
        this.array = array;
        this.index = i;
    }

    @Override
    public int[] call() {
        int start = index * ArraysManager.MAX_SIZE;
        array = Arrays.copyOfRange(array, start, start + ArraysManager.MAX_SIZE);
        Arrays.sort(array);
        System.out.println("New thread was executed " + Arrays.toString(array));
        return array;
    }
}