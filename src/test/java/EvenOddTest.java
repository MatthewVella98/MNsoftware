import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvenOddTest {

    private EvenOdd evenodd;
    @Before
    public void setup(){
        evenodd = new EvenOdd();
    }
    @After
    public void teardown(){
        evenodd = null;
    }

    @Test
    public void testIsEven_givenEven_true (){
        Assert.assertEquals(evenodd.isEven(2),true);
    }
    @Test
    public void testIsEven_givenEven_false () {
        Assert.assertEquals(evenodd.isEven(1),false);
    }
    @Test
    public void testIsOdd_givenEven_false () {
        Assert.assertEquals(evenodd.isOdd(2),false);
    }
    @Test
    public void testIsOdd_givenOdd_true () {
        Assert.assertEquals(evenodd.isOdd(1),true);
    }

}
