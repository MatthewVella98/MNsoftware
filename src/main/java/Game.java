import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int turns;
    private List<boolean[][]> playerStops;
    private Player[] players;
    private Map map;
    private int noOfPlayers;
    private int sizeOfMap;
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args){
        Game game = new Game();
        game.startGame();
    }

    public void startGame(){
        while(true){
            //No of players.
            noOfPlayers = GetNoOfPlayers();

            //Get Map size.
            sizeOfMap = GetMapSize();

            //Generate map
            map = new Map(sizeOfMap);
            map.generate();

            //Create new players
            CreateNewPlayers();

            //Players movement
            PlayersMovement();

            //Winners
            CheckForWinner();  //Play again if win.

            if(!Rematch()) {
                break;
            }
        }
    }

    private int GetNoOfPlayers() {
        int num = -100;

        while(true) {
            try{
                System.out.println("Players No: ");
                if(sc.hasNextInt()) {
                    num = sc.nextInt();

                    if(num >= 2 && num <= 8) {
                        return num;
                    }
                }
            }catch(InputMismatchException e){
                System.err.println("Error: out of bounce -> 2-8. ");
                sc.next();
            }
        }
    }

    private int GetMapSize() {
        int size;
        while(true) {
            try{
                System.out.println("Enter size of square map: ");
                if(sc.hasNextInt()) {
                    size = sc.nextInt();

                    if(noOfPlayers <=4) {
                        if(size >= 5 && size <= 50) {
                            return size;
                        }
                    } else {
                        if(size >= 8 && size <= 50) {
                            return size;
                        }
                    }
                }
            }catch(InputMismatchException e){
                sc.next();
            }

            System.out.println("Enter a valid map number");
        }
    }

    public void CreateNewPlayers()
    {
        players = new Player[noOfPlayers];
        playerStops = new ArrayList<boolean[][]>();
        for(int i = 0; i < players.length; i++) {

            Position pos = Position.SetReturnPosition(sizeOfMap);
            while(map.getTileType(pos.getX(),pos.getY()) != Map.Tile.GRASS) {
                pos = Position.SetReturnPosition(sizeOfMap);
            }

            players[i] = new Player(pos);

            boolean[][] visited = new boolean[sizeOfMap][sizeOfMap];
            visited[pos.getX()][pos.getY()] = true;
            playerStops.add(visited);

        }
    }

    public void PlayersMovement(){
        boolean playersWon = false;
        while(!playersWon) {
            generateHTMLFiles();

            GetNextMoves();

            for(int i = 0; i < noOfPlayers; i++) {
                Position pos = players[i].getPosition();
                playerStops.get(i)[pos.getX()][pos.getY()] = true;

                Map.Tile tile = ReturningPosition(i);
                if(tile == Map.Tile.WATER) {
                    players[i].GoToInitialPosition();
                } else if (tile == Map.Tile.TREASURE) {
                    // Treasure found
                    playersWon = true;
                    break;
                }
            }
        }
    }

    public void CheckForWinner(){
        for(int i = 0; i < noOfPlayers; i++) {
            Map.Tile tile = ReturningPosition(i);
            generateHTMLFiles();
            if (tile == Map.Tile.TREASURE) {
                System.out.println("Player no: " + (i + 1) + " won.");
            }
        }
    }
    private boolean Rematch() {
        while(true) {
            System.out.println("Rematch ? Y/N");

            String input = sc.next();

            if(Character.toLowerCase(input.charAt(0)) == 'y') {
                return true;
            } else if(Character.toLowerCase(input.charAt(0)) == 'n') {
                return false;
            }

            System.err.println("Error: Enter y/n. ");
        }
    }

    private void GetNextMoves() {
        System.out.println("Enter Move: [U]p, [D]own, [L]eft, [R]ight");
        for(int i = 0; i < noOfPlayers; i++) {
            System.out.print("Player no: " + (i + 1) +  " ");
            Player.Move move = GetPlayersMove();

            Position currentPosition = players[i].getPosition();
            switch (move) {
                case UP:
                    if(currentPosition.getY() + 1 < sizeOfMap) {
                        players[i].move(Player.Move.UP);
                    } else {
                        System.out.println("Out of map.");
                    }

                    break;
                case DOWN:
                    if(currentPosition.getY() - 1 >= 0) {
                        players[i].move(Player.Move.DOWN);
                    } else {
                        System.out.println("Out of map.");
                    }
                    break;
                case LEFT:
                    if(currentPosition.getX() - 1 >= 0) {
                        players[i].move(Player.Move.LEFT);
                    } else {
                        System.out.println("Out of map.");
                    }

                    break;
                case RIGHT:
                    if(currentPosition.getX() + 1 < sizeOfMap) {
                        players[i].move(Player.Move.RIGHT);
                    } else {
                        System.out.println("Out of map.");
                    }

                    break;
                default:
                    throw new RuntimeException("Wrong move.");
            }
        }
    }
    private Player.Move GetPlayersMove() {
        while(true) {
            System.out.println("Move:");
            String movement = sc.next();

            char move = movement.charAt(0);
            move = Character.toLowerCase(move);

            if(move == 'u') {
                return Player.Move.UP;
            } else if(move == 'd') {
                return Player.Move.DOWN;
            } else if(move == 'l') {
                return Player.Move.LEFT;
            } else if(move == 'r') {
                return Player.Move.RIGHT;
            }

            System.err.println("Please enter a correct move. ");
        }
    }

    private Map.Tile ReturningPosition(int player) {
        return map.getTileType(players[player].getPosition().getX(),players[player].getPosition().getX());
    }

    public boolean SetNumPlayers(int n){
        return false;
    }

    public void generateHTMLFiles(){
        StringBuilder header = new StringBuilder();

        header.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Loop Game</title>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "    border: 1px solid black;  \n" +
                "} \n" +
                "th, td {\n" +
                "    background-color: lightgrey \n" +
                "} \n" +
                "table {    \n" +
                "    table-layout: fixed;\n" +
                "    width: "+sizeOfMap*100+"px;\n" +
                "    height: "+sizeOfMap*100+"px;\n" +
                "    border: 1px solid black;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".GRASS {\n" +
                "    background-color: green;\n" +
                "}\n" +
                ".WATER {\n" +
                "    background-color: blue;\n" +
                "}\n" +
                ".TREASURE {\n" +
                "    background-color: yellow;\n" +
                "}\n" +
                "\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n");

        for(int player = 0; player < noOfPlayers; player++) {
            StringBuilder html = new StringBuilder();
            // Header
            html.append(header);

            html.append("<h1>Player " + (player + 1) + "</h1>");// + " position: " + players[player].getPosition().x + ", " + players[player].getPosition().y);

            html.append("<table cellspacing=\"0\" cellpadding=\"0\">\n");

            for (int j = sizeOfMap - 1; j >= 0; j--) {
                html.append("<tr>\n");
                for (int i = 0; i < sizeOfMap; i++) {
                    if (playerStops.get(player)[i][j]) {
                        html.append("\t<td class=\"" + map.getTileType(i, j) + "\" align=\"center\">");
                        if (players[player].getPosition().getX() == i && players[player].getPosition().getY() == j) {
                            html.append("Player.</td>\n");
                        } else {
                            html.append("</td>\n");
                        }
                    } else {
                        html.append("\t<td></td>\n");
                    }
                }
                html.append("\n</tr>\n");
            }

            html.append("\n</table>" +
                    "\n</body>");

            // Write to file
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("player_map_" + (player + 1) + ".html"));
                writer.write(html.toString());
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}