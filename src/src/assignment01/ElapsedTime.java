package assignment01;
import java.util.Scanner;

/**
 * This class implements this cool idea: When user input the time by seconds, this program will
 * tell the user 
 * @author Yingjie Lian
 * @version January 17, 2017
 * @class CS-1410
 *
 */

public class ElapsedTime 
{
	public static void main(String[] args) 
	{	
		// Declare the needed variables, make them 'int' type because
		// we are dealing with decimals math.
		int time, hours, minutes, seconds;
		
		// Use Scanner to get input from the user.
		Scanner in = new Scanner(System.in);
		
		// Prompt the user to enter an integer.
		System.out.println("Enter the time in seconds: ");
		time = in.nextInt();
		
		// Compute the result which from seconds to hours, minutes, and seconds.
		hours = time / 3600;
		minutes = time % 3600 / 60;
		seconds = time % 3600 % 60;
	
		// Finally, print the results to the console window. I used printf instead of 
		// println because that way the time will print out like this: 00:00:00.
		System.out.printf("The time you entered is %02d:%02d:%02d",hours,minutes,seconds); 		
	}

}
