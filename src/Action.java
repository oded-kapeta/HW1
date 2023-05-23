public class Action {
    private State state;
    private Enum_direction direction;
    private int moveCol;
    private int moveRow;

    /**
     * constructor to Action
     * @param state2
     * @param enumDirection
     * @param row
     * @param col
     */
    public Action(State state2 , Enum_direction enumDirection , int row , int col){
        this.state = state2;
        this.direction = enumDirection;
        this.moveRow = row;
        this.moveCol = col;
    }

    /**
     * the overriding of toString()
     * @return
     */
    public String toString(){
        String str = new String("Move " + state.getBoard().getBoardPlace(moveRow, moveCol) + " " +direction.name().toLowerCase());
        return  str;
    }

    /**
     * return the direction we want to do the action
     * @return
     */
    public Enum_direction getEnum(){
        return this.direction;
    }

    /**
     * return the row number of the cell we want to do the action on
     * @return
     */
    public int getMoveRow(){
        return this.moveRow;
    }

    /**
     *      * return the column number of the cell we want to do the action on
     * @return
     */
    public int getMoveCol(){
        return this.moveCol;
    }
}
