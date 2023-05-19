public class Node {
    public int heuristicValue(){
        int counter = 0;
        int i = 0;
        int j = 0;
        for ( i=0, i< getRowLength(),i++)
        {
            for ( j=0, j< getColLength(),j++)
            {
                if(getTile(board[i][j])== 1+getRowLength()*i+j)
                    counter++;
            }
        }
        return counter;
    }

}
