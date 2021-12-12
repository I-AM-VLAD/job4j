package ru.job4j.chapter_004.streamAPI;

import java.util.List;

public class Sorted {
    public static List<Address> sorted(List<Address> addresses) {
        addresses.sort(new ComparatorCity());
        addresses.stream().distinct();
        return addresses;
    }
}
