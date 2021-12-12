package ru.job4j.chapter_005.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    public boolean whenEmpty() {
        return linked.whenEmpty();
    }
    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }
}
