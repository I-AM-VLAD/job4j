package ru.job4j.chapter_004.lambda;
import java.util.ArrayList;
import java.util.List;
import  java.util.function.Function;
import  java.util.function.Consumer;
public class Functions {
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        List<Double> result = new ArrayList<>();

        for(int i = start; i <= end; i++) {
            double in = i;
            list.add(in);
        }

        Consumer<Double> consumer = (x) ->  result.add(func.apply(x));
        list.forEach(consumer);
        return result;
    }
}
