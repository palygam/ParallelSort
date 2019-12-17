package sorting;

import java.util.Random;

public class ArraysManager {
    public static final int MAX_SIZE = 5;
    private int[] array;
    private int chunksCount;
    private int chunksLength;

    public ArraysManager(int length) {
        array = new int[length];
        chunksCount = calculateChunksCount();
        chunksLength = calculateChunksLength();
    }

    public int getChunksCount() {
        return chunksCount;
    }

    public int getChunksLength() {
        return chunksLength;
    }

    public int[] fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    private int calculateChunksCount() {
        if (array.length > MAX_SIZE) {
            chunksCount = (int) Math.ceil((double) array.length / MAX_SIZE);
        }
        return chunksCount;
    }

    private int calculateChunksLength() {
        return (int) Math.ceil((double) array.length / chunksCount);
    }
}