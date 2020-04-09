package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private int position = 0;
    private final Item[] items = new Item[100];


    public boolean replace(String id, Item item) {
        int index = indexOf(id);
          if( index == -1) {
              return false;
          } else {
            items[index] = item;
            return true;
        }
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if( index == -1) {
            return false;
        } else {
            items[index] = null;
            System.arraycopy(items,index+1,items,index, (items.length-1) - (index+1));

            return true;
        }

    }

    private int indexOf(String id) {

        int result = -1;
        for (int i = 0; i < position; i++) {

            if (items[i].getId().equals(id)) {

                result = i;

                break;

            }
        }
        return result;
    }


    // ГЕНЕРИРУЕМ уникальный ключ
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    // ДОБАВЛЕНИЕ заявок
    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }

    // получение заявки по ID
    public Item findById(String id) {

        int index = indexOf(id);

        return index != -1 ? items[index] : null;

    }

    // получение списка ВСЕХ заявок
    public Item[] findAll() {

        Item[] itemsWithoutNull = new Item[items.length];

        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item temp = items[index];
            if (temp != null) {
                itemsWithoutNull[size] = temp;
                size++;
            }
        }

        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);

        return itemsWithoutNull;
    }

    // получение списка по ИМЕНИ
    public Item[] findByName(String name) {
        Item[] nameS = new Item[items.length];
        ////////////////////////////////////
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item temp = items[index];
            if (temp != null) {
                if (temp.getName().equals(name)) {
                    nameS[size] = temp;
                    size++;
                }
            }
        }
        ///////////////////////////////////
        nameS = Arrays.copyOf(nameS, size);
        return nameS;
    }
}

