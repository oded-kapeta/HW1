public class Node {
    private Node parent;
    private State state;
    private Action action;


    public Node(Node boardFather,State boardKid ,Action action2){
        System.out.println("hi11");
        this.parent = boardFather;
        this.state = boardKid;
        this.action = action2;
    }
    public Node(State firstBoard) {
        System.out.println("hi12");
        this.state = firstBoard;
    }

    public  Node[] expand(){
        System.out.println("hi13");
        Action [] actionsForSons = this.state.actions();
        for (int i = 0; i < actionsForSons.length;i++){
            System.out.println("THE ENUM IS :    " + actionsForSons[i].getEnum());
        }
        Node [] childrens = new Node[actionsForSons.length];
        for (int i = 0; i < actionsForSons.length; i++){
            //System.out.println("THE ENUM IS :    " + actionsForSons[i].getEnum());
            State newState2 = this.state.result(actionsForSons[i]);

            childrens[i] = new Node(this,newState2,actionsForSons[i]);
        }
        return childrens;
    }
/*Board copyBoard = new Board(State.getBoard());
            copyBoard.swapBoard(actionsForSons[i]);
            for (int k = 0; k <copyBoard.getRowLength();k++ ){
                System.out.println("hishusfhk");
                for (int l = 0 ;l < copyBoard.getColLength();l++){
                    System.out.print(copyBoard.getBoardPlace(k,l));
                }
                System.out.println();
            }
            State newState = new State(copyBoard);
            childrens[i] = new Node(this,newState,actionsForSons[i]);*/

    public int heuristicValue(){
        System.out.println("hi14");
        int counter = 0;
        for (int i = 0; i< state.getBoard().getRowLength(); i++) {
            for (int j = 0; j < state.getBoard().getColLength(); j++) {
                if(state.getBoard().getBoardPlace(i,j) != 1+(state.getBoard().getRowLength()*i)+j)
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
        return this.state;
    }
}
