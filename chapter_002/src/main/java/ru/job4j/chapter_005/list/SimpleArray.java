package ru.job4j.chapter_005.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int size = 3;
    private int index = 0;
    public SimpleArray() {
        objects = new Object[size];
    }
    public void add(T model) {
        size = objects.length;
        if(size == index) {
            Object[] temp = new Object[size +1];
            for(int i = 0; i < size; i++) {
                temp[i] = objects[i];
            }
            objects = temp;
        }
        objects[index++] = model;
    }
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T)objects[index];
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = index;
            private int itIndex = 0;
            @Override
            public boolean hasNext() {
                return itIndex < index;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                if(expectedModCount != index) {
                    throw new ConcurrentModificationException();
                }
                return (T)objects[itIndex++];
            }
        };
    }
    public static void main(String[] array) {
        SimpleArray<Integer> simple = new SimpleArray<>();
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.add(4);
        simple.add(5);
        System.out.println(simple.get(4));

    }
}

