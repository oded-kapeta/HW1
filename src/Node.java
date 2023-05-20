public class Node {
    private Node parent;
    private State State;
    private Action action;


    public Node(Node boardFather,State boardKid ,Action action2){
        this.parent = boardFather;
        this.State = boardKid;
        this.action = action2;
    }
    public Node(State firstBoard)
    {
        this.State = firstBoard;
    }

    public  Node[] expand(){
        Action [] actionsForSons = State.actions();
        Node [] childrens = new Node[actionsForSons.length];
        for (int i = 0; i < actionsForSons.length; i++){
            Board copyBoard = new Board(State.getBoard());
            copyBoard.swapBoard(actionsForSons[i]);
            State newState = new State(copyBoard);
            childrens[i] = new Node(this,newState,actionsForSons[i]);
        }
        return childrens;
    }


    public int heuristicValue(){
        int counter = 0;
        for (int i = 0; i< State.getBoard().getRowLength(); i++) {
            for (int j = 0; j < State.getBoard().getColLength(); j++) {
                if(State.getBoard().getBoardPlace(i,j) != 1+(State.getBoard().getRowLength()*i)+j)
                    counter++;
            }
        }
        return counter;
    }


    public Node getParent(){
        return this.parent;
    }

    public Action getAction(){
        return this.action;
    }

    public State getState(){
        return this.State;
    }
}
