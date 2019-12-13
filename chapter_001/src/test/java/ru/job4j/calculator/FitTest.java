package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight () {
        double in = 195;
        double expected = 109.24;
        double out = Fit.manWeight (in);
        Assert.assertEquals (expected, out, 0.01);
    }

    @Test
    public void womanWeight () {
        double in = 165;
        double expected = 63.24;
        double out = Fit.womanWeight (in);
        Assert.assertEquals (expected, out, 0.01);
    }
}

