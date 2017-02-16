package assignment04;

public class BigFraction 
{
	private long numerator, denominator;

	/**
	 * Constructor - initializes this object to contain the numerator 
	 * and denominator values that are sent in by the caller (whoever 
	 * used 'new BigFraction').
	 * 
	 * @param n  an amount of numerator value
	 * @param d  an amount of denominator value
	 */
	public BigFraction (long n, long d)
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
	public BigFraction (long n)
	{
		
		this.numerator = n;
		this.denominator = 1;
	}

	/**
	 * Returns a human-readable string representing this BigFraction. 
	 * BigFractions have slash sign "/" between numerator and denominator.
	 *  
	 * @return a String representing the BigFraction 
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
	 * Returns the numerator value from this BigFraction method.
	 * 
	 * @return numerator for this BigFraction
	 */
	public long getNumerator ()
	{
		return numerator;
	} 

	/**
	 * Returns the denominator value from this BigFraction method.
	 * 
	 * @return denominator for this BigFraction
	 */
	public long getDenominator ()
	{
		return denominator;
	}

	// Utility methods
	/**
	 * Returns a new BigFraction equal to the product of this BigFraction and 
	 * rhs(rightHandSide) BigFraction. The product of BigFraction is just the product
	 * of the numerators divide the product of denominators.
	 * 
	 * @param rhs another BigFraction object
	 * @return a BigFraction this is the product of these two BigFractions
	 */
	public BigFraction multiply (BigFraction rhs)
	{
		// Create a variable to hold the result
		BigFraction result;  

		// Build a new BigFraction object - send the products to the constructor.
		result = new BigFraction (this.numerator * rhs.numerator, 
				this.denominator * rhs.denominator);

		// Pass the resulting BigFraction back to the caller.
		return result; 
	}

	/**
	 * Returns a new BigFraction equal to the quotient of this BigFraction and 
	 * rhs(rightHandSide) BigFraction. Notice, to get the quotient of the BigFraction,
	 * you have to let this numerator to multiply rightHandSide denominator
	 * and let rightHandSide numerator to multiply this denominator.
	 * 
	 * @param rhs another BigFraction object
	 * @return a BigFraction this is the quotient of these two BigFractions
	 */
	public BigFraction divide (BigFraction rhs)
	{
		// Create a variable to hold the result
		BigFraction result;

		// Build a new BigFraction object - send the quotient to the constructor.
		result = new BigFraction (this.numerator * rhs.denominator,
				this.denominator * rhs.numerator);

		// Pass the resulting BigFraction back to the caller.
		return result;
	}

	/**
	 * Returns a new BigFraction equal to the sum of this BigFraction and rhs(rightHandSide)
	 * BigFraction. Notice, by adding two BigFractions, these BigFractions need to make sure they have
	 * the same denominator.
	 * 
	 * @param rhs another BigFraction object
	 * @return a BigFraction this is the sum of these two BigFractions
	 */
	public BigFraction add (BigFraction rhs)
	{
		// Create a variable to hold the result
		BigFraction result;

		// Build a new BigFraction object - send the sum to the constructor.
		result = new BigFraction ((this.numerator * rhs.denominator) + (rhs.numerator * this.denominator),
				this.denominator * rhs.denominator);

		// Pass the resulting BigFraction back to the caller.
		return result;
	}

	/**
	 * Returns a new BigFraction equal to the different of this BigFraction and rhs(rightHandSide)
	 * BigFraction. Notice, by subtracting two BigFractions, these BigFractions need to make sure they have
	 * the same denominator.
	 * @param rhs another BigFraction object
	 * @return a BigFraction this is the difference of these two BigFractions
	 */
	public BigFraction subtract (BigFraction rhs)
	{
		// Create a variable to hold the result
		BigFraction result;

		// Build a new BigFraction object - send the different to the constructor.
		result = new BigFraction ((this.numerator * rhs.denominator) - (rhs.numerator * this.denominator),
				this.denominator * rhs.denominator);

		// Pass the resulting BigFraction back to the caller.
		return result;
	}

	/**
	 * Return a decimal 'double' value which approximates the value of 'this' BigFraction object
	 * @return a double that approximates the value of 'this' BigFraction object
	 */
	public double toDouble()
	{
		return (double)(this.numerator) / (double)(this.denominator);
	}

}
