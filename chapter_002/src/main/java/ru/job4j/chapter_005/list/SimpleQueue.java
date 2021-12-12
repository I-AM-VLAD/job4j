package ru.job4j.chapter_005.list;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        while(!in.whenEmpty()) {
            out.push(in.pop());
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
