package ru.job4j.chapter_003.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class ItemTest {
    ////////////////////////////////////////////////////////////////////////////
    @Test
    public void whenComparableById() {

        Comparable <Item> cmbId = new Item("Vlad", "bdhttjhg43dg");
        int rsl = cmbId.compareTo(
                new Item("Ivar", "dkgjrkgmrm")
        );

        assertThat(rsl, lessThan(5));
    }

    //////////////////////////////////////////////////////////////////////////////////
    @Test
    public void whenComparatorByName() {

        Comparator<Item> cmpName = new SortByNameItem();
        int rsl = cmpName.compare(
                new Item("Vlad", "bdhttjhg43dg"),
                new Item("Ivar", "dkgjrkgmrm")
        );

        assertThat(rsl, lessThan(15));
    }
    ////////////////////////////////////////////////////////////////////////////
    @Test
    public void whenComparatorByDescName() {

        Comparator<Item> cmpDescName = new ItemDescByName();
        int rsl = cmpDescName.compare(
                new Item("Vlad", "bdhttjhg43dg"),
                new Item("Ivar", "dkgjrkgmrm")
        );

        assertThat(rsl, lessThan(5));
    }
    //////////////////////////////////////////////////////////////////////////////////
}

