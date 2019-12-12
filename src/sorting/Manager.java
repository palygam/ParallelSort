package sorting;

import java.util.Random;

public class Manager {
    private int[] array;

    public int[] fillArray(int size) {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        return array;
    }
}