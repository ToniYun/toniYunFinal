package numberlist.objectlist;

/**
 * the list of things that go into the numericlinkedlist class
 * @author 955331921
 */
public class Node {

    private Node nextNode;
    private Copiable obj;

    /**
     * constructor for the Node class
     * @param obj the value of the first node when the list is created
     */
    public Node(Copiable obj) {
        this.obj = obj;
    }

    /**
     * gets the value of the current node
     * @return the value of the current node
     */
    public Copiable getValue() {
        return this.obj;
    }

    /**
     * returns the next node
     * @return the value of the next node
     */
    public Node getNext() {
        return nextNode;
    }

    /**
     * gets the new value for the next node
     * @param nextNode the next node being set
     */
    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * sets the value of the Copiable object in the node
     * @param obj the Copiable object being set
     */
    public void setValue(Copiable obj) {
        this.obj = obj;
    }
}
