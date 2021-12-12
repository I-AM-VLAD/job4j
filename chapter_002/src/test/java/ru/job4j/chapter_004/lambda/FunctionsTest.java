package ru.job4j.chapter_004.lambda;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;
public class FunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {

        List<Double> result = Functions.diapason(5, 7, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSquareFunction() {

        List<Double> result = Functions.diapason(5, 7, x -> Math.pow(x,2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {

        List<Double> result = Functions.diapason(1, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}
