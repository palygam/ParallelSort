package sorting;

import java.util.Random;

public class ArraysManager {
    private static final int MAX_SIZE = 500;
    private int[] array;
    private int chunksCount;
    private int length;

    public ArraysManager(int length) {
        this.length = length;
        array = new int[length];
    }

    public static int getMaxSize() {
        return MAX_SIZE;
    }

    public void setChunksCount(int chunksCount) {
        this.chunksCount = chunksCount;
    }

    public int getChunksCount() {
        return chunksCount;
    }

    public int[] fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    public int calculateChunksCount() {
        if (array.length > MAX_SIZE) {
            chunksCount = (int) Math.ceil((double) array.length / MAX_SIZE);
        }
        return chunksCount;
    }

    public int calculateChunksLength() {
        length = (int) Math.ceil((double) array.length / chunksCount);
        return length;
    }
}