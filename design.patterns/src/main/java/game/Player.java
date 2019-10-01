package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    private String[][] fields;
    private String symbol;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Player(String[][] fields, String symbol) {
        this.fields = fields;
        this.symbol = symbol;
    }

    private String name;

    public void play() {


        if (checkFiled(fields, getIntegerFromConsole(), getIntegerFromConsole())) {

        }
    }

    private int getIntegerFromConsole() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getIntegerFromConsole();
    }

    private boolean checkFiled(String[][] fields, int x, int y) {
        return false;
    }

}
