import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MapTest {
    private static Map map;
    private MapCreator mapCreator;

    @Before
    public void setup() {
        mapCreator = new MapCreatorSafe();
    }

    @After
    public void teardown() {
        map = null;
    }

    @Test
    public void test_singleton_usingMapSize(){
        mapCreator.generateGameMap(5);
        mapCreator.generateGameMap(2);

        Assert.assertEquals(5,map.getMapInstance().size);
    }

    @Test
    public void test_correctMapSize(){
        mapCreator.generateGameMap(5);
        Assert.assertTrue(map.getMapInstance().size == 5);
    }

    @Test
    public void testMap_AllTilesShouldBeATile() {
        map = new SafeMap(5);
        map.generate();

        for(int i = 0; i < map.ReturnMapSize(); i++) {
            for(int j = 0; j < map.ReturnMapSize(); j++) {
                Assert.assertThat(map.getTileType(i, j),
                        anyOf(is(Map.Tile.GRASS), is(Map.Tile.TREASURE), is(Map.Tile.WATER)));
            }
        }
    }

    @Test
    public void testChangeMapSize_() {
        int x = 3;
        map = new SafeMap(x);
        Assert.assertEquals(x, map.ReturnMapSize());

        int y = 4;
        map.SetMapSize(y);
        Assert.assertEquals(y, map.ReturnMapSize());

    }
}
