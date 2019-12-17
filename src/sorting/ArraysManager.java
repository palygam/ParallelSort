package sorting;

import java.util.Random;

public class ArraysManager {
    public static final int MAX_CHUNK_SIZE = 5;
    private int[] array;
    private int chunksCount;
    private int chunksLength;

    public int[] getArray() {
        return array;
    }

    public ArraysManager(int length) {
        array = fillArray(length);
        chunksCount = calculateChunksCount();
        chunksLength = calculateChunksLength();
    }

    public int getChunksCount() {
        return chunksCount;
    }

    public int getChunksLength() {
        return chunksLength;
    }

    private int[] fillArray(int length) {
        array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    private int calculateChunksCount() {
        if (array.length > MAX_CHUNK_SIZE) {
            chunksCount = (int) Math.ceil((double) array.length / MAX_CHUNK_SIZE);
        }
        return chunksCount;
    }

    private int calculateChunksLength() {
        return (int) Math.ceil((double) array.length / chunksCount);
    }
}