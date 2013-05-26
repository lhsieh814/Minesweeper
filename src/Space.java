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

    private Categorize.Type type;
    private int num;

    public Space() {

    }

    public Space(Categorize.Type type, int num) {
        this.type = type;
        this.num = num;
    }

    public Categorize.Type getType() {
        return type;
    }

    public void setType(Categorize.Type type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toString() {
        return Integer.toString(num);
    }
}
