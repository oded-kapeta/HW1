public class Action {
    private Enum_direction direction;
    private int emptyCol;
    private int emptyRow;
    public Action(Enum_direction enumDirection , int row , int col){
        this.direction = enumDirection;
        this.emptyRow = row;
        this.emptyCol = col;
    }

    public String toString()
    {
        String str = "move"


    }

    public Enum_direction getenum(){
        return this.direction;
    }

    public int getEmptyRow(){
        return this.emptyRow;
    }

    public int getEmptyCol(){
        return this.emptyCol;
    }
}
