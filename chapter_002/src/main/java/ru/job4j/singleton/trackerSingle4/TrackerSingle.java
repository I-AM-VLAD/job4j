package ru.job4j.singleton.trackerSingle4;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle {
    Tracker tracker = new Tracker();

    private TrackerSingle() {
    }
    public static TrackerSingle getInstance() {
        return Holder.INSTANCE;
    }
    private static final class Holder {
        private static final TrackerSingle INSTANCE = new TrackerSingle();
    }

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
        TrackerSingle tracker = TrackerSingle.getInstance();
    }
}

