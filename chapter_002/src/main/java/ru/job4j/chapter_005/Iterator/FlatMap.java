package ru.job4j.chapter_005.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
        this.cursor = this.data.next();
    }

    @Override
    public boolean hasNext() {

        return cursor.hasNext() == false && data.hasNext() == false ? false : true;
    }

    @Override
    public T next() {

        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        if(!cursor.hasNext()) {
          cursor = data.next();
        }
        return cursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}
