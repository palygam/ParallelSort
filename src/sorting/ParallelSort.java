package sorting;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class ParallelSort implements Callable<int[]> {
    private int[] array;
    private int[] outputArray;
    private int i;
    private int numberOfChunks;
    int start;

    public ParallelSort() {
    }

    public ParallelSort(int[] array, int i, int numberOfChunks) {
        this.array = array;
        this.i = i;
        this.numberOfChunks = numberOfChunks;
    }

    @Override
    public int[] call() throws Exception {
        int chunkSize = (int) Math.ceil(array.length / numberOfChunks);
        start = i * chunkSize;
        int length = Math.min(array.length - start, chunkSize);
        int[] temp = new int[length];
        System.arraycopy(array, start, temp, 0, length);
        Arrays.sort(temp);
        outputArray = temp;
        System.out.println("Another thread was executed" + Arrays.toString(temp));
        return outputArray;
    }
}