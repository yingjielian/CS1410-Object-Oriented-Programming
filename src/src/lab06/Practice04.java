package lab06;

import java.util.Scanner;

public class Practice04 {
	
	public static void main (String[] args){
		System.out.println("Enter an integer: ");
		Scanner s = new Scanner(System.in);
		
		if (isVowel(s.next().charAt(0)))
			System.out.println("It is a vowel.");
		else
			System.out.println("It is not a vowel.");
		
	}
	
	public static boolean isVowel (char n)
	{
		if (n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u')
			return true;
		else
			return false;
	}
}
