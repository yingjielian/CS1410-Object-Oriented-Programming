package assignment02;
/**
 * I found the largest value that will be stored in current is: 1.6777216E7.
 * The reason that this program never terminates is because "float" type
 * will store all the numbers in binary. That means the number stored in
 * "float" type will never equal the number that you want to get, but it 
 * will get very very close to it.
 * 
 * For example, I use "float" to add 0.01 and 0.05. It did not print out 0.06, 
 * Rather, it prints 0.060000002 which is not equal to 0.06, but very very close
 * to it. The reason is that "float" will add the number from 1/2, 1/4, 1/8 to 
 * maybe 1/1024 or ever smaller to get the number really close to 0.06.
 * 
 * So that when we add 1 to a such big number like 1_000_000_000, the computer 
 * will count many many many times to find a number really close to it. Nevertheless,
 * that needs a long time. That why the program will not terminate!
 * @author Yingjie Lian
 * @version 01/25/2017
 * @class CS-1410
 */
public class Precision {

	public static void main(String[] args) {
		// Google floating point number explained and youtube
		// Create a "float" variable and name it current as it said from
		// the instruction.
		float current = 1;
		// Continue adding 1 to current and store the result back to current,
		// when current is larger than 1_000_000_000, the program will finish.
		while (current < 1_000_000_000)
		{
			
			current++;
//			System.out.println(current); //I used this line to find the largest number
										//stored in current which is 1.6777216E7.
		}
		// Print a prompt to tell the user that the program has finished.
		System.out.println("The loop has finished.");
	}

}
