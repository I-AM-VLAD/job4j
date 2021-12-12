package ru.job4j.chapter_003.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> Items = Arrays.asList(
                new Item("Fix bugs", "pl,8jjtkkglgk"),
                new Item("Impl task", "fjbkkkgkhjkk41kdk"),
                new Item("Reboot server", "jcjdkdkfj4i54jfjfj")
        );
        System.out.println(Items);
        System.out.println();

        Collections.sort(Items);
        System.out.println(Items);

        Collections.sort(Items, Collections.reverseOrder());
        System.out.println(Items);
        System.out.println();

        Collections.sort(Items, new SortByNameItem());
        System.out.println(Items);

        Collections.sort(Items, new ItemDescByName());
        System.out.println(Items);
    }
}
