public class State {
    final int EMPTY_CELL = 0;
    private Board board;

    public State(Board currentBoard){
        System.out.println("hi4");
        this.board = currentBoard;
    }

    public boolean isGoal(){
        System.out.println("hi5");
        int k = 1 ,row = 0;
        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        if (board.getBoardPlace(rowLength-1,colLength-1) != EMPTY_CELL)    return false;
        for (int i = 0; i < rowLength;i++){
            for (int j = 0 ; j < colLength; j++){
                if (board.getBoardPlace(i,j) == EMPTY_CELL || board.getBoardPlace(i,j+1) == EMPTY_CELL) break;
                if (board.getBoardPlace(i,j) + 1 != board.getBoardPlace(i,j+1)) return false;
            }
        }
        while (row < board.getRowLength()){
            if (board.getBoardPlace(row,0) != k)  return false;
            row++;
            k+=colLength;
        }
        return true;
    }


    public Action[] actions(){
        System.out.println("hi6");
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
        //System.out.println("counter left is:    " + actionsLength);
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
    public int downOk(int row, int col){
        if (row - 1 >= 0)   return 1;
        return 0;
    }

    public int upOk(int row, int col){
        int rowLength = board.getRowLength();
        if (row + 1 < rowLength )   return 1;
        return 0;
    }

    public int leftOk(int row, int col){
        int colLength = board.getColLength();
        if (col + 1 < colLength)   return 1;
        return 0;
    }

    public int rightOk(int row, int col){
        int colLength = board.getColLength();
        if (col - 1 >= 0)   return 1;
        return 0;
    }

    public State result(Action action){
        Board board2 = new Board(this.board);
        board2.swapBoard(action);
        return new State(board2);
    }

    /*public Board result(Action action){
        board.swapBoard(action);
        return board;
    }*/

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
