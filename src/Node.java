public class Node {
    private Node parent;
    private State child;
    private Action action;

    public Node(Node boardFather,State boardKid ,Action action2){
        this.parent = boardFather;
        this.child = boardKid;
        this.action = action2;
    }

    public  Node[] expand(){
        int emptyRow = action.getEmptyRow(),emptyCol = action.getEmptyCol();
        int length = child.getActionsLength(emptyRow,emptyCol);
        Node[] nextNodes = new Node[length];
        int counterUp = child.upOk(emptyRow,emptyCol), counterDown = child.downOk(emptyRow,emptyCol);
        int counterRight = child.rightOk(emptyRow,emptyCol), counterLeft = child.leftOk(emptyRow,emptyCol);
        for (int i = 0 ; i < length ; i++){
            if (counterUp == 1){
                counterUp = 0;
                Action upAction = new Action(Enum_direction.UP,emptyRow,emptyCol);
                Board newBoard = new Board(child.getBoard());
                newBoard.swapBoard(upAction);
                nextNodes[i] = new Node()
            }else if (counterDown == 1){
                validActions[i] = new Action(Enum_direction.DOWN , emptyCellRow, emptyCellCol);
                counterDown = 0;
            } else if (counterRight == 1) {
                validActions[i] = new Action(Enum_direction.RIGHT, emptyCellRow, emptyCellCol);
                counterRight = 0;
            } else if (counterLeft == 1) {
                validActions[i] = new Action(Enum_direction.LEFT, emptyCellRow, emptyCellCol);
                counterLeft = 0;
            }
        }

    }




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
