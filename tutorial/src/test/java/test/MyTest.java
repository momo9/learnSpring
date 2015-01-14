package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by momo9 on 1/14/2015.
 */
public class MyTest {

    @Test
    public void testEqual() {
        assertEquals(5, 5);
    }

    @Test
    public void testLambda() {
        List<Integer> expected = Arrays.asList(2, 3, 4);
        List<Integer> actual = new ArrayList<>();
        Arrays.asList(1, 2, 3).forEach(
                i -> actual.add(i + 1)
        );
        assertEquals(expected, actual);
    }
}
