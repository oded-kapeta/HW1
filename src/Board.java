import java.util.Arrays;
import java.util.regex.Pattern;

public class Board {
    private Tile [][] tiles;

    public Board(String gameBoard){
        System.out.println("hi1");
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
        for (int k = 0; k <tiles.length;k++ ){
            for (int l = 0 ;l < tiles[0].length;l++){
                System.out.print(tiles[k][l].getTileNumber());
            }
            System.out.println();
        }
    }

    public Board(Board board2){
        System.out.println("hi2");
        int row = board2.getRowLength();
        int col = board2.getColLength();
        tiles = new Tile[row][col];
        for (int i = 0;i < row;i++){
            for (int j = 0 ; j < col;j++){
                tiles[i][j] = new Tile(board2.getBoardPlace(i,j));
            }
        }
        /*System.out.println("the copy board is    " );
        for (int i = 0;i < row;i++){
            for (int j = 0 ; j < col;j++){
                System.out.print(tiles[i][j].getTileNumber());
            }
            System.out.println();
        }*/
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
        System.out.println("hi3");
        int colForSwap = action.getMoveCol();
        int rowForSwap = action.getMoveRow();
        Enum_direction enumDirection = action.getEnum();
        Tile temp;
        switch (enumDirection){
            case UP:
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap-1][colForSwap];
                tiles[rowForSwap-1][colForSwap] = temp;
                break;
            case DOWN:
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap+1][colForSwap];
                tiles[rowForSwap+1][colForSwap] = temp;
            case RIGHT:
                System.out.print("HIIIIIIIIIIII");
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap][colForSwap+1];
                tiles[rowForSwap][colForSwap+1] = temp;
                break;
            case LEFT:
                temp = tiles[rowForSwap][colForSwap];
                tiles[rowForSwap][colForSwap] = tiles[rowForSwap][colForSwap-1];
                tiles[rowForSwap][colForSwap-1] = temp;
                break;
        }
        System.out.print("COPY BOARD AFTER SWAP IS :        ");
        for(int i = 0 ; i < this.tiles.length; i++){
            for (int j = 0 ; j < this.tiles[0].length;j++){
                System.out.print(tiles[i][j].getTileNumber());
            }
            System.out.println();
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

