package assignment01;
/**
 * This class implements this cool idea: When user input a 
 * radius, they will get the area of the circle
 * 
 * @author Yingjie Lian
 * @version January 17, 2017
 * @class CS-1410
 * 
 */
import java.util.Scanner;

public class CircleArea 
{

	public static void main(String[] args) 
	{
		// Declare the needed variables, make them 'double' type because
		// we are dealing with decimals math.
		double radius, area;
	
		// Use Scanner to get input from the user.
		Scanner in = new Scanner(System.in);
		
		// Print a reminder to let user know to input a value for radius of the circle.
		System.out.println("Enter a radius: ");
		
		radius = in.nextDouble();
		
		// Compute the result which is the area of the circle.
		area = Math.pow(radius, 2) * Math.PI;
		
		// Finally, print the results to the console window.
		System.out.println("The area of the circle is: " + area);
			
	}

}
