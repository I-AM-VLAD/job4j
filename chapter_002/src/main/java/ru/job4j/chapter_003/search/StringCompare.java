package ru.job4j.chapter_003.search;
import java.lang.Math;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int count = Math.min(left.length(), right.length());
        for(int i = 0; i < count; i++) {
            left.charAt(i);
            char leftSymbol = left.charAt(i);
            char rightSymbol = right.charAt(i);
            int result = Character.compare(leftSymbol, rightSymbol);
            if(result != 0) {
                return result;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
