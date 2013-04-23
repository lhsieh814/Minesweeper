/**
 * User: lena
 * Date: 2013-04-23
 */

public class Space {

    private Categorize.Type type;
    private int num;

    public Space(){

    }

    public Space(Categorize.Type type, int num){
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
}
