package lab06;

import java.util.Scanner;

public class Practice07 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int a = s.nextInt();
		System.out.println("Enter another integer: ");
		int b = s.nextInt();
		System.out.println(bigger(a,b));
			

	}

	public static int bigger(int a, int b)
	{
	
		if (Math.abs(a - 50) < Math.abs(b - 50))
		{
			return a;
		}
		return b;
	}
}
