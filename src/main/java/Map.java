import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Map
{
    static Map mapInstance;

    public double WaterTilesPercent = 0.3;

    public abstract void generate();

    public enum Tile {
        GRASS,WATER,TREASURE
    }
    private Tile[][] map;
    protected int size;

    //Constructors
    public Map(){}

    public Map(int size){
        this.size = size;
        map = new Tile[size][size];
    }

    public int ReturnMapSize(){
        return size;
    }

    //Returns true if map is set.
    public boolean SetMapSize(int size){
        this.size = size;
        map = new Tile[size][size];
        return true;
    }

    //Generate a random tile.
    public Tile RandomiseTile(){
        Tile tile = (Math.random() < WaterTilesPercent) ?  Tile.WATER :  Tile.GRASS;
        return tile;
    }

    public Tile getTileType(int x, int y){
        return map[x][y];
    }

    public Tile getTileType(Position pos){
        return map[pos.getX()][pos.getY()];
    }

    //Generate each type.
    public void generateMap() {
        boolean valid = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = RandomiseTile();

                // Make sure that there is at least one Grass tile
                if(map[i][j] == Tile.GRASS) {
                    valid = true;
                }
            }
        }

        Random random = new Random();
        // Set treasure
        int x = random.nextInt(size);
        int y = random.nextInt(size);

        map[x][y] = Tile.TREASURE;

        if(!valid) {
            // No grass tiles preset, .: regenerate the map
            generate();
        }
    }

    public static Map getMapInstance(){
        return mapInstance;
    }

}