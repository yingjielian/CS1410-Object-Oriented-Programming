package assignment05;
/**
 * @author Yingjie Lian
 * @version 02/27/2017
 * @class CS-1410
 */

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.util.Arrays;

import org.junit.Test;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */
public class ArrayExercisesTest
{
	/* This is my first example unit test.  A unit test is just a piece of
	 * code that calls some method or builds some object, and tests 
	 * for errors.  The code/test is up to the programmer.  
	 * 
	 * The unit test library provides functions for 'asserting' correctness.
	 * I use assertEquals below.  If the two values are not equal, the
	 * unit test library records a failure.
	 * 
	 * There are other assert functions in the unit test library that are
	 * useful for noting errors.  If the function below completes without
	 * recording a failure, then the test is marked as a success.
	 */
	@Test
	public void testRandomArray01()
	{
		// Call the function, ask for an array of thirty elements.
		
		int[] result;
		int size = 30;
		
		result = ArrayExercises.randomArray(size);  // This calls the function I'm testing.
		
		// The function has a specific contract that guarantees things
		//  about it's return value.  Check to make sure the method
		//  call did what it was supposed to.
		
		// Make sure the size of the result array is correct.
		
		assertEquals(size, result.length);  // If unequal, an error is recorded.
		
		// Make sure the required numbers [0..n-1] are in the array.
		
		numberLoop:  for (int n = 0; n < size; n++)  // Notice that I labeled this loop
		{
			// Search for n in the array.  When found, move on to the next n.
			
			for (int pos = 0; pos < size; pos++)
				if (result[pos] == n)
					continue numberLoop;  // Continue the outer loop.
			
			// If we get this far, the number n was not found.  This is an error.
			
			fail("Number missing from random array: " + n + " in " + Arrays.toString(result));  // Record an error 	
		}		
		
		// If the number loop completes without failing, all tests pass!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	/* I wanted two unit tests for my function.  The first one, above,
	 *   just makes sure the basic operation of 'randomArray' is 
	 *   correct.  This second unit test makes sure the 'randomness'
	 *   is correct.  A truly random shuffle has equal likelihood
	 *   of any outcome.  I repeatedly generate random arrays,
	 *   then I count up results, and then check to make
	 *   sure that each outcome occurred with similar probability.
	 *   
	 * Because of the fact that random numbers may produce results
	 *   that look uneven, I loop many times to reduce the likelihood
	 *   of random results looking like an error. 
	 *   
	 * I do not expect students to study this code - it is complex.
	 *   I also don't like the way I'm counting permutations.  There
	 *   are better ways, but you haven't seen the required lectures
	 *   yet, so I'm using a more primitive solution.  I expect your
	 *   unit tests to be much less complex.
	 */ 
	@Test
	public void testRandomArray02()
	{
		// An array of three has six permutations.
		
		// Counts of how many times each permutation appears.
		
		int count012 = 0;
		int count021 = 0;
		int count102 = 0;
		int count120 = 0;
		int count201 = 0;
		int count210 = 0;
		
		// Repeatedly generate arrays (1,000,000 times).
		
		for (int count = 0; count < 1_000_000; count++)
		{
			// Generate an array of 3 elements.
			
			int[] result = ArrayExercises.randomArray(3);  // This calls the function I'm testing.
			
			// Keep counts of each permutation in the array.
			
			if (result[0] == 0 && result[1] == 1)       // [0, 1, 2]
				count012++;
			else if (result[0] == 0 && result[1] == 2)  // [0, 2, 1]
				count021++;
			else if (result[0] == 1 && result[1] == 0)  // [1, 0, 2]
				count102++;
			else if (result[0] == 1 && result[1] == 2)  // [1, 2, 0]
				count120++;
			else if (result[0] == 2 && result[1] == 0)  // [2, 0, 1]
				count201++;
			else // only other possibility is [2, 1, 0]
				count210++;
		}
		
		// Check each permutation.  It should occur 166,666 times on average.  Accept
		//   anything within +/- 3,000.
		
//		if (Math.abs(166_666 - count012) > 3_000)
//		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012); 	
//		
//		if (Math.abs(166_666 - count021) > 3_000)
//		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021); 	
//		
//		if (Math.abs(166_666 - count102) > 3_000)
//		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102); 	
//		
//		if (Math.abs(166_666 - count120) > 3_000)
//		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120); 	
//		
//		if (Math.abs(166_666 - count201) > 3_000)
//		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201); 	
//		
//		if (Math.abs(166_666 - count210) > 3_000)
//		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210); 	
		
		// If execution completes without failing, the test passes!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	/**
	 * Check an empty string array and the count should be 0
	 */
	@Test
	public void testCount01()
	{
		String[] values = new String[] {};
		String target = "nba";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 0);
	}

	/**
	 * Check a normal case the count should be the times that
	 * target words appeared
	 */
	@Test
	public void testCount02()
	{
		String[] values = new String[] {"hi", "nba", "hi"};
		String target = "hi";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 2);
	}
	
	/**
	 * Check if the target word was not in the String array,
	 * the count should be 0
	 */
	@Test
	public void testCount03()
	{
		String[] values = new String[] {"hi", "nba", "hi"};
		String target = "nfl";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 0);   
	}
	
	/**
	 * Check if the String array contains all the same Strings
	 */
	@Test
	public void testCount04()
	{
		String[] values = new String[] {"hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"};
		String target = "hi";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 9);
	}
	
	/**
	 * Check an empty char array case
	 */
	@Test
	public void testReverseOrder01()
	{
		char[] symbols = new char[] {};
		char[] reversed = new char[] {};
		ArrayExercises.reverseOrder(symbols);
		assertArrayEquals(symbols, reversed);
	}
	
	/**
	 * Check an normal char array case
	 */
	@Test
	public void testReverseOrder02()
	{
		char[] symbols = new char[] {'a', 'e', 'i', 'o', 'u'};
		char[] reversed = new char[] {'u', 'o', 'i', 'e', 'a'};
		ArrayExercises.reverseOrder(symbols);
		assertArrayEquals(symbols, reversed);
	}
	
	/**
	 * Check if the char array contains same characters
	 */
	@Test
	public void testReverseOrder03()
	{
		char[] symbols = new char[] {'a', 'e', 'b', 'b'};
		char[] reversed = new char[] {'b', 'b', 'e', 'a'};
		
		ArrayExercises.reverseOrder(symbols);
		assertArrayEquals(symbols, reversed);
	}
	
	/**
	 * Check if the char array contains the characters are all the same
	 */
	@Test
	public void testReverseOrder04()
	{
		char[] symbols = new char[] {'z', 'z', 'z', 'z'};
		char[] reversed = new char[] {'z', 'z', 'z', 'z'};
		
		ArrayExercises.reverseOrder(symbols);
		assertArrayEquals(symbols, reversed);
	}
	
	/**
	 * Empty array case
	 */
	@Test
	public void testReplace01()
	{
		String[] list = new String[] {};
		String original = "hi";
		String replacement = "hello";
		String[] replaced = new String[] {};
		ArrayExercises.replace(list, original, replacement);
		assertArrayEquals(replaced,list);
	}
	
	/**
	 * Normal case
	 */
	@Test
	public void testReplace02()
	{
		String[] list = new String[] {"hi", "nba", "hi"};
		String original = "hi";
		String replacement = "hello";
		String[] replaced = new String[] {"hello", "nba", "hello"};
		ArrayExercises.replace(list, original, replacement);
		assertArrayEquals(replaced,list);
	}
	
	/**
	 * Original word not in the String array.
	 */
	@Test
	public void testReplace03()
	{
		String[] list = new String[] {"hi", "nba", "hi"};
		String original = "hello";
		String replacement = "nfl";
		String[] replaced = new String[] {"hi", "nba", "hi"};
		ArrayExercises.replace(list, original, replacement);
		assertArrayEquals(replaced,list);
	}

	/**
	 * Empty case. Because there is no way to use assertArrayEquals to 
	 * check double array, so I use for loop and assertTrue to check if 
	 * two double values are equal. When they are equal, their difference
	 * should be really close to 0.
	 */
	@Test
	public void testComputeAreas01()
	{
		double[] widths = new double[] {};
		double[] heights = new double[] {};
		double[] areas = new double[] {};
		double[] result = ArrayExercises.computeAreas(widths, heights);
		
		for (int i = 0; i < areas.length; i++)
		{
			assertTrue(Math.abs(areas[i] - result[i]) < 0.00000001);
		}
	}
	
	/**
	 * Normal case.
	 */
	@Test
	public void testComputeAreas02()
	{
		double[] widths = new double[] {1, 2, 3};
		double[] heights = new double[] {3, 6, 9};
		double[] areas = new double[] {3, 12, 27};
		double[] result = ArrayExercises.computeAreas(widths, heights);
		
		for (int i = 0; i < areas.length; i++)
		{
			assertTrue(Math.abs(areas[i] - result[i]) < 0.00000001);
		}
	}
	
	/**
	 * More complex.
	 */
	@Test
	public void testComputeAreas03()
	{
		double[] widths = new double[] {1.8, 2.9, 3.4};
		double[] heights = new double[] {3.2, 6.6, 9.3};
		double[] areas = new double[] {5.76, 19.14, 31.62};
		double[] result = ArrayExercises.computeAreas(widths, heights);
		
		for (int i = 0; i < areas.length; i++)
		{
			assertTrue(Math.abs(areas[i] - result[i]) < 0.00000001);
		}
	}

	/**
	 * Empty case.
	 */
	@Test
	public void testRemove01()
	{
		Color[] pixels = new Color[] {};
		Color target = Color.BLACK;
		Color[] newColors = new Color[] {};
		Color[] result = ArrayExercises.remove(pixels, target);
		assertArrayEquals(newColors, result);
	}
	
	/**
	 * Normal case.
	 */
	@Test
	public void testRemove02()
	{
		Color[] pixels = new Color[] {Color.BLACK, Color.CYAN, Color.GRAY, Color.yellow};
		Color target = Color.BLACK;
		Color[] newColors = new Color[] {Color.CYAN, Color.GRAY, Color.yellow};
		Color[] result = ArrayExercises.remove(pixels, target);
		assertArrayEquals(newColors, result);
	}
	
	/**
	 * Array contains the values are all the same and also same to the target value.
	 * So after removing, it become an empty array.
	 */
	@Test
	public void testRemove03()
	{
		Color[] pixels = new Color[] {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK};
		Color target = Color.BLACK;
		Color[] newColors = new Color[] {};
		Color[] result = ArrayExercises.remove(pixels, target);
		assertArrayEquals(newColors, result);
	}
	
	/**
	 * Target word not inside the array. So the array won't do any change.
	 */
	@Test
	public void testRemove04()
	{
		Color[] pixels = new Color[] {Color.BLACK, Color.CYAN, Color.GRAY, Color.yellow};
		Color target = Color.GREEN;
		Color[] newColors = new Color[] {Color.BLACK, Color.CYAN, Color.GRAY, Color.yellow};
		Color[] result = ArrayExercises.remove(pixels, target);
		assertArrayEquals(newColors, result);
	}

	/**
	 * Empty case.
	 */
	@Test
	public void testSort01()
	{
		int[] unsorted = new int[] {};
		int[] sorted = new int [] {};
 		
 		ArrayExercises.sort(unsorted);
 		assertArrayEquals(sorted, unsorted); 		
	}
	
	/**
	 * Normal case. And use assertArrayEquals to check.
	 */
	@Test
	public void testSort02()
	{
		int[] unsorted = new int[] {4, 10, 1, 3};
		int[] sorted = new int [] {10, 4, 3, 1};
 		
 		ArrayExercises.sort(unsorted);
 		assertArrayEquals(sorted, unsorted); 		
	}
	
	/**
	 * Normal case, but use for loop and assertEquals to check.
	 */
	@Test
	public void testSort03()
	{
		int[] unsorted = new int[] {1, 2, 3, 4, 5};
		int[] sorted = new int [] {5, 4, 3, 2, 1};
 		
 		ArrayExercises.sort(unsorted);
 		
 		for(int i = 0; i < sorted.length; i++)
 		{	
 			assertEquals(sorted[i], unsorted[i]);
 		}
	}
	
	/**
	 * More complex case with some numbers are same.
	 */
	@Test
	public void testSort04()
	{
		int[] unsorted = new int[] {1, 2, 3, 4, 5, 5, 5, 6};
		int[] sorted = new int [] {6, 5, 5, 5, 4, 3, 2, 1};
 		
 		ArrayExercises.sort(unsorted);
 		for(int i = 0; i < sorted.length; i++)
 		{	
 			assertEquals(sorted[i], unsorted[i]);
 		}		
	}

	/**
	 * Empty case.
	 */
	@Test
	public void testFindSmallest01()
	{
		 Rectangle[] rectangles = new Rectangle[] {new Rectangle()};
		 Rectangle smallest = new Rectangle();
		 Rectangle result = ArrayExercises.findSmallest(rectangles);
		 assertEquals(smallest, result);
	}
	
	/**
	 * Simple normal case.
	 */
	@Test
	public void testFindSmallest02()
	{
		 Rectangle[] rectangles = new Rectangle[] {new Rectangle(4, 2), new Rectangle(3, 3)};
		 Rectangle smallest = new Rectangle(4, 2);
		 Rectangle result = ArrayExercises.findSmallest(rectangles);
		 assertEquals(smallest, result);
	}
	
	/**
	 * Complex normal case.
	 */
	@Test
	public void testFindSmallest03()
	{
		 Rectangle[] rectangles = new Rectangle[] {new Rectangle(1, 2, 3, 8), new Rectangle(1, 1, 6, 7), new Rectangle(2, 2, 6, 4)};
		 Rectangle smallest = new Rectangle(2, 2, 6, 4);
		 Rectangle result = ArrayExercises.findSmallest(rectangles);
		 assertEquals(smallest, result);
	}
	
	/**
	 * Empty case.
	 */
	@Test
	public void testHistogram01()
	{
		int[] data = new int[] {};
		int[] histogram = new int[] {0};
		int[] result = ArrayExercises.histogram(data);
		assertArrayEquals(result, histogram);
	}
	
	/**
	 * The array contains all the same numbers.
	 */
	@Test
	public void testHistogram02()
	{
		int[] data = new int[] {6, 6, 6};
		int[] histogram = new int[] {0, 0, 0, 0, 0, 0, 3};
		int[] result = ArrayExercises.histogram(data);
		assertArrayEquals(result, histogram);
	}
	
	/**
	 * Normal case.
	 */
	@Test
	public void testHistogram03()
	{
		int[] data = new int[] {3, 5, 1, 1, 3, 3, 3};
		int[] histogram = new int[] {0, 2, 0, 4, 0 ,1};
		int[] result = ArrayExercises.histogram(data);
		assertArrayEquals(result, histogram);
	}

	/**
	 * When two files are extra the same, return the last one.
	 */
	@Test
	public void testGetUniqueSet01()
	{
		File a = new File("hello");
		File b = new File("hello");
		File[] files = new File[] {a, b};
		File[] unique = new File[] {b};
		File[] result = ArrayExercises.getUniqueSet(files);
		assertArrayEquals(result, unique);
	}
	
	/**
	 * When the files are all unique.
	 */
	@Test
	public void testGetUniqueSet02()
	{
		File a = new File("Hi");
		File b = new File("Hello");
		File c = new File("How are you");
		File[] files = new File[] {a, b, c};
		File[] unique = new File[] {a, b, c};
		File[] result = ArrayExercises.getUniqueSet(files);
		assertArrayEquals(result, unique);
	}

	/**
	 * Normal case.
	 */
	@Test
	public void testGetUniqueSet03()
	{
		File a = new File("Hi");
		File b = new File("Hello");
		File c = new File("How are you");
		File d = new File("Hi");
		File e = new File("nba");
		File f = new File("Hello");
		File g = new File("How are you");
		File l = new File("How are you");
		File[] files = new File[] {a, b, c, d, e, f, g, l};
		File[] unique = new File[] {a, b, c, e};
		File[] result = ArrayExercises.getUniqueSet(files);
		assertArrayEquals(result, unique);
	}
}
