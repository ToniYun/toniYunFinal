package numberlist.objectlist;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * This class creates a money object
 *
 * @author Antonio Yun
 */
public final class Money implements Copiable {

    private long dollars;
    private byte cents;

    /**
     * Default constructor for the Money class arguments
     */
    public Money() {

    }

    /**
     * Default constructor for the Money class arguments
     *
     * @param dollars the amount of money first entered
     * @param cents the amount of cents first entered
     */
    public Money(long dollars, byte cents) {
        this.dollars = dollars;
        while (cents >= 100 || cents <= -100) {
            if (cents >= 100) {
                this.dollars++;
                cents -= 100;
            }else{
                this.dollars--;
                cents += 100;
            }
        }
        if(cents < 0 && this.dollars > 0){
            cents += (byte)100;
            this.dollars--;
        }else if(cents > 0 && this.dollars < 0){
            cents -= (byte)100;
            this.dollars++;
        }
        this.cents = cents;
    }

    /**
     * Returns the dollars value of the money number
     *
     * @return the dollar value of the complex number
     */
    public long getDollars() {
        return dollars;
    }

    /**
     * Return the cents value of the the money number
     *
     * @return the cents number of the money number
     */
    public byte getCents() {
        return cents;
    }

    /**
     * Adds two money numbers
     *
     * @param other a money number
     * @return the sum of the two money numbers
     */
    public Money add(Money other) {
        long doll = other.getDollars();
        byte cen = other.getCents();
        long newDollars = (long) (BigDecimal.valueOf(this.dollars)).add(BigDecimal.valueOf(doll)).doubleValue();
        byte newCents = (byte) (BigDecimal.valueOf(this.cents)).add(BigDecimal.valueOf(cen)).doubleValue();
        return new Money(newDollars, newCents);
    }

    /**
     * Subtracts two money numbers
     *
     * @param other a money numbers
     * @return the difference of the two money numbers
     */
    public Money subtract(Money other) {
        long doll = other.getDollars();
        byte cen = other.getCents();
        long newDollars = (long) (BigDecimal.valueOf(this.dollars)).subtract(BigDecimal.valueOf(doll)).doubleValue();
        byte newCents = (byte) (BigDecimal.valueOf(this.cents)).subtract(BigDecimal.valueOf(cen)).doubleValue();
        return new Money(newDollars, newCents);
    }

    /**
     * Returns the string value of money
     *
     * @return the string value of money
     */
    @Override
    public String toString() {
        double total = (BigDecimal.valueOf(this.dollars)).add(BigDecimal.valueOf(0.01 * this.cents)).doubleValue();;
        DecimalFormat df = new DecimalFormat("0.00");
        if (total < 0) {
            total *= -1;
            return "-$" + (df.format(total));
        }
        return ("$" + (df.format(total)));
    }

    /**
     * Creates a deep copy of the class that the user wants
     *
     * @return the copy of the class
     */
    @Override
    public Money deepCopy() {
        return new Money(this.dollars, this.cents);
    }

}
