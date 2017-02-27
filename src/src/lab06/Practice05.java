/**
 * 
 */
package lab06;

import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class Practice05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		System.out.println("Enter an integer: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if (isPrime(n))
			System.out.println(n + " is a prime.");
		else
			System.out.println(n + " is NOT a prime.");
			
		


	}

	public static boolean isPrime(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}


}
