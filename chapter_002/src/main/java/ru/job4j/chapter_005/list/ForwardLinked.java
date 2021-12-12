package ru.job4j.chapter_005.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    public void deleteFirst() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        head = temp.next;
        temp.next = null;
    }

    public T deleteLast() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        if(head.next == null) {
            T value = head.value;
            head = null;
            return value;
        }
        Node<T> tail = head;
        while(tail.next.next != null) {
            tail = tail.next.next;
        }
        T value = tail.next.value;
        tail.next = null;
        return value;
    }
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
        tail.next = node;
    }
    public boolean whenEmpty() {
        return head == null;
    }
    public Node<T> returnLastNode() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        if(head.next == null) {
            Node<T> node = head;
            head = null;
            return node;
        }
        Node<T> tail = head;
        while(tail.next.next != null) {
            tail = tail.next.next;
        }
        Node<T> node = tail.next;
        tail.next = null;
        return node;
    }
    //для задания "перевернуть список"
    public void revert() {
        Node<T> headRevert = returnLastNode();
        Node<T> temp = headRevert;
        while(!whenEmpty()) {
            temp.next = returnLastNode();
        }
        head = headRevert;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
