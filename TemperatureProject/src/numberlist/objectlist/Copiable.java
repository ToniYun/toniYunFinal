package numberlist.objectlist;

/**
 * the interface that creates objects for the list that can be copiable
 * @author 955331921
 */
public interface Copiable {

    /**
     * the method that the other subclasses need
     * @return the copiable value
     */
    Copiable deepCopy();
}
