package assignment04;

import java.math.BigInteger;

public class BigFraction 
{
	private BigInteger numerator, denominator;

	/**
	 * Constructor - initializes this object to contain the numerator 
	 * and denominator values that are sent in by the caller (whoever 
	 * used 'new BigFraction').
	 * 
	 * @param n  an amount of numerator value
	 * @param d  an amount of denominator value
	 */
	private BigFraction (BigInteger  n, BigInteger  d)
	{
		// Initialize these 'long' variables.
		BigInteger gcd, remainder, temp;
		// Store the greatest common divisor of the numerator and denominator.
		gcd = n.abs();
		remainder = d.abs();

		while (remainder != BigInteger.ZERO)
		{
			temp = remainder;
			remainder = gcd.remainder(remainder);
			gcd = temp;
		}

		// Just move the numbers from the parameters into the object.

		if (d.signum() < 0)
		{
			this.numerator = n.negate().divide(gcd);
			this.denominator = d.negate().divide(gcd);
		}
		else
		{
			this.numerator = n.divide(gcd);
			this.denominator = d.divide(gcd);
		}
	}
	
	public BigFraction(long n , long d)
	{
		this(BigInteger.valueOf(n), BigInteger.valueOf(d));
	}

	/**
	 * Second constructor - initializes this object to contain the numerator
	 * and let the denominator equal to 1.
	 * @param n an amount of numerator value
	 */
	private BigFraction (BigInteger  n)
	{
		
		this.numerator = n;
		this.denominator = BigInteger.ONE;
	}

	public BigFraction(long n)
	{
		this(BigInteger.valueOf(n));
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
	public BigInteger getNumerator ()
	{
		return numerator;
	} 

	/**
	 * Returns the denominator value from this BigFraction method.
	 * 
	 * @return denominator for this BigFraction
	 */
	public BigInteger getDenominator ()
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
		result = new BigFraction (this.numerator.multiply(rhs.numerator), 
				this.denominator.multiply(rhs.denominator));

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
		result = new BigFraction (this.numerator.multiply(rhs.denominator),
				this.denominator.multiply(rhs.numerator));

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
		result = new BigFraction ((this.numerator.multiply(rhs.denominator)).add((rhs.numerator).multiply(this.denominator)),
				this.denominator.multiply(rhs.denominator));

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
		result = new BigFraction ((this.numerator.multiply(rhs.denominator)).subtract((rhs.numerator.multiply(this.denominator))),
				this.denominator.multiply(rhs.denominator));

		// Pass the resulting BigFraction back to the caller.
		return result;
	}

	/**
	 * Return a decimal 'double' value which approximates the value of 'this' BigFraction object
	 * @return a double that approximates the value of 'this' BigFraction object
	 */
	public double toDouble()
	{
		return (this.numerator.divide(this.denominator)).doubleValue();
	}

}
