package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        // ввод пользователя
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);

        Tracker tracker = new Tracker();
                ///////
        StartUI.addNewItem(input, tracker);
        Item created = tracker.findAll()[0];

        Item expected = new Item("Fix PC");

        // сравнение
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        // входные данные
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        // выходные данные
        StartUI. editItem(new StubInput(answers), tracker);
        // ожидаемые данные
        Item replaced = tracker.findById(item.getId());
        // сравнение
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        // входные данные
        Tracker tracker = new Tracker();

        // узел 1
        Item item1 = new Item("new item1");
        tracker.add(item1);

        String temp = item1 .getId();

        ///////////////////////////


        String[] answer   =   {item1 .getId()};


        // выходные данные
        StartUI.          deleteItem       (new StubInput(answer), tracker);

        //////////////////


        Item out = tracker .findById  (   temp    );


        // ожидаемые данные
        Item expected = null;

        // сравнение
         assertThat(out, is(expected));
    }
}

