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
        int start = i * Service.getMaxSize();
        int[] temp = Arrays.copyOfRange(array, start, start + Service.getMaxSize());
        Arrays.sort(temp);
        System.out.println("Another thread was executed" + Arrays.toString(temp));
        return temp;
    }
}