package assignment02;
/**
 * This program is going to find out the smallest positive integer which cannot have its 
 * Hailstone sequence computed using "int" variables. And it will tell how long the 
 * program will terminate in milliseconds.
 * 
 * The integer 113383 is the smallest positive integer which cannot have its Hailstone sequence 
 * computed using int variables. Then, I use the calculator to compute and follow the 
 * Hailstone sequence rules. And I find out that after about 30 iterations, the number changed
 * to 2_482_111_348 which is bigger than 2^31-1 (the largest number that "int" type could
 * deal with in Java). That is the reason why 113383 won't work for this.
 * @author Yingjie Lian
 * @version 01/25/2017
 * @class CS-1410
 */
import java.util.Scanner;

public class Limit 
{
	public static void main(String[] args) 
	{	// Create two "int" variables and initialize both to 1 because
		// all the number we are going to count and check are bigger
		// than 1.
		int input = 1;
		int count = 1;
		// Create three "long" variables to find how long the program will
		// take in milliseconds.
		long start, end, milliseconds;
		start = System.currentTimeMillis();
		// Using a Boolean flag to create a loop to check if the number is less
		// than 0 because when the number exceed 2^31-1, it will return to -2^31.
		// At that time, the program will terminate and print out the number. 
		// That number is the smallest integer that we are looking for.
		boolean isSmallest = false;
		while (! isSmallest)
		{
			input = count;
			while (input != 1)
			{
				if (input % 2 == 1)
				{
					input = input * 3 + 1;
				}
				input = input / 2;
				if (input < 0)
				{
					System.out.println("The integer " + count + " is the smallest positive integer"
							+ " which cannot have its Hailstone sequence "
							+ "computed using int variables.");
					isSmallest = true;
					break;
				}
			}
			count++;
		}
		// Find out how long the program will take in milliseconds and print out a message
		// to tell the user.
		end = System.currentTimeMillis();
		milliseconds = end - start;
		System.out.println("The loop has finished in " + milliseconds + " milliseconds.");
	}
}
