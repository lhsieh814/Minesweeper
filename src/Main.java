import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
        Minesweeper minesweeper = new Beginner();
		Board board = new Board(minesweeper);
        board.printOut();

        System.out.println();

        board.plantBombs();
        board.printOut();

        System.out.println();

        board.generateNumbers();
        board.printOut();

        MinesweeperFrame minesweeperFrame = new MinesweeperFrame();

        minesweeperFrame.setTitle("Minesweeper");
        minesweeperFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        minesweeperFrame.setSize(500, 500);
        minesweeperFrame.setVisible(true);
        minesweeperFrame.setBackground(Color.white);

	}

}
