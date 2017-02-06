package assignment01;
/**
 * This class implements this cool idea: This program will transfer the 
 * temperture from Fahrenheit degree to Celsius degree.
 * 
 * @author Yingjie Lian
 * @version January 17, 2017
 * @class CS-1410
 * 
 */
import java.util.Scanner;

public class Temperature 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// Declare the needed variables, make them 'int' type because
		// we are dealing with decimals math.
		int celsius, fahrenheit;
		
		// Use Scanner to get input from the user.
		Scanner in = new Scanner(System.in);
		
		// Prompt the user to enter an integer.
		System.out.println("Enter a Fahrenheit temperature: ");
		fahrenheit = in.nextInt();
		
		// Compute the degree to Celsius degree.
		celsius = (fahrenheit - 32) * 5 / 9;
		
		// Finally, print the results to the console window.
		System.out.println("The temperature you entered is " + celsius + 
				" Celsius degree.");		
	}
}
