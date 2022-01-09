package ru.job4j.singleton.trackerSingle1;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public enum TrackerSingle {
    INSTANCE;
    Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(String id, Item item) {
       return tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public Item findById(String id) {
        return tracker.findById(id);
    }

    public static void main(String[] args) {
        TrackerSingle tracker = TrackerSingle.INSTANCE;
    }

}
