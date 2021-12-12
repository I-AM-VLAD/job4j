package ru.job4j.chapter_004.streamAPI;
import java.util.Comparator;
public class ComparatorCity implements Comparator<Address>{
    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
