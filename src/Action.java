public class Action {
    private Board board;
    private Enum_direction direction;
    private int emptyCol;
    private int emptyRow;
    public Action(Enum_direction enumDirection , int row , int col){
        this.direction = enumDirection;
        this.emptyRow = row;
        this.emptyCol = col;
    }

    public String toString(){
        String str = new String();
        switch (direction){
            case UP:
                str = "Move " + board.getBoardPlace(emptyRow + 1,emptyCol) + " up";
                break;
            case DOWN:
                str = "Move " + board.getBoardPlace(emptyRow-1,emptyCol) + " down";
                break;
            case LEFT:
                str = "Move " + board.getBoardPlace(emptyRow,emptyCol+1) + " left";
                break;
            case RIGHT:
                str = "Move " + board.getBoardPlace(emptyRow,emptyCol-1) + " right";
                break;
        }
        return  str;
    }

    public Enum_direction getEnum(){
        return this.direction;
    }

    public int getEmptyRow(){
        return this.emptyRow;
    }

    public int getEmptyCol(){
        return this.emptyCol;
    }
}
