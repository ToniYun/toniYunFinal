package yun;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import numberlist.primitivelist.IntegerArrayList;

/**
 *
 * @author 955331921
 */
public class Temperatures {

    IntegerArrayList list;
    IntegerArrayList timeStamps;

    public Temperatures() {
        list = new IntegerArrayList();
        timeStamps = new IntegerArrayList();
    }

    public void addTemperature(int temp, long timeStamp) {
        list.add(temp);
        timeStamps.add(timeStamp);
    }

    public int[] getTemperature() {
        int[] arr = new int[list.getCount()];
        for (int i = 0; i < list.getCount(); i++) {
            try {
                arr[i] = (int) list.get(i);
            } catch (InvalidIndexException ex) {
                Logger.getLogger(Temperatures.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    public int getTemperature(int index) {
        try {
            return (int) list.get(index);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(Temperatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public long getTimeStamp(int index){
        try {
            return timeStamps.get(index);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(Temperatures.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Long.MAX_VALUE;
    }

    public double getAverageTemperature() {
        double avg = 0;
        for (int i = 0; i < list.getCount(); i++) {
            try {
                avg += list.get(i);
            } catch (InvalidIndexException ex) {
                Logger.getLogger(Temperatures.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        avg /= list.getCount();
        return avg;
    }
}
