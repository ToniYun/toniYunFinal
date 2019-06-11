package numberlist.objectlist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * the class that creates a new linked list of numeric Copiable objects
 *
 * @author 955331921
 */
public class NumericLinkedList extends NumericList implements Copiable {

    private Node firstNode;

    /**
     * The default constructor for the linked list class
     */
    public NumericLinkedList() {
    }

    /**
     * Adds a numeric value at the given index if the index is within range
     *
     * @param index the index the user wants the value entered at
     * @param obj the value that the user wants to enter
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public void add(int index, Copiable obj) throws InvalidIndexException {
        if (index < 0 || index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        Node newNode = new Node(obj);
        if (index == 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            Node currNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
        count++;
    }

    /**
     * Removes the value at the given index and returns that value
     *
     * @param index the place the user wants to get rid of a number
     * @return the value of the removed number
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable removeAt(int index) throws InvalidIndexException {
        if (index < 0 || index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        Copiable temp = get(index);
        if (index == 0) {
            firstNode.setValue(firstNode.getNext().getValue());
        }
        Node currNode = firstNode;
        for (int i = 0; i < index - 1; i++) {
            currNode = currNode.getNext();
        }
        currNode.setNext(currNode.getNext().getNext());
        count--;
        return temp;

    }

    /**
     * Removes the first instance of the given value
     *
     * @param obj the value that the user wants to remove
     *
     */
    @Override
    public void remove(Copiable obj) {
        try {
            boolean first = true;
            int i = 0;
            for (i = 0; i < count && first; i++) {
                if (get(i).toString().equals(obj.toString())) {
                    first = false;
                }
                
            }
            if (get(i - 1).toString().equals(obj.toString())) {
                removeAt(i - 1);
            }
        } catch (InvalidIndexException ex) {
            System.out.println("The remove in the NumericLinkedList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
        }

    }

    /**
     * Returns the value at the given index
     *
     * @param index the index of the list that the user wants
     * @return the value at the given index
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable get(int index) throws InvalidIndexException {
        if (index < 0 || index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        Node currNode = firstNode;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getValue();
    }

    /**
     * Returns the index of the first instance of the given value, or -1 if not
     * found
     *
     * @param obj the value the user wants the index of
     * @return the index of the first instance of the given value
     */
    @Override
    public int indexOf(Copiable obj) {
        for (int i = 0; i < count; i++) {
            try {
                if (get(i).toString().equals(obj.toString())) {
                    return i;
                }
            } catch (InvalidIndexException ex) {
                System.out.println("The indexOf in the NumericLinkedList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
            }
        }
        return -1;
    }

    /**
     * Returns a String representation of the list in the form “[ 123, 567,
     * -543, 5 ]” or “[ ]” if there are no valid values in the list
     *
     * @return the String value of the list of numbers
     */
    @Override
    public String toString() {
        try {
            if (count == 0) {
                return "[ ]";
            }
            String total;
            total = "[ " + String.valueOf(get(0));

            for (int i = 1; i < count; i++) {
                total += ", " + String.valueOf(get(i));

            }
            total += " ]";
            return total;
        } catch (InvalidIndexException ex) {
            System.out.println("The toString in the NumericLinkedList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
        }
        return "";
    }

    /**
     * Creates a deep copy of the class that the user wants
     *
     * @return the copy of the class
     */
    @Override
    public NumericLinkedList deepCopy() {
        NumericLinkedList temp = new NumericLinkedList();
        for (int i = 0; i < count; i++) {
            try {
                temp.add(this.get(i));
            } catch (InvalidIndexException ex) {
                System.out.println("The deepCopy in the NumericLinkedList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", " + ex.getMaxIndex()
                        + " ], but was " + ex.getIndexUsed());
            }
        }
        return temp;
    }

    /**
     * sets the given value at the given index
     *
     * @param index where the new value is going
     * @param obj the object being added
     * @return the value that was  replaced
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable set(int index, Copiable obj) throws InvalidIndexException {
        if (index < 0 || index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        Node newNode = new Node(obj);
        Copiable removed = null;
        if (index == 0) {
            removed = firstNode.getValue();
            firstNode.setValue(obj);
            return removed;
        } else {
            Node currNode = firstNode;
            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }
            removed = currNode.getValue();
            currNode.setValue(obj);
            return removed;
        }
    }

}
