public class Position {
    private int x;
    private int y;

    //Constructors
    public Position(){ }

    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }

    //Getters & Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Sets a random position and returns it.
    public static Position SetReturnPosition(int size){
        Position position = new Position();

        position.x = (int)(Math.random() * size) ;
        position.y = (int)(Math.random() * size) ;

        return position;
    }

    //Hold Initial Position
    public Position HoldInitialPosition(){
        return new Position(x,y);
    }

}