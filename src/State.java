public class State {
    private Board board;
    public State(Board currentBoard){
        this.board = currentBoard;
    }

    public boolean isGoal(){
        int k = 3, row = 0;
        int lastRow = board.getRowLength() - 1;
        int lastCol = board.getColLength() - 1;
        if (!(board.getBoardPlace(lastRow,lastCol).equals("_")))    return false;
        for (int i = 0; i < board.getRowLength();i++){
            for (int j = 0 ; j < board.getColLength(); j++){
                if (board.getBoardPlace(i,j).equals("_") || board.getBoardPlace(i,j+1).equals("_")) break;
                if (Integer.valueOf(board.getBoardPlace(i,j))+1 != Integer.valueOf(board.getBoardPlace(i,j+1))) return false;
            }
        }
        while (row < board.getRowLength()){
            if (Integer.parseInt(board.getBoardPlace(row,0)) != row+3)  return false;
            row++;
        }
        return true;
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
