package ru.job4j.chapter_003.collection;


import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order element : orders) {
            map.put(element.getNumber(), element);
        }
        return map;
    }
}
