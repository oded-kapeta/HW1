import java.util.Arrays;

public class Board {
    private Tile [][] tiles;
    public Board(String gameBoard){
        String [] firstSplit = gameBoard.split("|");
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
     public int getRowLength(){
        return tiles.length;
     }
    public int getColLength(){
        return tiles[0].length;
    }
    public int getBoardPlace(int row, int col){
        return tiles[row][col].getTileNumber();
    }

    public void swapBoard(Action action){
        int colForSwap = action.getEmptyCol();
        int rowForSwap = action.getEmptyRow();
        Enum_direction enumDirection = action.getEnum();
        Tile temp;
        switch (enumDirection){
            case UP:
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap+1][colForSwap];
                tiles[rowForSwap+1][colForSwap] = temp;
                break;
            case DOWN:
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap-1][colForSwap];
                tiles[rowForSwap-1][colForSwap] = temp;
                break;
            case RIGHT:
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap][colForSwap-1];
                tiles[rowForSwap][colForSwap-1] = temp;
            case LEFT:
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap][colForSwap+1];
                tiles[rowForSwap][colForSwap+1] = temp;
        }
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

