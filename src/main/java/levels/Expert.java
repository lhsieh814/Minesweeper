package levels;

public class Expert implements Minesweeper {

    private int length = 16;
    private int height = 30;
    private int bombs = 99;

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getBombs() {
        return bombs;
    }

    @Override
    public void check() {

    }
}
