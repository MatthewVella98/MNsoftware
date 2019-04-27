import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoolFunctionsTest{

    private BoolFunctions bool ;

    @Before
    public void setup(){
        bool = new BoolFunctions();
    }
    @After
    public void teardown(){
        bool = null;
    }

    int var=1;
    boolean flag = false;
    String varStr = "hello";
    @Test
    public void testIsValInt (){
        Assert.assertEquals(bool.isSameInt(var ,1),true);
    }
    @Test
    public void testIsValBool () {
        Assert.assertEquals(bool.isSameBool(flag,false),true);
    }
    @Test
    public void testIsValStr () {
        Assert.assertEquals(bool.isSameString(varStr,"hello"),true);
    }

}
