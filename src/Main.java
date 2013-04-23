import java.util.Random;

/**
 * User: lena
 * Date: 2013-04-23
 */

public class Main {

    public static final int LENGTH = 10;
    public static final int HEIGHT = 8;
    public static final int SPACES = LENGTH * HEIGHT;
    public static final int NUM_BOMBS = 10;

    public static void main (String[] args){

        Space[][] grid = new Space[LENGTH][HEIGHT];

        // Initialize grid with EMPTY spaces
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                grid[i][j] = new Space(Categorize.Type.EMPTY, 0);
            }
        }

        Random random = new Random();
        for (int i= 0; i<NUM_BOMBS; i++){
            int j= random.nextInt(SPACES);
            int h = j / LENGTH;
            int l = j % LENGTH;
            grid[l][h] = new Space(Categorize.Type.BOMB, -1);
        }

        toString(grid);

    }

    public static void toString(Space[][] grid){
        for(int i = 0; i<grid.length; i++){
            System.out.println();
            for(int j = 0; j<grid[0].length; j++){
                System.out.print(grid[i][j].getType().toString() + " , ");
            }
        }
    }

}