import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static java.lang.Double.NaN;

public class TestForCalculate {

    @Test
    public void testMinus()
    {
        Assert.assertEquals(-0.01,Calculation.Minus(0.00, 0.01), 1e-15);
        Assert.assertEquals(-1.60,Calculation.Minus(1, 2.6), 1e-15);
        Assert.assertEquals(59.00,Calculation.Minus(60, 1), 1e-15);
        Assert.assertEquals(99.76434,Calculation.Minus(100.00001, 0.23567), 1e-15);
    }

    @Test
    public void testSum()
    {
        Assert.assertEquals(0.01,Calculation.Sum(0.00, 0.01), 1e-15);
        Assert.assertEquals(3.60,Calculation.Sum(1, 2.6), 1e-15);
        Assert.assertEquals(61.00,Calculation.Sum(60, 1), 1e-15);
        Assert.assertEquals(100.23568,Calculation.Sum(100.00001, 0.23567), 1e-15);
    }

    @Test
    public void testUmno()
    {
        Assert.assertEquals(0,Calculation.Umno(0.00, 0.01), 1e-15);
        Assert.assertEquals(2.60,Calculation.Umno(1, 2.6), 1e-15);
        Assert.assertEquals(119.4,Calculation.Umno(60, 1.99), 1e-15);
        Assert.assertEquals(0,Calculation.Umno(0, 0.0), 1e-15);
    }

    @Test
    public void tesDelen()
    {
        Assert.assertEquals(0,Calculation.Delen(0.00, 0.01), 1e-15);
        Assert.assertEquals(0.3846153846153846,Calculation.Delen(1, 2.6), 1e-15);
        Assert.assertEquals(25,Calculation.Delen(50, 2), 1e-15);
        Assert.assertEquals(NaN,Calculation.Delen(0, 0.0), 1e-15);
    }

    @Test
    public void choiceOperationWithScanner()
    {
        Assert.assertEquals(2,Calculation.choiceOperation((byte) 1,1,1), 1e-15);
        Assert.assertEquals(0,Calculation.choiceOperation((byte) 2,1,1), 1e-15);
        Assert.assertEquals(25,Calculation.choiceOperation((byte) 3,5,5), 1e-15);
        Assert.assertEquals(5,Calculation.choiceOperation((byte) 4,10,2), 1e-15);
    }

}
