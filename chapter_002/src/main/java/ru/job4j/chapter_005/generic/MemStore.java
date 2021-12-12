package ru.job4j.chapter_005.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();
    private int indexOf(String id) {

        int result = -1;
        int index = 0;
        for (T element : mem) {
            if (element != null) {
                if (element.getId().equals(id)) {
                    result = index;

                    break;
                }
            }
            ++index;
        }
        return result;
    }


    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        if( index == -1) {
            return false;
        } else {
            mem.add(index, model);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        if( index == -1) {
            return false;
        } else {
            System.arraycopy(mem,index+1, mem, index, (mem.size()) - (index+1));

            return true;
        }
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);

        return index != -1 ? mem.get(index): null;
    }
}