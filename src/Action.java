public class Action {
    private State state;
    private Enum_direction direction;
    private int moveCol;
    private int moveRow;
    public Action(State state2 , Enum_direction enumDirection , int row , int col){
        System.out.println("hi9");
        this.state = state2;
        this.direction = enumDirection;
        this.moveRow = row;
        this.moveCol = col;
    }

    public String toString(){
        System.out.println("hi10");
        String str = new String("Move " + state.getBoard().getBoardPlace(moveRow, moveCol) + " " +direction.name().toLowerCase());

        /*switch (direction){
            case UP:
                if (emptyRow + 1 < state.getBoard().getRowLength()) {
                    str = "Move " + state.getBoard().getBoardPlace(emptyRow + 1, emptyCol) + " up";
                    break;
                }
            case DOWN:
                if (emptyRow - 1 >= 0 ) {
                    str = "Move " + state.getBoard().getBoardPlace(emptyRow - 1, emptyCol) + " down";
                    break;
                }
            case LEFT:
                if(emptyCol + 1 < state.getBoard().getColLength() ) {
                    str = "Move " + state.getBoard().getBoardPlace(emptyRow , emptyCol + 1) + " left";
                    break;
                }
            case RIGHT:
                if(emptyCol - 1 >= 0  ) {
                    str = "Move " + state.getBoard().getBoardPlace(emptyRow , emptyCol - 1) + " right";
                    break;
                }
        }*/
        return  str;
    }

    public Enum_direction getEnum(){
        return this.direction;
    }

    public int getMoveRow(){
        return this.moveRow;
    }

    public int getMoveCol(){
        return this.moveCol;
    }
}
