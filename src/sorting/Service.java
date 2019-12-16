package sorting;

import java.util.Random;

public class Service {
    private static final int MAX_SIZE = 5;
    private int[] array;
    private int chunksCount;
    private int length;

    public static int getMaxSize() {
        return MAX_SIZE;
    }

    public void setChunksCount(int chunksCount) {
        this.chunksCount = chunksCount;
    }

    public int getChunksCount() {
        return chunksCount;
    }

    public int[] fillArray(int length) {
        array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    public int calculateChunksCount() {

        if (array.length > MAX_SIZE) {
            chunksCount = (int) Math.ceil((double) array.length / MAX_SIZE);
        } else {
            chunksCount = 1;
        }
        return chunksCount;
    }

    public int calculateLength() {
        for (int i = 0; i < chunksCount; ++i) {
            int chunkSize = (int) Math.ceil((double) array.length / chunksCount);
            int start = i * Service.getMaxSize();
            length = Math.min(array.length - start, chunkSize);
        }
        return length;
    }
}