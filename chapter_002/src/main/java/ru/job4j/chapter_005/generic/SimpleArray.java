package ru.job4j.chapter_005.generic;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class SimpleArray<T> implements Iterable<T>{
    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T element) {
        objects[index++] = element;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) objects[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, this.index);
        System.arraycopy(objects,index+1,objects,index,(objects.length-1) - (index+1));
    }

    public void replace(T element, int index) {
        Objects.checkIndex(index, this.index);

        objects[index] = element;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<T> listT =  new ArrayList<>();
        for(int i = 0; i < index; i++) {
            Object o1 = objects[i];
            T o2 = (T) o1;
            listT.add(get(i));
        }
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < objects.length;
            }

            @Override
            public T next() {
                return (T)objects[index++];
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(Objects.checkIndex(0,4));
        SimpleArray<Integer> element = new SimpleArray<>(10);
        element.add(1);
        System.out.println(element.iterator().next());
        element.add(2);
        System.out.println(element.iterator().next());
        element.add(3);
        System.out.println(element.iterator().next());
    }
}
