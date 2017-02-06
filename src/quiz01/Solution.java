package quiz01;

import java.util.Scanner;

/**
 * This program is going to tell the user how many trucks they need to ship their packages and 
 * how many days their packages will be shipped.
 * @author Yingjie Lian
 * @version CS1410 01/24/2017
 */

public class Solution 
{
	public static void main(String[] args) 
	{
		//Decaler variables by type "int".
		int packages, trucks, days;
		//User Scanner to get the input from user
		Scanner in = new Scanner(System.in);
		//Print a prompt to remind user inputting a number.
		System.out.println("Please enter your package numbers: ");
		packages = in.nextInt();
		//Somer simple expressions to calculate the trucks and days that they need.
		trucks = packages / 17;
		days = packages / 510;
		
		if (packages < 17 && packages % 17 == 0 && packages > 0)
			System.out.println("You need 1 truck to ship your packages.");
		else if (packages % 17 == 0 && packages > 0)
			System.out.println("You need " + trucks + " trucks to ship your packages.");
		else if (packages % 17 != 0 && packages > 0)
			System.out.println("You need " + (trucks + 1) + " trucks to ship your packages.");
		
		if (packages % 510 == 0 && packages <= 510 && packages > 0)
			System.out.println("Your packages will be shipped in 1 day");
		else if (packages % 510 == 0 && packages > 0)
			System.out.println("Your packages will be shipped in " + days + " day(s)." );
		else if (packages % 510 != 0 && packages > 0)
			System.out.println("Your packages will be shipped in " + (days + 1) + " day(s)." );
		//Check the number if it's negative, tell the user it cannot exit.
		if (packages < 0)
			System.out.println("The number you entered is negative, "
					+ "negative number of packages cannot exit");
	}
}
