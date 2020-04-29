package ru.job4j.singleton.trackerSingle1;

import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {
    @Test
    public void whenOk() {
        TrackerSingle tracker = TrackerSingle.INSTANCE;
        Item item = new Item("Влад");
        tracker.add(item);
        TrackerSingle tracker1 = TrackerSingle.INSTANCE;
        assertThat(tracker, is(tracker1));
    }
}
