import java.util.Arrays;

public class Board {
    private Tile [][] board;
    public Board(String gameBoard){
        String [] firstSplit = gameBoard.split("|");
        String [] firstSplit2 = firstSplit[0].split(" ");
        board = new Tile[firstSplit.length][firstSplit2.length];
        for (int i = 0; i < firstSplit.length; i++){
            String [] secondSplit = firstSplit[i].split(" ");
            for (int j = 0; j < secondSplit.length; j++){
                if (secondSplit[j].charAt(0) == '_'){
                    board[i][j] = new Tile(0);
                }else {
                    board[i][j] = new Tile(Integer.valueOf(secondSplit[j]));
                }
            }
        }
    }

    public Board(Board board2){
        int row = board2.getRowLength();
        int col = board2.getColLength();
        board = new Tile[row][col];
        for (int i = 0;i < row;i++){
            for (int j = 0 ; j < col;j++){
                board[i][j] = new Tile(board2.getBoardPlace(i,j));
            }
        }
    }
     public int getRowLength(){
        return board.length;
     }
    public int getColLength(){
        return board[0].length;
    }
    public int getBoardPlace(int row, int col){
        return board[row][col].value();
    }

    public void swapBoard(Action action){
        int colForSwap = action.getEmptyCol();
        int rowForSwap = action.getEmptyRow();
        Enum_direction enumDirection = action.getEnum();
        Tile temp;
        switch (enumDirection){
            case UP:
                temp = board[rowForSwap][colForSwap];
                board[rowForSwap][colForSwap] = board[rowForSwap+1][colForSwap];
                board[rowForSwap+1][colForSwap] = temp;
                break;
            case DOWN:
                temp = board[rowForSwap][colForSwap];
                board[rowForSwap][colForSwap] = board[rowForSwap-1][colForSwap];
                board[rowForSwap-1][colForSwap] = temp;
                break;
            case RIGHT:
                temp = board[rowForSwap][colForSwap];
                board[rowForSwap][colForSwap] = board[rowForSwap][colForSwap-1];
                board[rowForSwap][colForSwap-1] = temp;
            case LEFT:
                temp = board[rowForSwap][colForSwap];
                board[rowForSwap][colForSwap] = board[rowForSwap][colForSwap+1];
                board[rowForSwap][colForSwap+1] = temp;
        }
    }



    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}

