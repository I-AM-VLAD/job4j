package ru.job4j.chapter_003.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByDeskNameAndDeskPriority() {
        Comparator<Job> cmpDeskNameDeskPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDeskNameDeskPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new SortByNameJob().thenComparing(new SortByPriorityJob());

        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, lessThan(5));
    }
    @Test
    public void whenComparatorByName() {

        Comparator<Job> cmpName = new SortByNameJob();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, lessThan(5));
    }

    @Test
    public void whenComparatorByPriority() {

        Comparator<Job> cmpPriority = new SortByPriorityJob();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, lessThan(5));
    }

    @Test
    public void whenComparatorByDeskName() {

        Comparator<Job> cmpDeskName = new JobDescByName();
        int rsl = cmpDeskName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, lessThan(5));
    }

    @Test
    public void whenComparatorByDeskPriority() {

        Comparator<Job> cmpDeskPriority = new JobDescByPriority();
        int rsl = cmpDeskPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, lessThan(5));
    }
}
