package assignment05;
/**
 * @author Yingjie Lian
 * @version 02/27/2017
 * @class CS-1410
 */

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.File;
import java.util.Arrays;

import org.junit.Test;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */
public class ArrayExercisesTest
{
	
	public static void main (String[] args)
	{
		Color[] pixels = new Color[] {Color.BLACK, Color.CYAN, Color.GRAY, Color.yellow};
		Color target = Color.BLACK;
		System.out.println(Arrays.toString(ArrayExercises.remove(pixels, target)));
	}
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
		
		if (Math.abs(166_666 - count012) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012); 	
		
		if (Math.abs(166_666 - count021) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021); 	
		
		if (Math.abs(166_666 - count102) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102); 	
		
		if (Math.abs(166_666 - count120) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120); 	
		
		if (Math.abs(166_666 - count201) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201); 	
		
		if (Math.abs(166_666 - count210) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210); 	
		
		// If execution completes without failing, the test passes!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	/**
	 * 
	 */
	@Test
	public void testCount01()
	{
		String[] values = new String[]{};
		String target = "nba";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 0);
	}

	@Test
	public void testCount02()
	{
		String[] values = new String[]{"hi", "nba", "hi"};
		String target = "hi";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 2);
	}
	
	@Test
	public void testCount03()
	{
		String[] values = new String[]{"hi", "nba", "hi"};
		String target = "nfl";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 0);   
	}
	
	@Test
	public void testCount04()
	{
		String[] values = new String[]{"hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"};
		String target = "hi";
		int count = ArrayExercises.count(values, target);
		assertTrue(count == 9);
	}
	
	@Test
	public void testReverseOrder01()
	{
		char[] symbols = new char[]{};
		char[] reversed = new char[]{};
		ArrayExercises.reverseOrder(symbols);
		assertArrayEquals(symbols, reversed);
	}
	
	@Test
	public void testReverseOrder02()
	{
		char[] symbols = new char[]{'a', 'e', 'i', 'o', 'u'};
		char[] reversed = new char[]{'u', 'o', 'i', 'e', 'a'};
		ArrayExercises.reverseOrder(symbols);
		assertArrayEquals(symbols, reversed);
	}
	
	@Test
	public void testReverseOrder03()
	{
		char[] symbols = new char[]{'a', 'e', 'b', 'b'};
		char[] reversed = new char[]{'b', 'b', 'e', 'a'};
		
		ArrayExercises.reverseOrder(symbols);
		assertArrayEquals(symbols, reversed);
	}

	@Test
	public void testReplace()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testComputeAreas()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRemove01()
	{
		Color[] pixels = new Color[] {};
		Color target = Color.BLACK;
		Color[] newColors = new Color[] {};
		Color[] result = ArrayExercises.remove(pixels, target);
		assertArrayEquals(newColors, result);
	}
	
	@Test
	public void testRemove02()
	{
		Color[] pixels = new Color[] {Color.BLACK, Color.CYAN, Color.GRAY, Color.yellow};
		Color target = Color.BLACK;
		Color[] newColors = new Color[] {Color.CYAN, Color.GRAY, Color.yellow};
		Color[] result = ArrayExercises.remove(pixels, target);
		assertArrayEquals(newColors, result);
	}

	@Test
	public void testSort01()
	{
		int[] unsorted = new int[] {4, 10, 1, 3};
		int[] sorted = new int [] {10, 4, 3, 1};
// 		fail("Not yet implemented");
 		
 		ArrayExercises.sort(unsorted);
 		
// 		assertTrue();
// 		assertFalse();
 		
// 		for(int i = 0; i < sorted.length; i++)
// 		{	
// 			assertEquals(sorted[i], unsorted[i]);
// 		}
 		
 		assertArrayEquals(sorted, unsorted);
	}
	
	
	@Test
	public void testSort02()
	{
		int[] unsorted = new int[] {1, 2, 3, 4, 5};
		int[] sorted = new int [] {5, 4, 3, 2, 1};
// 		fail("Not yet implemented");
 		
 		ArrayExercises.sort(unsorted);
 		
// 		for(int i = 0; i < sorted.length; i++)
// 		{	
// 			assertEquals(sorted[i], unsorted[i]);
// 		}
 		
 		assertArrayEquals(sorted, unsorted);
	}

	@Test
	public void testFindSmallest()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testHistogram()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetUniqueSet()
	{
		File a = new File("hello");
		File b = new File("hello");
		fail("Not yet implemented");
	}

}
