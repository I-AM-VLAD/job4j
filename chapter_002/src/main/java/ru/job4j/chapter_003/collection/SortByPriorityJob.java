package ru.job4j.chapter_003.collection;

import java.util.Comparator;

public class SortByPriorityJob implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(first.getPriority(), second.getPriority());
    }
}
