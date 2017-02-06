package assignment01;
/**
 * This class implements this cool idea: When user input a decimal number,
 * the program will give the user a binary number.
 * 
 * @author Yingjie Lian
 * @version January 17, 2017
 * @class CS-1410
 * 
 */
import java.util.Scanner;

public class Binary 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Declare the needed variables by "int" type because we are going to
		// indicate the binary number by 1 or 0 which are both integers.
		int a,b,c,d,e,f,g,h,userPut;
		
		// Use Scanner to get input from the user.
		Scanner in = new Scanner(System.in);
		
		// Prompt the user to enter an integer.
		System.out.println("Enter a number: ");
		userPut = in.nextInt();
		
		// The basic idea of my algorithm is going to follow the calculate rules
		// from decimal number to binary number. The algorithm will divide by 2 and if there is a remainder,
		// then keep the remainder 1 to print out. Otherwise, print out the 0 instead.
		a = userPut % 2;
		b = (int) (userPut / Math.pow(2, 1) % 2);
		c = (int) (userPut / Math.pow(2, 2) % 2);
		d = (int) (userPut / Math.pow(2, 3) % 2);
		e = (int) (userPut / Math.pow(2, 4) % 2);
		f = (int) (userPut / Math.pow(2, 5) % 2);
		g = (int) (userPut / Math.pow(2, 6) % 2);
		h = (int) (userPut / Math.pow(2, 7) % 2);
		
		// Finally, print the results to the console window
		System.out.println("The decimal number " + userPut +
				" is " + h + g + f + e + d + c + b + a + 
				" in binary.");	
	}
}
