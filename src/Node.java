public class Node {
    private Node parent;
    private State child;
    private Action action;


    public Node(Node boardFather,State boardKid ,Action action2,){
        this.parent = boardFather;
        this.child = boardKid;
        this.action = action2;
    }

    public  Node[] expand(){
        Action [] actionsForSons = child.actions();
        Node [] childrens = new Node[actionsForSons.length];
        for (int i = 0; i < actionsForSons.length; i++){
            Board copyBoard = new Board(child.getBoard());
            copyBoard.swapBoard(actionsForSons[i]);
            State newState = new State(copyBoard);
            childrens[i] = new Node(this,newState,actionsForSons[i]);
        }
        return childrens;
    }




    public int heuristicValue(){
        int counter = 0;
        for (int i = 0;i< child.getBoard().getRowLength();i++) {
            for (int j = 0; j < child.getBoard().getColLength();j++) {
                if(child.getBoard().getBoardPlace(i,j) != 1+(child.getBoard().getRowLength()*i)+j)
                    counter++;
            }
        }
        return counter;
    }

}
