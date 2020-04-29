package ru.job4j.singleton.trackerSingle3;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle {
    Tracker tracker = new Tracker();

    // Singleton
    private static final TrackerSingle INSTANCE = new TrackerSingle();
    private TrackerSingle() {
    }
    public static TrackerSingle getInstance() {
        return INSTANCE;
    }


    // Добавление
    public Item add(Item item) {
        return tracker.add(item);
    }
    // Правка
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }
    // Удаление
    public boolean delete(String id) {
        return tracker.delete(id);
    }
    // Все заявки
    public Item[] findAll() {
        return tracker.findAll();
    }
    // Поиск по имени
    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }
    // Поиск по ID
    public Item findById(String id) {
        return tracker.findById(id);
    }


    public static void main(String[] args) {
        TrackerSingle tracker = TrackerSingle.getInstance();
    }
}

