package ru.job4j.chapter_005.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinked<T> implements Iterable<T>{
    private Node<T> head;
    private int modCount = 0;
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ++modCount;
        tail.next = node;
    }
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    public T get(int index) {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Objects.checkIndex(index, modCount + 1);
        Node<T> current = head;
        int count = 0;
        while(count != index) {
            current = current.next;
            ++count;
        }
        return current.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if(expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
    public static void main(String[] arr) {
        SimpleLinked<Integer> link = new SimpleLinked<>();
        link.add(1);
        link.add(2);
        link.add(3);
        System.out.println(link.get(2));
        Iterator<Integer> it = link.iterator();
        it.next();
        it.next();
        System.out.println(it.next());
        link.add(4);
        it.next();
    }
}
