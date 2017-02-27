package lab06;

import java.util.Scanner;

public class Practice03 {

	public static void main(String[] args) {

		int n = 0;
		System.out.println("Enter an integer: ");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		n = Math.abs(n);

		for (int i = 1; i <= n; i++)
		{
			if (n % i == 0)
				System.out.println(i);
		}
	}

}
