package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator {
    Calculator c;
    @Before
    public void before(){
        c = new Calculator();
    }

    @Test
    public void calc(){
        assertEquals(6,c.add("1,2:3"));
        assertEquals(6,c.add("//]\n1]2]3"));
    }
    @Test(expected = RuntimeException.class)
    public void testThrowException(){
        c.add("1,-2:3");
    }
}
