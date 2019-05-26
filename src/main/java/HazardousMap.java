import java.util.Random;

public class HazardousMap extends Map{

    private static final double WATERTILEPERCENT = 0.3;

    public HazardousMap(){
        super();
        this.WaterTilesPercent = WATERTILEPERCENT;
    }

    public HazardousMap(int n){
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
