package numberlist.primitivelist;

import numberlist.InvalidIndexException;

/*
* This class will use composition to create a floating point
* version of the LongArrayList
* @author Antonio Yun
 */
public class DoubleArrayList {

    private LongArrayList longArrayList;

    /**
     * The default constructor for the DoubleArrayList class
     */
    public DoubleArrayList() {
        longArrayList = new LongArrayList();
    }

    /**
     * Adds a long value at the given index if the index is within range
     *
     * @param index the index the user want the value
     * @param value the value the user wants to add
     * @throws numberlist.InvalidIndexException
     */
    public void add(int index, double value) throws InvalidIndexException {
        longArrayList.add(index, Double.doubleToRawLongBits(value));
    }

    /**
     * Removes the value at the given index and returns that value
     *
     * @param index the place the user wants to get rid of a number
     * @return the value of the removed number
     * @throws numberlist.InvalidIndexException
     */
    public double removeAt(int index) throws InvalidIndexException {
        long temp = longArrayList.removeAt(index);
        double doubleValue = Double.longBitsToDouble(temp);
        return doubleValue;
    }

    /**
     * Removes the first instance of the given value
     *
     * @param value the value that the user wants to remove
     */
    public void remove(double value) {
        longArrayList.remove(Double.doubleToRawLongBits(value));
    }

    /**
     * Returns the value at the given index
     *
     * @param index the index of the list that the user wants
     * @return the value at the given index
     * @throws numberlist.InvalidIndexException
     */
    public double get(int index) throws InvalidIndexException {
        return Double.longBitsToDouble(longArrayList.get(index));
    }

    /**
     * Returns the index of the first instance of the given value, or -1 if not
     * found
     *
     * @param value the value the user wants the index of
     * @return the index of the first instance of the given value
     */
    public int indexOf(double value) {
        return longArrayList.indexOf(Double.doubleToRawLongBits(value));
    }

    /**
     * Returns the number of valid values in the list
     *
     * @return the number of valid values
     */
    public int getCount() {
        return longArrayList.getCount();
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
            if (longArrayList.getCount() == 0) {
                return "[ ]";
            }
            String total = "[ " + String.valueOf(Double.longBitsToDouble(longArrayList.get(0)));
            for (int i = 1; i < longArrayList.getCount(); i++) {
                total += ", " + String.valueOf(Double.longBitsToDouble(longArrayList.get(i)));
            }
            total += " ]";
            return total;
        } catch (InvalidIndexException ex) {
            System.out.println("The toString in the Double "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
        }
        return "";
    }

    /**
     * sets the given value at the given index
     *
     * @param index where the new value is going
     * @param value
     * @return the value that was  replaced
     * @throws numberlist.InvalidIndexException
     */
    public double set(int index, double value) throws InvalidIndexException {
        if (index > longArrayList.getCount() || index < 0) {
            throw new InvalidIndexException(0, longArrayList.getCount(), index);
        }
        return Double.longBitsToDouble(longArrayList.set(index,
                Double.doubleToRawLongBits(value)));
    }

}
