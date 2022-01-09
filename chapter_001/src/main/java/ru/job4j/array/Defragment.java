package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            String varForNull = array[index];
            int newIndex = index + 1;
            if ((index == array.length - 1) && array[index] == null) {
                break;
            }
            if (varForNull == null) {
                while (array[newIndex] == null && (newIndex != array.length - 1)) {
                    ++newIndex;
                }
                array[index] = array[newIndex];
                array[newIndex] = null;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}