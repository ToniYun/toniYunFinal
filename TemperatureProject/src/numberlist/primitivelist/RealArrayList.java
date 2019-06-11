package numberlist.primitivelist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * Inherits from DoubleArrayList and creates more methods
 * @author Antonio Yun
 */
public class RealArrayList extends DoubleArrayList {

    /**
     * Adds to the end of the list and return the index it was 
     * added at
     * @param value is the real number value that the user wants to input
     * @return the index of were the value was  input
     */
    public int add(double value) {
        try {
            super.add(super.getCount(), value);
        } catch (InvalidIndexException ex) {
            System.out.println("The add in the RealArrayList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
        }
        return super.getCount() -1;
    }

    /**
     * Removes all instances of the value from the list
     * @param value removes all instances of this value
     */
    public void removeAll(double value) {
        for (int i = super.getCount()-1; i >= 0; i--) {
            try {
                if (value == super.get(i)) {
                    super.remove(value);
                }
            } catch (InvalidIndexException ex) {
                System.out.println("The removeAll in the realArrayList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
            }
        }
    }

    /**
     * Returns the index of the last element in the list
     * that contains the value, or -1 if the value does not exist
     * @param value is the real number value the user wants to find the indexof
     * @return the index of the last instance of the value in the array
     */
    public int lastIndexOf(double value) {
        for (int i = super.getCount() - 1; i >= 0; i--) {
            try {
                if (super.get(i) == value) {
                    return i;
                }
            } catch (InvalidIndexException ex) {
                System.out.println("The lstIndeOf in the realArrayList "
                        + "is out of range should be between[ "
                        + ex.getMinIndex() + ", "+ex.getMaxIndex()
                        +" ], but was " + ex.getIndexUsed());
            }
        }
        return -1;
    }
}
