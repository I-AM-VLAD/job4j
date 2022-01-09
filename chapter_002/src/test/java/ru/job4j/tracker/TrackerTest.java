package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);

        Item result = tracker.findById(item.getId());

        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void theFindById() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("object1");
        tracker.add(item1);

        Item item2 = new Item("object2");
        tracker.add(item2);

        Item item3 = new Item("object3");
        tracker.add(item3);

        String in = item2.getId();
        Item result = tracker.findById(in);

        assertThat(result.getName(), is(item2.getName()));
    }

    @Test
    public void theFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("object1");
        tracker.add(item1);

        Item item2 = new Item("object2");
        tracker.add(item2);

        Item item3 = new Item("object3");
        tracker.add(item3);

        Item[] expected = new Item[3];
        expected[0] = item1;
        expected[1] = item2;
        expected[2] = item3;

        Item[] result = tracker.findAll();

        assertThat(result, is(expected));
    }

    @Test
    public void theFindByName() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("object1");
        tracker.add(item1);

        Item item2 = new Item("object2");
        tracker.add(item2);

        Item item3 = new Item("object1");
        tracker.add(item3);

        Item[] expected = new Item[2];
        expected[0] = item1;
        expected[1] = item3;

        Item[] result = tracker.findByName("object1");

        assertThat(result, is(expected));
    }
}


