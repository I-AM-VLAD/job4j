package ru.job4j.chapter_005.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int [] data;
    private int point = 0;

    public EvenIterator (int[] data) {
        this.data = data;
    }
    @Override
    public boolean hasNext() {
        int count = 0;
        for(int i  = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                ++count;
            }
        }
        return count != 0 ? true : false;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while(data[point] % 2 != 0) {
            ++point;
        }
        return data[point++];
    }
}
