package numberlist.objectlist;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class creates a complex number object
 *
 * @author Antonio Yun
 */
public final class Complex implements Copiable {

    private double real;
    private double imaginary;

    /**
     * Default constructor for the NumericArrayList class arguments
     */
    public Complex() {

    }

    /**
     * Default constructor for the Complex class arguments
     *
     * @param real the real number for the complex object
     * @param imaginary the coeficient in frount of the imaginary number
     */
    public Complex(double real, double imaginary) {
        BigDecimal bd = new BigDecimal(real);
        bd = bd.round(new MathContext(4));
        real = bd.doubleValue();
        this.real = real;
        bd = new BigDecimal(imaginary);
        bd = bd.round(new MathContext(4));
        imaginary = bd.doubleValue();
        this.imaginary = imaginary;
    }

    /**
     * Returns the real value of the complex number
     *
     * @return the real value of the complex number
     */
    public double getReal() {
        BigDecimal bd = new BigDecimal(real);
        bd = bd.round(new MathContext(4));
        real = bd.doubleValue();
        return real;
    }

    /**
     * Return the imaginary number of the the complex number
     *
     * @return the imaginary number of the complex number
     */
    public double getImaginary() {
        BigDecimal bd = new BigDecimal(imaginary);
        bd = bd.round(new MathContext(4));
        imaginary = bd.doubleValue();
        return imaginary;
    }

    /**
     * Adds two complex numbers
     *
     * @param other a complex number
     * @return the sum of the two complex numbers
     */
    public Complex add(Complex other) {
        double real = other.getReal();
        double imaginary = other.getImaginary();
        double newReal = (BigDecimal.valueOf(this.real)).add(BigDecimal.valueOf(real)).doubleValue();
        double newImaginary = (BigDecimal.valueOf(this.imaginary)).add(BigDecimal.valueOf(imaginary)).doubleValue();
        BigDecimal bd = new BigDecimal(newReal);
        bd = bd.round(new MathContext(4));
        newReal = bd.doubleValue();
        bd = new BigDecimal(newImaginary);
        bd = bd.round(new MathContext(4));
        newImaginary = bd.doubleValue();
        return new Complex(newReal, newImaginary);
    }

    /**
     * Subtracts two complex numbers
     *
     * @param other a complex numbers
     * @return the difference of the two complex numbers
     */
    public Complex subtract(Complex other) {
        double real = other.getReal();
        double imaginary = other.getImaginary();
        double newReal = (BigDecimal.valueOf(this.real)).subtract(BigDecimal.valueOf(real)).doubleValue();
        double newImaginary = (BigDecimal.valueOf(this.imaginary)).subtract(BigDecimal.valueOf(imaginary)).doubleValue();
        BigDecimal bd = new BigDecimal(newReal);
        bd = bd.round(new MathContext(4));
        newReal = bd.doubleValue();
        bd = new BigDecimal(newImaginary);
        bd = bd.round(new MathContext(4));
        newImaginary = bd.doubleValue();
        return new Complex(newReal, newImaginary);
    }

    /**
     * Returns the string value of the complex number
     *
     * @return the string value of complex
     */
    @Override
    public String toString() {
        if (imaginary == 0) {
            return real + "";
        }
        if (real == 0) {
            return imaginary + "i";
        }
        if (imaginary > 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (imaginary * -1) + "i";

        }
    }

    /**
     * Creates a deep copy of the class that the user wants
     *
     * @return the copy of the class
     */
    @Override
    public Complex deepCopy() {
        return new Complex(this.real, this.imaginary);
    }

}
