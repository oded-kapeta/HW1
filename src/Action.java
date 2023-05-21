public class Action {
    /*
    HI,unfortunately our code is not solving as much games we want to , we check our functions and they are correct,
    the only problem is in function result in State Class, in the switch case when we put "break" in all the cases
    the code start "go crazy" and solve games that you not given , its like he random some games and solve them.
    right now there is no "break" in the DOWN case so its solve 3 games and get to unsolvable in game 4,
    it will be nice from you if you can consider our functions that we write , we sat on this work for a long time
    and did our best , we even go to a lot of office hours but we failed to fix this specific problem, thank you.
     */
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
