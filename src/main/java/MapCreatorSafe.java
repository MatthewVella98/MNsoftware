public class MapCreatorSafe implements MapCreator {

    public void generateGameMap(int sizeOfMap)
    {
        Map safeMap = new SafeMap(sizeOfMap);
        safeMap.generate();
    }
}