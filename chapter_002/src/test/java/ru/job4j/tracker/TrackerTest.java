package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test  // ДОБАВЛЕНИЕ заявок
    public void whenAddNewItemThenTrackerHasSameItem() {
        // входные данные
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        // выходные данные
        Item result = tracker.findById(item.getId());
        // сравнение                 // ожидаемые данные
        assertThat(result.getName(), is(item.getName()));
    }

    @Test  // получение заявки по ID
    public void theFindById() {
        // входные данные
       // Добавляем элементы в массив
        Tracker tracker = new Tracker();
        Item item1 = new Item("object1");
        tracker.add(item1);
       // еще добавляем

        Item item2 = new Item("object2");
        tracker.add(item2);
       // еще
        Item item3 = new Item("object3");
        tracker.add(item3);

        // выходные данные
        String in = item2.getId();
        Item result = tracker.findById(in);

        // сравнение
       // сравниваем                   // ожидаемые данные
        assertThat(result.getName(), is(item2.getName()));
    }


    @Test  // получение списка ВСЕХ заявок
    public void theFindAll() {
        // входные данные
        // Добавляем элементы в массив
        Tracker tracker = new Tracker();
        Item item1 = new Item("object1");
        tracker.add(item1);
        // еще добавляем
        Item item2 = new Item("object2");
        tracker.add(item2);
        // еще
        Item item3 = new Item("object3");
        tracker.add(item3);

        // ожидаемые данные
        Item[] expected = new Item[3];
        expected[0] = item1;
        expected[1] = item2;
        expected[2] = item3;

        // выходные данные
        Item[] result = tracker.findAll();

        // сравнение
        assertThat(result, is(expected));
    }

    @Test  // получение списка по ИМЕНИ
    public void theFindByName() {
        // входные данные
        // Добавляем элементы в массив
        Tracker tracker = new Tracker();
        Item item1 = new Item("object1");
        tracker.add(item1);
        // еще добавляем
        Item item2 = new Item("object2");
        tracker.add(item2);
        // еще
        Item item3 = new Item("object1");
        tracker.add(item3);

        // ожидаемые данные
        Item[] expected = new Item[2];
        expected[0] = item1;
        expected[1] = item3;

        // выходные данные
        Item[] result = tracker.findByName("object1");

        // сравнение
        assertThat(result, is(expected));
    }
}


