package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest
{
    @Test
    public void maxFirst ()
    {
        int result = SqMax.max (4, 2, 3, 1);
        assertThat (result, is (4));
    }
    @Test
    public void maxSecond ()
    {
        int result = SqMax.max (1, 4, 2, 3);
        assertThat (result, is (4));
    }
    @Test
    public void maxThird ()
    {
        int result = SqMax.max (1, 2, 4, 3);
        assertThat (result, is (4));
    }
    @Test
    public void maxForth ()
    {
        int result = SqMax.max (1, 2, 3, 4);
        assertThat (result, is (4));
    }
}
