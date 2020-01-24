package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        Point in1 = new Point(0, 0);
        Point in2 = new Point(0, 2);
        double expected = 2;
        double out = in1.distance(in2);
        Assert.assertEquals(expected, out, 0.01);
    }
}
