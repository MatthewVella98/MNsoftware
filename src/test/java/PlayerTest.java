import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player(new Position(3,3));
    }

    @After
    public void teardown(){
        player = null;
    }

    @Test
    public void testPlayer_shouldReturnPlayer() {
        Position pos = new Position(2, 5);
        player = new Player(pos);

        Assert.assertEquals(pos.getX(), player.getPosition().getX());
        Assert.assertEquals(pos.getY(), player.getPosition().getY());
    }

    @Test
    public void testMoveUp_ShouldMoveUp() {
        int x = 2, y = 2;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.UP);
        Assert.assertEquals(pos.getX(), player.getPosition().getX());
        Assert.assertEquals(pos.getY(), player.getPosition().getY());

        Assert.assertEquals(x, player.getPosition().getX());
        Assert.assertEquals(y + 1, player.getPosition().getY());
    }

    @Test
    public void testMoveDown_ShouldMoveDown() {
        int x = 2, y = 2;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.DOWN);
        Assert.assertEquals(pos.getX(), player.getPosition().getX());
        Assert.assertEquals(pos.getY(), player.getPosition().getY());

        Assert.assertEquals(x, player.getPosition().getX());
        Assert.assertEquals(y - 1, player.getPosition().getY());
    }

    @Test
    public void testMoveLeft_ShouldMoveLeft() {
        int x = 2, y = 2;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.LEFT);
        Assert.assertEquals(pos.getX(), player.getPosition().getX());
        Assert.assertEquals(pos.getY(), player.getPosition().getY());

        Assert.assertEquals(x - 1, player.getPosition().getX());
        Assert.assertEquals(y, player.getPosition().getY());
    }

    @Test
    public void testMoveRight_ShouldMoveRight() {
        int x = 2, y = 2;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.RIGHT);
        Assert.assertEquals(pos.getX(), player.getPosition().getX());
        Assert.assertEquals(pos.getY(), player.getPosition().getY());

        Assert.assertEquals(x + 1, player.getPosition().getX());
        Assert.assertEquals(y, player.getPosition().getY());
    }


    @Test
    public void testSetPosition_ShouldSetReturnPosition() {
        Position pos = new Position(4, 5);

        player.setPosition(pos);
        Assert.assertEquals(pos, player.getPosition());
    }
}
