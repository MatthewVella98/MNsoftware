import java.util.Random;

public class SafeMap extends Map {

    private static final double WATERTILEPERCENT = 0.1;

    public SafeMap(){
        super();
        this.WaterTilesPercent = WATERTILEPERCENT;
    }

    public SafeMap(int n){
        super(n);
        this.WaterTilesPercent = WATERTILEPERCENT;
    }
    public void generate()
    {
        if(mapInstance == null)
        {
            mapInstance = this;
            generateMap();
            //createMap(waterLimit);
        }
    }
}