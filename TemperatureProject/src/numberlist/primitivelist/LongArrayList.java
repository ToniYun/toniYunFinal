package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * A partially-filled array of primitive long values used to implement a list
 * data structure
 *
 * @author Antonio Yun
 */
public class LongArrayList {

    private long[] list = new long[10];
    private int count;

    /**
     * Default constructor for the LongArrayList class arguments
     */
    public LongArrayList() {

    }

    /**
     * Adds a long value at the given index if the index is within range
     *
     * @param index the index the user wants the value entered at
     * @param value the value that the user wants to enter
     * @throws numberlist.InvalidIndexException
     */
    public void add(int index, long value) throws InvalidIndexException{
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
            list[index] = value;
            return;
        }
        if (count != index + 1) {
            for (int i = count - 1; i > index; i--) {
                list[i] = list[i - 1];
            }
        }
        list[index] = value;
    }

    /**
     * Removes the value at the given index and returns that value
     *
     * @param index the place the user wants to get rid of a number
     * @return the value of the removed number
     * @throws numberlist.InvalidIndexException
     */
    public long removeAt(int index) throws InvalidIndexException{
        if (index > count - 1 || index < 0) {
            throw new InvalidIndexException(0, count, index);
        }
        long removedNumber = list[index];
        for (int i = index; i < count - 1; i++) {
            list[i] = list[i + 1];
        }
        count--;
        return removedNumber;
    }

    /**
     * Removes the first instance of the given value
     *
     * @param value the value that the user wants to remove
     */
    public void remove(long value) {
        boolean first = true;
        int i = 0;
        for (i = 0; i < count && first; i++) {
            if (list[i] == value) {
                first = false;
            }
        }
        if (list[i - 1] == value) {
            try {
                removeAt(i - 1);
            } catch (InvalidIndexException ex) {
                System.out.println("The remove in the LongArrayList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
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
    public long get(int index) throws InvalidIndexException{
        if (index > count - 1 || index < 0) {
            throw new InvalidIndexException(0, count, index);
        }
        return list[index];
    }

    /**
     * Returns the index of the first instance of the given value, or -1 if not
     * found
     *
     * @param value the value the user wants the index of
     * @return the index of the first instance of the given value
     */
    public int indexOf(long value) {
        for (int i = 0; i < count; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the number of valid values in the list
     *
     * @return the number of valid values
     */
    public int getCount() {
        return count;
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
     * sets the given value at the given index
     *
     * @param index where the new value is going
     * @param value
     * @return the value that was  replaced
     * @throws numberlist.InvalidIndexException
     */
    public long set(int index, long value)throws InvalidIndexException {
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count, index);
        }
        long removed = list[index];
        list[index] = value;
        return removed;
    }
}
