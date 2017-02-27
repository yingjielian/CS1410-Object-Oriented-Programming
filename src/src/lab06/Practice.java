package lab06;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		
		int result = 0;
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Enter an integer: ");
			Scanner s = new Scanner(System.in);
			result += s.nextInt();
		}
		
		System.out.println(result);
	}

}
