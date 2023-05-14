import java.util.Arrays;

public class Board {
    public Tile [][] board;
    public Board(String gameBoard){
        String [] firstSplit = gameBoard.split("|");
        board = new Tile[firstSplit.length][firstSplit[0].length() - ((firstSplit[0].length())/2)];
        for (int i = 0; i < firstSplit.length; i++){
            String [] secondSplit = firstSplit[i].split(" ");
            for (int j = 0; j < secondSplit.length; j++){
                board[i][j] = new Tile(secondSplit[j]);
            }
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

