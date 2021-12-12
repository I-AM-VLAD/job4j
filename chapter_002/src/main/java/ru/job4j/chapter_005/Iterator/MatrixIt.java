package ru.job4j.chapter_005.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        for(int i = row; i < data.length; i++) {
            if(data[i].length != 0) {
                ++count;
            }
        }
        return count != 0 ? true : false;
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        if(data[row].length == 0) {
            while (data[row].length == 0) {
                ++row;
            }
        }
        if(column == data[row].length) {
            ++row;
            column = 0;
        }
        if(data[row].length == 0) {
            while (data[row].length == 0) {
                ++row;
            }
        }
        return data[row][column++];
    }
}
