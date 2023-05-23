public class State {
    /*
    HI,unfortunately our code is not solving as much games we want to , we check our functions and they are correct,
    the only problem is in function result in State Class, in the switch case when we put "break" in all the cases
    the code start "go crazy" and solve games that you not given , its like he random some games and solve them.
    right now there is no "break" in the DOWN case so its solve 3 games and get to unsolvable in game 4,
    it will be nice from you if you can consider our functions that we write , we sat on this work for a long time
    and did our best , we even go to a lot of office hours but we failed to fix this specific problem, thank you.
     */
    final int EMPTY_CELL = 0;
    private Board board;

    /**
     * constructor to state that getting a board
     * @param currentBoard
     */
    public State(Board currentBoard){
        this.board = currentBoard;
    }

    /**
     * this function checks if we in our goal board
     * @return true or false
     */
    public boolean isGoal(){
        int k = 1 ,row = 0;
        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        if (board.getBoardPlace(rowLength-1,colLength-1) != EMPTY_CELL)    return false;
        for (int i = 0; i < rowLength;i++){
            for (int j = 0 ; j < colLength; j++){
                //if (board.getBoardPlace(i,j) == EMPTY_CELL || board.getBoardPlace(i,j+1) == EMPTY_CELL) break;
                if((i == rowLength-1 && (j==colLength-1 || j==colLength-2)))   break;
                if (j >= colLength-1) continue;
                if (board.getBoardPlace(i, j) + 1 != board.getBoardPlace(i, j + 1)) return false;
            }
        }
        while (row < board.getRowLength()){
            if (board.getBoardPlace(row,0) != k)  return false;
            row++;
            k+=colLength;
        }
        return true;
    }

    /**
     * this function checks how much actions from UP,DOWN,LEFT,RIGHT we can do from our state
     * @return an array of Action
     */
    public Action[] actions(){
        int emptyCellRow = 0 , emptyCellCol = 0;
        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        for (int i = 0; i < rowLength;i++){
            for (int j = 0 ; j < colLength; j++){
                if (board.getBoardPlace(i,j) == EMPTY_CELL ){
                    emptyCellRow = i;
                    emptyCellCol = j;
                    break;
                }
            }
        }
        int counterUp = upOk(emptyCellRow,emptyCellCol) ,counterDown = downOk(emptyCellRow,emptyCellCol) ;
        int counterRight = rightOk(emptyCellRow,emptyCellCol),counterLeft = leftOk(emptyCellRow,emptyCellCol);
        int actionsLength = getActionsLength(emptyCellRow,emptyCellCol);
        Action [] validActions = new Action[actionsLength];
        for (int i = 0; i < actionsLength; i++){
            if (counterUp == 1){
                validActions[i] = new Action(this,Enum_direction.UP, emptyCellRow+1, emptyCellCol);
                counterUp = 0;
            }else if (counterDown == 1){
                validActions[i] = new Action(this,Enum_direction.DOWN , emptyCellRow-1, emptyCellCol);
                counterDown = 0;
            } else if (counterRight == 1) {
                validActions[i] = new Action(this,Enum_direction.RIGHT, emptyCellRow, emptyCellCol - 1);
                counterRight = 0;
            } else if (counterLeft == 1) {
                validActions[i] = new Action(this,Enum_direction.LEFT, emptyCellRow, emptyCellCol + 1);
                counterLeft = 0;
            }
        }
        return validActions;
    }

    /**
     * this function count the number of actions we can do
     * @param row
     * @param col
     * @return
     */
    public int getActionsLength(int row, int col){
        int counter = 0;
        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        if (row + 1 < rowLength)    counter++;
        if (row - 1 >= 0)   counter++;
        if (col + 1 < colLength)    counter++;
        if (col - 1 >= 0)   counter++;
        return counter;

    }

    /**
     * check if action DOWN ok
     * @param row
     * @param col
     * @return
     */
    public int downOk(int row, int col){
        if (row - 1 >= 0)   return 1;
        return 0;
    }

    /**
     * check if action UP ok
     * @param row
     * @param col
     * @return
     */
    public int upOk(int row, int col){
        int rowLength = board.getRowLength();
        if (row + 1 < rowLength )   return 1;
        return 0;
    }

    /**
     * check if action LEFT ok
     * @param row
     * @param col
     * @return
     */
    public int leftOk(int row, int col){
        int colLength = board.getColLength();
        if (col + 1 < colLength)   return 1;
        return 0;
    }

    /**
     * check if action RIGHT ok
     * @param row
     * @param col
     * @return
     */
    public int rightOk(int row, int col){
        if (col - 1 >= 0)   return 1;
        return 0;
    }


    /**
     * this function get an action to do and return the new state the we getting as a result from this action
     * @param action
     * @return
     */
    public State result(Action action) {
        Board board2 = new Board(this.board);
        int emptyrow= 0 , emptycol = 0;
        int moverow = action.getMoveRow(), movecol = action.getMoveCol();
        switch (action.getEnum()) {
            case UP:
                emptyrow = moverow - 1;
                emptycol = movecol;
                break;
            case DOWN:
                emptyrow = moverow + 1;
                emptycol = movecol;
                break;
            case RIGHT:
                emptyrow = moverow;
                emptycol = movecol + 1;
                break;
            case LEFT:
                emptyrow = moverow;
                emptycol = movecol - 1;
                break;
        }
        board2.swapBoard(action, emptyrow, emptycol);
        return new State(board2);
    }



    public  Board getBoard(){
        //System.out.println("hi7");
        return this.board;
    }




    @Override
    public boolean equals(Object other) {
        if (!(other instanceof State)) {
            return false;
        }
        State otherState = (State) other;
        return board.equals(otherState.board);
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
