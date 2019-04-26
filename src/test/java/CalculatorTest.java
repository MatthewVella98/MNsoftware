import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }
    @After
    public void teardown(){
        calc = null;
    }

    @Test
    public void testAdd_testTwoNegatives_shouldBeAdded(){
        Assert.assertEquals(-5,calc.add(-2,-3));
    }
    @Test
    public void testAdd_testOnePosOneNeg_shouldAdd(){
        Assert.assertEquals(-1,calc.add(3,-4));
    }
    @Test
    public void testAdd_testOneNegOnePos_shouldAdd(){
        Assert.assertEquals(-1,calc.add(-4,3));
    }
    @Test
    public void testAdd_testTwoPos_shouldAdd(){
        Assert.assertEquals(5,calc.add(3,2));
    }
    @Test
    public void testDivide_testByZero_shouldReturnZero(){
        Assert.assertEquals(-999, calc.divide(100,0));
    }

}
