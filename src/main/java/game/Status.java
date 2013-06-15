package game;

public class Status {

    public static int bombCount;
    public static int numCount;

    public boolean gameOver;

    public Status(Board board) {
        bombCount = board.getBombs();
        numCount = board.getTotal() - bombCount;
        gameOver = false;

    }



}
