package assignment04;
/**
 * Objects of this class represent a Fraction.
 * 
 * Note:  Java has a built-in Fraction class that represents lists of 
 * things. The name of this class is officially assignment04.Fraction, 
 * but you can import it so that you can just use Fraction instead.
 * 
 * @author Yingjie Lian
 * @version 02/09/2017
 * @class CS-1410
 */
public class Fraction 
{
	// Fields (object variables)
	private long numerator, denominator;

	/**
	 * Constructor - initializes this object to contain the numerator 
	 * and denominator values that are sent in by the caller (whoever 
	 * used 'new Fraction').
	 * 
	 * @param n  an amount of numerator value
	 * @param d  an amount of denominator value
	 */
	public Fraction (long n, long d)
	{
		// Initialize these 'long' variables.
		long gcd, remainder, temp;
		// Store the greatest common divisor of the numerator and denominator.
		gcd = Math.abs(n);
		remainder = Math.abs(d);

		while (remainder != 0)
		{
			temp = remainder;
			remainder = gcd % remainder;
			gcd = temp;
		}

		// Just move the numbers from the parameters into the object.

		if (d < 0)
		{
			this.numerator = -n / gcd;
			this.denominator = -d / gcd;
		}
		else
		{
			this.numerator = n / gcd;
			this.denominator = d / gcd;
		}
	}

	/**
	 * Second constructor - initializes this object to contain the numerator
	 * and let the denominator equal to 1.
	 * @param n an amount of numerator value
	 */
	public Fraction (long n)
	{
		
		this.numerator = n;
		this.denominator = 1;
	}

	/**
	 * Returns a human-readable string representing this fraction. 
	 * Fractions have slash sign "/" between numerator and denominator.
	 *  
	 * @return a String representing the fraction 
	 */
	public String toString ()
	{
		return this.numerator + "/" + this.denominator;
	}

	// Accessor methods are methods that you add to a class to give the 
	// user (the programmer) the ability to retrieve private variables 
	// from within the class. The return type matches the instance variable 
	// type, and the name indicates which value you are returning.

	// Accessor methods
	/**
	 * Returns the numerator value from this Fraction method.
	 * 
	 * @return numerator for this Fraction
	 */
	public long getNumerator ()
	{
		return numerator;
	} 

	/**
	 * Returns the denominator value from this Fraction method.
	 * 
	 * @return denominator for this Fraction
	 */
	public long getDenominator ()
	{
		return denominator;
	}

	// Utility methods
	/**
	 * Returns a new Fraction equal to the product of this fraction and 
	 * rhs(rightHandSide) fraction. The product of Fraction is just the product
	 * of the numerators divide the product of denominators.
	 * 
	 * @param rhs another Fraction object
	 * @return a Fraction this is the product of these two Fractions
	 */
	public Fraction multiply (Fraction rhs)
	{
		// Create a variable to hold the result
		Fraction result;  

		// Build a new Fraction object - send the products to the constructor.
		result = new Fraction (this.numerator * rhs.numerator, 
				this.denominator * rhs.denominator);

		// Pass the resulting fraction back to the caller.
		return result; 
	}

	/**
	 * Returns a new Fraction equal to the quotient of this fraction and 
	 * rhs(rightHandSide) fraction. Notice, to get the quotient of the fraction,
	 * you have to let this numerator to multiply rightHandSide denominator
	 * and let rightHandSide numerator to multiply this denominator.
	 * 
	 * @param rhs another Fraction object
	 * @return a Fraction this is the quotient of these two Fractions
	 */
	public Fraction divide (Fraction rhs)
	{
		// Create a variable to hold the result
		Fraction result;

		// Build a new Fraction object - send the quotient to the constructor.
		result = new Fraction (this.numerator * rhs.denominator,
				this.denominator * rhs.numerator);

		// Pass the resulting fraction back to the caller.
		return result;
	}

	/**
	 * Returns a new Fraction equal to the sum of this fraction and rhs(rightHandSide)
	 * fraction. Notice, by adding two fractions, these fractions need to make sure they have
	 * the same denominator.
	 * 
	 * @param rhs another Fraction object
	 * @return a Fraction this is the sum of these two Fractions
	 */
	public Fraction add (Fraction rhs)
	{
		// Create a variable to hold the result
		Fraction result;

		// Build a new Fraction object - send the sum to the constructor.
		result = new Fraction ((this.numerator * rhs.denominator) + (rhs.numerator * this.denominator),
				this.denominator * rhs.denominator);

		// Pass the resulting fraction back to the caller.
		return result;
	}

	/**
	 * Returns a new Fraction equal to the different of this fraction and rhs(rightHandSide)
	 * fraction. Notice, by subtracting two fractions, these fractions need to make sure they have
	 * the same denominator.
	 * @param rhs another Fraction object
	 * @return a Fraction this is the difference of these two Fractions
	 */
	public Fraction subtract (Fraction rhs)
	{
		// Create a variable to hold the result
		Fraction result;

		// Build a new Fraction object - send the different to the constructor.
		result = new Fraction ((this.numerator * rhs.denominator) - (rhs.numerator * this.denominator),
				this.denominator * rhs.denominator);

		// Pass the resulting fraction back to the caller.
		return result;
	}

	/**
	 * Return a decimal 'double' value which approximates the value of 'this' fraction object
	 * @return a double that approximates the value of 'this' fraction object
	 */
	public double toDouble()
	{
		return (double)(this.numerator) / (double)(this.denominator);
	}
}
