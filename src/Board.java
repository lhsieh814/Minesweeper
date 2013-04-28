import java.util.Arrays;

public class Board {

	private int length;
	private int height;
	private Space[][] grid;

	public Board(int length, int height) {
		this.length = length;
		this.height = height;
		initializeBoard();
	}
	
	private void initializeBoard(){
		grid = new Space[length][height];
		
		// initialize spaces as EMPTY
		Arrays.fill(grid, new Space(Categorize.Type.EMPTY, 0));
		
	}

}
