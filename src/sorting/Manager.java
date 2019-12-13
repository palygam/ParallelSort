package sorting;

import java.util.Random;

public class Manager {
    private final static int numberOfChunks = 10;

    public static int getNumberOfChunks() {
        return numberOfChunks;
    }

    public int[] fillArray(int length) {
        int [] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        return array;
    }
}