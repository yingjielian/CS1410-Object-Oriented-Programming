package lab06;

import java.util.Scanner;

public class Practice08 {

	public static void main(String[] args) {
		System.out.println("Enter a word: ");
		Scanner s = new Scanner(System.in);
		String reversed = myReverse(s.nextLine());
		System.out.println(reversed);

	}

	
	private static String myReverse(String str) {
	    String reverse = "";
	    int length = str.length();
	    for( int i = length - 1 ; i >= 0 ; i-- ) {
	       reverse = reverse + str.charAt(i);
	    }
	    return reverse;
	}
}
