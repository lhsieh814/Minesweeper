

import levels.Beginner;
import game.Board;
import game.Minesweeper;
import gui.MinesweeperFrame;

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

    }

}
