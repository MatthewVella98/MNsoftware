import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {

    private Position position;

    @Before
    public void setup() {
        position = new Position();
    }

    @After
    public void teardown(){
        position = null;
    }

    @Test
    public void testSetX_shouldBeEqual(){
        int x = 1;
        position.setX(x);
        Assert.assertEquals(x, position.getX());
    }

    @Test
    public void testSetX_NotEqual_shouldBeEqual(){
        int x = 2;
        position.setX(x);
        Assert.assertNotEquals(3,position.getX());
    }

    @Test
    public void testSetY_shouldBeEqual(){
        int y = 2;
        position.setY(y);
        Assert.assertEquals(y, position.getY());
    }

    @Test
    public void testSetY_NotEqual_shouldBeEqual(){
        int y = 2;
        position.setY(y);
        Assert.assertNotEquals(3,position.getY());
    }

    @Test
    public void test_random_pos() {
        int size = 5;

        for(int i = 0; i< 50; i++) {
            position = Position.SetReturnPosition(size);
            Assert.assertTrue(position.getX() < size && position.getX() >= 0);
            Assert.assertTrue(position.getY() < size && position.getY() >=0);
        }
    }
}
