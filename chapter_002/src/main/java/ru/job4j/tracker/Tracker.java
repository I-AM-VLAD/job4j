package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private int position = 0;
    private final Item[] items = new Item[100];

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
        for (int index = 0; index < items.length; index++) {
            Item temp = items[index];
            if((temp != null) && (temp.getId().equals(id))) {
                return temp;
            }
        }
        return null;
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

