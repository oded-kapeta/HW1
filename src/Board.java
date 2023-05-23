import java.util.Arrays;
import java.util.regex.Pattern;

public class Board {
    private Tile [][] tiles;

    /**
     * first constructor to board from getting a string
     * @param gameBoard
     */
    public Board(String gameBoard){
        String [] firstSplit = gameBoard.split(Pattern.quote("|"));
        String [] firstSplit2 = firstSplit[0].split(" ");
        tiles = new Tile[firstSplit.length][firstSplit2.length];
        for (int i = 0; i < firstSplit.length; i++){
            String [] secondSplit = firstSplit[i].split(" ");
            for (int j = 0; j < secondSplit.length; j++){
                if (secondSplit[j].charAt(0) == '_'){
                    tiles[i][j] = new Tile(0);
                }else {
                    tiles[i][j] = new Tile(Integer.valueOf(secondSplit[j]));
                }
            }
        }
    }

    /**
     * the constructor that getting a board and copy him
     * @param board2
     */
    public Board(Board board2){
        int row = board2.getRowLength();
        int col = board2.getColLength();
        tiles = new Tile[row][col];
        for (int i = 0;i < row;i++){
            for (int j = 0 ; j < col;j++){
                tiles[i][j] = new Tile(board2.getBoardPlace(i,j));
            }
        }
    }


    /**
     * return the row length of the board
     * @return
     */
     public int getRowLength(){
        return tiles.length;
     }

    /**
     * return the column length of the board
     * @return
     */
    public int getColLength(){
        return tiles[0].length;
    }

    /**
     * return the value in place in the board
     * @param row
     * @param col
     * @return
     */
    public int getBoardPlace(int row, int col){
        return tiles[row][col].getTileNumber();
    }

    /**
     * this function get action and destinations and swap the origin places(that in Action) value with the destinations value
     * @param action
     * @param destinationrow
     * @param destinationcol
     */
    public void swapBoard(Action action,int destinationrow,int destinationcol){
        int colForSwap = action.getMoveCol();
        int rowForSwap = action.getMoveRow();
        Tile temp;
        temp = tiles[rowForSwap][colForSwap];
        tiles[rowForSwap][colForSwap] = tiles[destinationrow][destinationcol];
        tiles[destinationrow][destinationcol] = temp;
    }


    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles,board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}

