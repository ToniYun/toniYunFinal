package numberlist;

/**
 *
 * @author Antonio Yun
 */
public class InvalidIndexException extends Exception{

    private int minIndex;
    private int maxIndex;
    private int indexUsed;

    public InvalidIndexException(int minIndex, int maxIndex, int indexUsed) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.indexUsed = indexUsed;
    }

    public int getMinIndex() {
        return minIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public int getIndexUsed() {
        return indexUsed;
    }

}
