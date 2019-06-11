package numberlist.objectlist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * The array list that accepts all number values
 *
 * @author Antonio Yun
 */
public class NumericArrayList extends NumericList implements Copiable {

    private Copiable[] list = new Copiable[10];

    /**
     * Default constructor for the NumericArrayList class arguments
     */
    public NumericArrayList() {
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
        if (index < 0 || index >= 10) {
            throw new InvalidIndexException(0, 9, index);
        }
        if (index > count) {
            throw new InvalidIndexException(0, count, index);
        }
        if (count != 10) {
            count++;
        }
        if (index == 9) {
            list[index] = obj;
            return;
        }
        if (count != index + 1) {
            for (int i = count - 1; i > index; i--) {
                list[i] = list[i - 1];
            }
        }
        list[index] = obj;
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
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count, index);
        }
        Copiable removedNumber = list[index];
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        count--;
        return removedNumber;
    }

    /**
     * Removes the first instance of the given value
     *
     * @param obj the value that the user wants to remove
     *
     */
    @Override
    public void remove(Copiable obj) {
        boolean first = true;
        int i = 0;
        for (i = 0; i < count && first; i++) {
            if (list[i].toString().equals(obj.toString())) {
                first = false;
            }
        }
        if (list[i - 1].toString().equals(obj.toString())) {
            try {
                removeAt(i - 1);
            } catch (InvalidIndexException ex) {
                System.out.println("The remove in the NumericArrayList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", " + ex.getMaxIndex()
                        + " ], but was " + ex.getIndexUsed());
            }
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
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count, index);
        }
        return list[index];
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
        for (int i = 0; i < list.length; i++) {
            if (list[i].toString().equals(obj.toString())) {
                return i;
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
        String total = "[";
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                total += " " + String.valueOf(list[i]);
            } else {
                total += ", " + String.valueOf(list[i]);
            }
        }
        total += " ]";
        return total;
    }

    /**
     * Creates a deep copy of the class that the user wants
     *
     * @return the copy of the class
     */
    @Override
    public NumericArrayList deepCopy() {
        NumericArrayList temp = new NumericArrayList();
        for (Copiable copiable : list) {
            temp.add(copiable);
        }
        temp.count = this.count;
        return temp;
    }

    /**
     * sets the given value at the given index
     *
     * @param index where the new value is going
     * @param obj the object being added
     * @return the value that was replaced
     * @throws numberlist.InvalidIndexException
     */
    @Override
    public Copiable set(int index, Copiable obj) throws InvalidIndexException {
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count, index);
        }
        Copiable removed = list[index];
        list[index] = obj;
        return removed;
    }
}
