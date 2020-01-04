package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int reverse = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int temp =  array[i];
            array [i] = array [reverse];
            array [reverse] = temp;
            --reverse;
        }
        return array;
    }
}
