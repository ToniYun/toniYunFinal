package numberlist.objectlist;

import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;

/**
 * The abstract class for the two numeric lists
 *
 * @author 955331921
 */
abstract class NumericList {

    int count = 0;

    public int add(Copiable obj) {
        try {
            add(count, obj);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(NumericList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count - 1;
    }

    abstract void add(int index, Copiable obj) throws InvalidIndexException;

    abstract Copiable removeAt(int index)throws InvalidIndexException;

    abstract void remove(Copiable obj);

    abstract Copiable get(int index)throws InvalidIndexException;

    abstract int indexOf(Copiable obj);

    abstract Copiable set(int index, Copiable obj)throws InvalidIndexException;

    /**
     * Returns the number of valid values in the list
     *
     * @return the number of valid values
     */
    public int getCount() {
        return count;
    }

}
