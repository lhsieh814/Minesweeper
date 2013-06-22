package game;

public class Status {
	
	public static final int EMPTY = 0;
	public static final int BOMB = -1;

    public static int bombCount;
    public static int numCount;

    public boolean gameOver;

    public Status(Board board) {
        bombCount = board.getBombs();
        numCount = board.getTotal() - bombCount;
        gameOver = false;

    }
    
    public void reset() {
    	
    }



}
