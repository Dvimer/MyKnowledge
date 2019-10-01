package game;

import java.util.Currency;
import java.util.List;

public class Game {
    private Field field;
    private List<Player> players;
    private boolean win ;

    public Game(Field field) {
        this.field = field;
    }

    public void start() {
        while (!win) {
            Player currentPlayer = players.get(0);
            currentPlayer.play();
//            players.play();
            field.printField();
            System.out.println("--------------");
        }
    }

}
