package assignment02;
/**
 * This program is going to print out a Hailstone sequence when user input an positive
 * integer.
 * @author Yingjie Lian	
 * @version 01/24/2017
 * @class CS-1410 
 */

import java.util.Scanner;

public class Hailstone 
{
	public static void main(String[] args) 
	{	// Declare the needed variables by "int" type because the Hailstone sequence
		// will print all numbers by integer type.
		int userInput,count;
		userInput = 0;
		count = 0;
		// Use Scanner to get input from the user.
		Scanner in = new Scanner(System.in);
		// Using a Boolean flag, create an input loop that asks the user to enter
		// their number. Don't allow the program to proceed until the user enter a 
		// positive integer.
		boolean isPositive = false;
		
		while (! isPositive)
		{
			System.out.println("Enter a positive integer: ");
			if(in.hasNextInt())
				userInput = in.nextInt();
			else
				in.next();
			
			if (userInput > 0)
				isPositive = true;
		}
		// Print out the integer that user input and show them the Hailstone
		// sequence they got from the integer they put.
		System.out.println("The original integer you put is " + userInput + ".");
		System.out.print("The Hailstone sequence you got is: ");
		// Using the Hailstone computing rules to calculate the integer.
		while (userInput != 1)
		{
			System.out.print(userInput + " ");
			if (userInput % 2 == 0)
				userInput = userInput / 2;
			
			else if (userInput % 2 == 1)
				userInput = userInput * 3 + 1;
			count ++;
		}
		// Finally, tell the user after how many iterations, their integer has arrived at 1.
		System.out.println(userInput);
		System.out.println("After " + count + " iterations, your integer has arrived at 1.");
	}

}
