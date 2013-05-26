package game;

import java.util.Arrays;
import java.util.Random;

public class Board {

    private int length;
    private int height;
    private int bombs;
    private int total;
    private Space[][] game;

    public Board(Minesweeper minesweeper) {
        this.length = minesweeper.getLength();
        this.height = minesweeper.getHeight();
        this.bombs = minesweeper.getBombs();
        this.total = length * height;
        initializeBoard();
    }

    // Initialize total as EMPTY
    private void initializeBoard() {
        game = new Space[length][height];

        for (int i = 0; i < height; i++) {
            Arrays.fill(game[i], new Space(Categorize.Type.EMPTY, 0));
        }

    }

    // Randomly plant bombs
    public void plantBombs() {
        Random random = new Random();
        for (int i = 0; i < bombs; i++) {
            int j = random.nextInt(total);
            int h = j / length;
            int l = j % length;
            while (game[l][h].getType() == Categorize.Type.BOMB) {
                j = random.nextInt(total);
                h = j / length;
                l = j % length;
            }
            game[l][h] = new Space(Categorize.Type.BOMB, -1);
        }
    }

    // Generate numbers
    public void generateNumbers() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                // Not a bomb, then calculate number
                if (game[x][y].getType() != Categorize.Type.BOMB) {
                    int count = 0;
                    // Go around space
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            // Make sure not checking an out-of-bound space
                            if (i >= 0 && i != length && j >= 0 && j != height) {
                                if (game[i][j].getType() == Categorize.Type.BOMB) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count != 0) {
                        game[x][y] = new Space(Categorize.Type.NUMBER, count);
                    }
                }
            }

        }
    }

    // Print out the game numbers
    public void printOut() {
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < length; i++) {
                System.out.print(game[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
