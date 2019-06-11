package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/*
* Inherits from DoubleArrayList and creates more methods
* @author Antonio Yun
 */
public class IntegerArrayList extends LongArrayList {

    /**
     * Adds to the end of the list and return the index it was 
     * added at
     * @param value is the integer number value that the user wants to input
     * @return the index of were the value was  input
     */
    public int add(long value){
        try {
            super.add(super.getCount(), value);
        } catch (InvalidIndexException ex) {
            System.out.println("The add in the IntegerArrayList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
        }
        return super.getCount() - 1;
    }

    /**
     * Removes all instances of the value from the list
     * @param value removes all instances of this value
     */
    public void removeAll(long value) {
        for (int i = super.getCount() - 1; i >= 0; i--) {
            try {
                if (value == super.get(i)) {
                    super.remove(value);
                }
            } catch (InvalidIndexException ex) {
                System.out.println("The removeall in the integerArrayList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
            }
        }
    }

    /**
     * Returns the index of the last element in the list
     * that contains the value, or -1 if the value does not exist
     * @param value is the integer number value the user wants to find
     * the index of
     * @return the index of the last instance of the value in the array
     */
    public int lastIndexOf(long value) {
        for (int i = super.getCount() - 1; i >= 0; i--) {
            try {
                if (super.get(i) == value) {
                    return i;
                }
            } catch (InvalidIndexException ex) {
                System.out.println("The lastIndexOf in the integerArrayList"
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
            }
        }
        return -1;
    }
}
