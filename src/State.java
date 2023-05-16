import java.security.PublicKey;

public class State {
    final int EMPTY_CELL = 95;
    private Board board;
    private Action [] validActions;
    public State(Board currentBoard){
        this.board = currentBoard;
    }

    public boolean isGoal(){
        int k = 1 ,row = 0;
        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        if (board.getBoardPlace(rowLength-1,colLength-1) != 95)    return false;
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
        int [] arr = new int[4];
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
        validActions = new Action[getActionsLength(emptyCellRow,emptyCellCol)];

    }

    public int getActionsLength(int row, int col){
        int counter = 0;
        int rowLength = board.getRowLength();
        int colLength = board.getColLength();
        if (row + 1 < rowLength)    counter++;
        if (row - 1 >= 0)   counter++;
        if (col + 1 < colLength)    counter++;
        if (col - 1 >= colLength)   counter++;
        return counter;

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
