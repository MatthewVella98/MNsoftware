import java.util.ArrayList;
import java.util.List;

public class Map {
    private enum Tile {
        GRASS,WATER,TREASURE
    }
    private Tile[][] map;
    private int size;

    //Constructors
    public Map(){}

    public Map(int size){
        this.size = size;
        map = new Tile[size][size];
    }

    //Returns true if map is set.
    public boolean SetMapSize(int size){
        this.size = size;
        map = new Tile[size][size];
        return true;
    }

    //Generate a random tile.
    public Tile RandomiseTile(){
        Tile tile = (Math.random() < 0.25) ?  Tile.WATER :  Tile.GRASS;
        return tile;
    }

    //Generate each type.
    public void generate(){
        List<Boolean> list = new ArrayList<Boolean>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = RandomiseTile();

                if(map[i][j] == Tile.GRASS) {
                    list.add(true);
                }
            }
        }

        //Treasure
        int x = (int)(Math.random() * size) + 1;
        int y = (int)(Math.random() * size) + 1;

        map[x][y] = Tile.TREASURE;

        //At least, 33% of the MAP has to be GRASS.
        if(list.size() < (size * 0.33))
            generate();
    }

    public Tile getTileType(int x,int y){
        return map [x][y];
    }


}