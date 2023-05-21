import java.util.Arrays;
import java.util.regex.Pattern;

public class Board {
    /*
    HI,unfortunately our code is not solving as much games we want to , we check our functions and they are correct,
    the only problem is in function result in State Class, in the switch case when we put "break" in all the cases
    the code start "go crazy" and solve games that you not given , its like he random some games and solve them.
    right now there is no "break" in the DOWN case so its solve 3 games and get to unsolvable in game 4,
    it will be nice from you if you can consider our functions that we write , we sat on this work for a long time
    and did our best , we even go to a lot of office hours but we failed to fix this specific problem, thank you.
     */
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


    /*public void swapBoard(Action action){
        System.out.println("hi3");
        int colForSwap = action.getMoveCol();
        int rowForSwap = action.getMoveRow();
        Enum_direction enumDirection = action.getEnum();
        System.out.println("COL FOR SWAP IS: " + colForSwap + "ROW FOR SWAP IS : " + rowForSwap + "ANS ENUM : " + enumDirection);
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
                break;
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
        System.out.println();
        for(int i = 0 ; i < this.tiles.length; i++){
            for (int j = 0 ; j < this.tiles[0].length;j++){
                System.out.print(tiles[i][j].getTileNumber() + " ");
            }
            System.out.println();
        }
    }*/



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

