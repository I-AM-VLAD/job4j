package ru.job4j.chapter_004.streamAPI;
import java.util.List;
import java.util.stream.Collectors;
public class IntPositive {
 public static  void  main(String[] args) {
     List<Integer> all = List.of(-3, 3, -2, 2, -1, 1, 0);
     List<Integer> positive = all.stream().filter(
             elem -> elem > 0
     ).collect(Collectors.toList());
     positive.forEach(System.out::println);
 }
}
