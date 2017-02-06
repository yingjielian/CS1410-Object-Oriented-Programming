package assignment02;
/**
 * This program is going to count how long the program will finish. 
 * 
 * I changed the original add 1 to add 7 because the program goes so fast
 * when adding 1 and my computer cannot even count the time (the time for
 * adding 1 is 0!). 
 * 
 * The program will finally finish is because the range for
 * "int" type is from -2^31 to 2^31-1. When the number reached 2^31-1 it will
 * return to -2^31 and keep adding 7 (or 1) until the number equal -100. I first
 * used the System.currentTimeMillis() and try to find how long this program will
 * take, but it always print out 0 millisecond. Then I used System.nanoTime() and 
 * tried to find how long it will take in microseconds. After several tests, I found 
 * that it need about 3_000_000 microseconds to finish the computing.
 * 
 * Also, the reason adding 1 is faster than adding 7 to let the number equal -100 is
 * because adding 1 will let the number equal -100 at the first loop (just one 
 * time); however, adding 7 will let the number equal -100 after several loops 
 * (not at one time). Thus, adding 7 need more time than adding 1.
 * 
 * @author Yingjie Lian
 * @version 01/25/2017
 * @class CS-1410
 */
 public class Overflow 
{
	public static void main(String[] args) 
	{
		// Created two "int" variables a, b and initialize each 
		// followed by the instruction.
		int a, b;
		a = 1;
		b = -100;
		// Using "long" to count the time of the program proceeding 
		// in microseconds.
		long start = System.nanoTime();
		// Create a loop to continue add 1 and store back to a. When
		// a = b, the program will terminate.
		while (a != b)
		{
			a++;
		}
		
		long end = System.nanoTime();
		long microseconds = end - start;
		// Print out how long the program finished in microseconds.
		System.out.println("The loop has finished in " + microseconds + " microseconds.");
	}

}
