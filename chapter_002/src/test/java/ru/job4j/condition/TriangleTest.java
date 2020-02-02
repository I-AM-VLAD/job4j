package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void trAreaExist() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 0);
        Triangle triangle = new Triangle(p1, p2, p3);
        double out = triangle.area();
        double expected = 1.99;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void trAreaNoExist() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(40, 40);
        Point p3 = new Point(1, 1);
        Triangle triangle = new Triangle(p1, p2, p3);
        double out = triangle.area();
        double expected = -1;
        Assert.assertEquals(expected, out, 0.01);
    }
}

