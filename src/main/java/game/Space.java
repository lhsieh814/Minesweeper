package game;

/**
 * A space object represents a tile on the board.
 * Each space can be categorized as either one of the type:
 * -EMPTY (numbered 0)
 * -NUMBER (numbered from 1 to 8)
 * -BOMB (numbered -1)
 *
 * @author Lena
 */
public class Space {

    private int num;
    private boolean guess;


	public Space() {

    }

    public Space(int num) {
        this.num = num;
        guess = false;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public boolean isGuess() {
		return guess;
	}

	public void setGuess(boolean guess) {
		this.guess = guess;
	}

    public String toString() {
        return Integer.toString(num);
    }
}
