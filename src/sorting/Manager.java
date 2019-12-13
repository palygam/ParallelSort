package sorting;

import java.util.Random;

public class Manager {
    private final static int numberOfChunks = 10;
    private int[] array;

    public static int getNumberOfChunks() {
        return numberOfChunks;
    }

    public int[] fillArray(int length) {
        array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        return array;
    }
}