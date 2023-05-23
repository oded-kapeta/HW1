public class Node {
    private Node parent;
    private State state;
    private Action action;

    /**
     * constructor to Node
     * @param boardFather
     * @param boardKid
     * @param action2
     */
    public Node(Node boardFather,State boardKid ,Action action2){
        this.parent = boardFather;
        this.state = boardKid;
        this.action = action2;
    }

    /**
     * constructor to the first Node without father
     * @param firstBoard
     */
    public Node(State firstBoard) {
        this.state = firstBoard;
    }

    /**
     * this function creating new Node from this Node and return them as array
     * @return
     */
    public  Node[] expand(){
        Action [] actionsForSons = this.state.actions();
        Node [] children = new Node[actionsForSons.length];
        for (int i = 0; i < actionsForSons.length; i++){
            State newState2 = this.state.result(actionsForSons[i]);

            children[i] = new Node(this,newState2,actionsForSons[i]);
        }
        return children;
    }


    /**
     * this function calculate the heuristic value of the number of cells that is not in their place
     * @return
     */

    public int heuristicValue(){
        int counter = 0;
        int row = state.getBoard().getRowLength(),col = state.getBoard().getColLength();
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                if(state.getBoard().getBoardPlace(i,j) != 1+(row*i)+j ){
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * return the parent Node
     * @return
     */
    public Node getParent(){
        return this.parent;
    }

    /**
     * return the action that bring us to the current Node
     * @return
     */
    public Action getAction(){
        return this.action;
    }

    /**
     * return the state in our current Node
     * @return
     */
    public State getState(){
        return this.state;
    }
}
