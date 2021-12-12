package ru.job4j.chapter_004.streamAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public static void main(String[] args) {
        Integer[] [] arrayMatrix = {
                {1, 2},
                {3, 4}
        };
        List<List<Integer>> matrix = new ArrayList<>();
        for(int index = 0; index < arrayMatrix.length; index++) {
            List<Integer> oneList = new ArrayList<>();
            for(int indexIn = 0; indexIn < 2; indexIn++) {
                oneList.add(indexIn, arrayMatrix[index] [indexIn]);
            }
            matrix.add(oneList);
        }
        System.out.println(
                matrix.stream().flatMap(List::stream).collect(Collectors.toList())
        );
    }
}
