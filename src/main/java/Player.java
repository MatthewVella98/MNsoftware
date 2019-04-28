import java.util.InputMismatchException;

public class Player {
    private Position position; //Current position
    private Position initPosition; //Initial position

    //Move enums: Can be passed as argument in the switch.
    public enum Move{
        LEFT,RIGHT,UP,DOWN
    }
    //Constructor
    public Player(Position position){
        this.position = position;
        this.initPosition = position.HoldInitialPosition();
    }

    //Move switch.
    public void move(Move move){
        switch(move){
            case LEFT:
                position.setX(position.getX() -1);
                break;
            case RIGHT:
                position.setX(position.getX() +1);
                break;
            case UP:
                position.setY(position.getY() +1);
                break;
            case DOWN:
                position.setY(position.getY() -1);
                break;
            default:
                throw new InputMismatchException("Invalid.");
        }
    }
    //
    public void GoToInitialPosition(){
        position.setX(initPosition.getX());
        position.setY(initPosition.getY());
    }

    //Getters & Setters
    public void setPosition(Position position){
        this.position = position;
    }

    public Position getPosition() {return position; }
}