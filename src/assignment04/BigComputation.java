package assignment04;

import java.math.BigInteger;

public class BigComputation {
	public static void main(String[] args) 
	{
		// Initialize a variable within calling "BigFraction" method
		BigFraction total = null;
		
		// Initialize a variable within calling "BigFraction" method and store a value
		// to it.
		BigFraction sum = new BigFraction(0);
		
		// Count how many times the program runs.
		int steps = 0;
		
		// Use a for loop in order to use the formula of PI of professor's instruction.
		// The reason to use a for loop is because the formula needs continue adding
		// the value when k is 0 to infinity.
		for (long k = 0; k < 4; k++)
		{
			// Declare four variables to represent the BigFractions.
			BigFraction first = new BigFraction(4, (8*k + 1));
			BigFraction second = new BigFraction(2, (8*k + 4));
			BigFraction third  = new BigFraction(1, (8*k + 5));
			BigFraction fourth = new BigFraction(1, (8*k + 6));
			
			// Declare a variable to represent the coefficient 1/(16^k).
			BigFraction coefficient = new BigFraction(1, (long) (Math.pow(16, k)));
			
			// Call "subtract" and "multiply" methods inside "BigFraction" class in order to
			// complete the formula.
			total = first.subtract(second).subtract(third).subtract(fourth).multiply(coefficient);
			
			// Collecting all the value of when k is 0, 1, 2 and so on and sum them.
			sum = sum.add(total);
			
			steps = (int) (k + 1);
		}
		// Display the value of PI within a decimal form to the user.
		System.out.println("The PI is equal to " + sum.toDouble() + ", after " + steps + 
							" steps of the " + "computation were used to compute the result.");
		
		// Display the value of PI within a BigFraction form to the user.
		System.out.println("As a fraction, the value of PI is equal to " + sum + ".");
	}

}
