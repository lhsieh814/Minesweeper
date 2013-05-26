package levels;

import game.Minesweeper;

public class Intermediate implements Minesweeper {

    private int length = 9;
    private int height = 9;
    private int bombs = 10;

    public Intermediate() {

    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getBombs() {
        return bombs;
    }

    public void check() {

    }

}
