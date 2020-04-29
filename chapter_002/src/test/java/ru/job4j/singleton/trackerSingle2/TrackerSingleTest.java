package ru.job4j.singleton.trackerSingle2;

import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {
    @Test
    public void whenOk() {
        TrackerSingle tracker = TrackerSingle.getInstance();
        Item item = new Item("Влад");
        tracker.add(item);
        TrackerSingle tracker1 = TrackerSingle.getInstance(); ;
        assertThat(tracker, is(tracker1));
    }
}
