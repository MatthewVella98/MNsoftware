public class MapCreatorHazardous implements MapCreator{

    public void generateGameMap(int sizeOfMap)
    {
        Map hazardousMap = new HazardousMap(sizeOfMap);
        hazardousMap.generate();
    }
}