package ru.job4j.chapter_003.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSort {

    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        System.out.println(numbers);
    }
}
