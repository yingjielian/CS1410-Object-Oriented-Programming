package assignment05;
/**
 * @author Yingjie Lian
 * @version 02/27/2017
 * @class CS-1410
 */
 
/* No other imports are allowed. */
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
/* No other imports are allowed. */

/**
 * <p>
 * This class is a collection of static methods for processing arrays.
 * There are no instance or static variables, and none are allowed.
 * (In other words, only use variables declared inside each method.)
 * You will not build ArrayExercises objects.  Instead, you'll just
 * call (execute) the static methods in this class.
 * </p>
 * 
 * <p>
 * This class is the starting point for programming assignment #5.  Each
 * method has a contract, and you will write the statements inside
 * each method to exactly satisfy the contract.  Note:  Some methods
 * indicate they might return an exception.  You don't need to throw
 * these exceptions -- I've anticipated what exceptions will be thrown
 * normally when incorrect parameters are passed to the methods.
 * (Don't add code to throw exceptions.)
 * </p>
 * 
 * <p>
 * When completing the lab or the assignment, students may not use any 
 * Java library methods for sorting or searching through arrays.
 * (You will write equivalent code here instead.)
 * </p>
 * 
 */

public class ArrayExercises
{
	/**
	 * <p>
	 * This method returns an array of size 'size' full of unique randomly
	 * ordered integers in the range [0..size).  All integers in the range
	 * [0..size) will be in the array, but they will be in a shuffled order.
	 * </p>
	 * 
	 * <p>
	 * From Peter:  This is an example array function that is more complex than 
	 * most of the assignment problems.  I am providing it to show you an 
	 * interesting use of arrays as well as to show you how unit tests can be 
	 * used to check correctness of methods and classes.
	 * </p>
	 * 
	 * @param size the number of array locations requested
	 * @return an array of the specified size filled with randomly ordered integers
	 */
	public static int[] randomArray (int size)
	{
		// Create an array of the requested size.

		int[] numbers = new int[size];  // If size is negative, this throws an exception. 

		// Fill the array with the integers [0..size)

		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i;  // Just store the index of each location in the location, not normally done.

		// Shuffle the array (starting from the right).  For each
		//   position i, find a random position j, and swap elements
		//   at those positions.

		for (int i = numbers.length - 1; i >= 0; i--)
		{
			// Pick a random location for j (but only to the left of i).
			//   (Getting this wrong creates a bias - must do it as shown.)

			int j = (int) (Math.random()*(i+1));

			j = (int) (Math.random() * size);  // This way is wrong - feel free to uncomment it to cause an error.

			// Swap elements i and j in the array.

			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;            
		}

		// Done.  Feel free to uncomment the lines below to simulate errors.

		// numbers = new int[size+1];  // This causes an error - the array size is wrong.
		// numbers[0] = -1;  // This causes an error - a number is overwritten.  I use it for testing my error code.

		return numbers;
	}

	/**
	 * <p>
	 * This method counts and returns how many times the target
	 * object occurs in the array.  For this method,
	 * two objects are considered the same if they represent
	 * the same thing.  In other words, use .equals().
	 * </p>
	 * 
	 * <p><b>This is problem #1 for programming assignment #5.</b></p>
	 *
	 * <p>(Hint:  For testing, you can use arrays of Strings.)</p>
	 * 
	 * @param values   An array of Object references
	 * @param target   A target object
	 * @return   The number of objects in the array that equal the target
	 * @throws NullPointerException   If values is null 
	 */
	public static int count (String[] values, String target)
	{
		int count = 0;
		
			for (int i = 0; i < values.length; i++)
			{
				if (target.equals(values[i]))
					count++;
			}
		
		return count;
	}

	/**
	 * <p>
	 * This method reverses 'in place' the elements in
	 * the array.  Reversing is defined as moving the
	 * elements in the array such that the first element
	 * becomes the last element, the second element
	 * becomes the second to last element, the third
	 * element becomes the third to last element, etc.
	 * </p>
	 * 
	 * <p>
	 * This method does not have a return
	 * type - the list array is modified directly.  In other words,
	 * the contents of the data array will be changed and the
	 * caller will see the changes. 
	 * </p>
	 * 
	 * <p><b>This is problem #2 for programming assignment #5.</b></p>
	 *
	 * <p>(Hint:  Many students loop too far, and accidentally
	 * do and undo the reversal.)</p>
	 * 
	 * @param symbols   An array that will be reversed.
	 */
	public static void reverseOrder (char[] symbols)
	{
		char[] duplicate = symbols.clone();
		for (int i = 0; i < symbols.length; i++)
		{
			char temp = duplicate[duplicate.length - 1 - i];
			symbols[i] = temp;
		}
	}


	/**
	 * <p>
	 * This method examines the elements in the array and
	 * replaces all occurrences of the original String 
	 * with the replacement String.
	 * </p>
	 * 
	 * For this method, two Strings are considered equal
	 * if they refer to the same object.  (Use ==)  Note that either
	 * the original String, the replacement String, or
	 * any of the Strings in the list may be null, and this is
	 * both allowed and expected on occasion.
	 * </p>
	 * 
	 * <p>
	 * This method does not have a return
	 * type - the list array is modified directly.  In other words,
	 * the contents of the data array will be changed and the
	 * caller will see the changes. 
	 * </p>
	 * 
	 * <p><b>This is problem #3 for programming assignment #5.</b></p>
	 * 
	 * <p>Hint:  If you have "Hello" and "Hello" in separate places
	 * in your code, note that Eclipse may choose to create a single
	 * String object for both of these "Hello" strings, and use it 
	 * in both places that "Hello" exists.</p>
	 * 
	 * @param list   An array of String references
	 * @param original   The String reference to be replaced
	 * @param replacement   The replacement String reference
	 * @throws NullPointerException   If list is null
	 */
	public static void replace (String[] list, String original, String replacement)
	{
		for (int i = 0; i < list.length; i++)
		{
			if (list[i] == (original))
			{
				list[i] = replacement;
			}
		}
	}

	/**
	 * <p>
	 * This method computes and returns the area of several rectangular
	 * regions.  The data is not stored in Rectagle objects.  Instead,
	 * the data is stored in parallel arrays.  (In parallel arrays,
	 * data at position i in each array is related to the data in the
	 * other arrays at position i.
	 * </p>
	 * 
	 * <p>
	 * For a rectangle i, width[i] specifies
	 * the width of the rectangle, and height[i] specifies
	 * the height of the rectangle.</p>
	 * 
	 * <p> A new array is created
	 * (that is the same size as the width and height arrays)
	 * and the area of each rectangle is computed and placed
	 * in this array.  (Area of rectangle i would be stored
	 * in the ith position in the array.)  The array is then returned.
	 * </p>
	 * 
	 * <p>
	 * This method assumes (but does not check) that the widths and heights are positive.
	 * </p>
	 * 
	 * <p>
	 * Note that width and height arrays must be the same size.
	 * </p>
	 * 
	 * <p><b>This is problem #4 for programming assignment #5.</b></p>
	 * 
	 * @param widths   An array of rectangle widths
	 * @param heights  An array of rectangle heights
	 * @return   An array of rectangle areas
	 * @throws NullPointerException   If widths or heights is null
	 * @throws ArrayIndexOutOfBoundsException   If widths or heights are not the same size
	 */
	public static double[] computeAreas (double[] widths, double[] heights)
	{
		double[] areas = new double[] {};
		for (int i = 0; i < widths.length; i++)
		{
			areas[i] = widths[i] * heights[i];
		}
		
		return areas;
	}

	/**
	 * <p>
	 * This method creates and returns a new array that
	 * contains all the colors stored in the original array,
	 * except those colors that are equal to the target.  For this
	 * method, two colors are equal if they represent the
	 * same color.
	 * </p>
	 * 
	 * <p>
	 * Note that target may be null, and 'pixels' may contain
	 * null elements.  Two null elements will be considered equal.
	 * </p>
	 * 
	 * <p><b>This is problem #5 for programming assignment #5.</b></p>
	 * 
	 * <p>(Hint:  Use Color.BLUE, Color.GREEN, etc. for testing.)</p>
	 * 
	 * @param pixels   An array of Color references
	 * @param target   The Color object to be removed
	 * @throws NullPointerException   If pixels is null
	 */
	public static Color[] remove (Color[] pixels, Color target)
	{
		int count = 0; // represents number of instances of the target in the array
    	// Look for target in array
    	for (int i = 0; i < pixels.length; i++) {
    		if (pixels[i].equals(target))
    			count++; // Increment count
    	}
    	
    	// calculate new size
    	int newSize = pixels.length - count;
    	
    	// create new array
    	Color[] colors = new Color[newSize];
    	
    	// populate the array
    	int newIndex = 0;
    	for (int i = 0; i < pixels.length; i++) {
    		if (!pixels[i].equals(target)) {
    			colors[newIndex] = pixels[i];
    			newIndex++;
    		}
    	}
    	
        return colors;
	}


	/**
	 * <p>
	 * This method sorts the elements in the data array
	 * in descending order.  (The largest element will 
	 * be placed in position 0.)
	 * </p>
	 * 
	 * <p>
	 * Note that this method does not have a return
	 * type - the data array is sorted 'in place'.  In other words,
	 * the contents of the data array will be changed and the
	 * caller will see the changes.
	 * </p>
	 * 
	 * <p><b>This is problem #7 for programming assignment #5.  Your
	 * TA will help you with this problem during Tuesday's lab.</b></p>
	 * 
	 * @param data   The array to be sorted
	 * @throws NullPointerException   If data is null
	 */    
	public static void sort (int[] data)
	{
		 // Put down
		for (int i = 0; i < data.length; i++)
		{
			int indexOfLargestSoFar = i;
			// Find the biggest element in Unsorted Portion
			for (int j = i; j < data.length; j++)
			{
				if(data[j] > data[i])
					indexOfLargestSoFar = j;
			}
			// Swap
			int temp = data[i];
			data[i] = data[indexOfLargestSoFar];
			data[indexOfLargestSoFar] = temp;
		}
	}


	/**
	 * <p>
	 * This method finds and returns the smallest rectangle in the
	 * array.  The smallest rectangle is defined as the one
	 * with the smallest area.  If two rectangles have the same
	 * smallest area, the one that occurs last in the array
	 * is returned.
	 * </p>
	 * 
	 * <p>
	 * This method requires that the rectangles array 
	 * must not contain null.
	 * </p>
	 * 
	 * <p><b>This is problem #6 for programming assignment #5.</b></p>
	 * 
	 * <p>(Hint:  Look up the documentation for the Rectangle class.
	 * You'll see how to extract the needed information from each Rectangle.)</p>
	 * 
	 * @param rectangles   An array of rectangle objects
	 * @return   The smallest rectangle in the array
	 * @throws NullPointerException   If rectangles is null or rectangles contains null
	 */
	public static Rectangle findSmallest (Rectangle[] rectangles)
	{
		// Create new array to hold areas
    	double[] areas = new double[rectangles.length];
    	
    	// Creates a loop to get the Width and Height from each element in 'rectangles' and puts in into areas[i]   	
    	for(int i = 0; i < rectangles.length; i++)
    	{	
    		double width = rectangles[i].getWidth(); 	// Gets width from rectangle i
    		double height = rectangles[i].getHeight();	// Gets height from rectangle i
    		
    		//System.out.println(width + " and " + height);
 
        	areas[i] = width * height;	// Multiplies Width * Height to get area and puts it into the new array
 
    	}
    	
    	// New variables to hold the smallest area and the corresponding smallest Rectangle
    	double smallestArea = areas[0];
    	Rectangle smallestRectangle = null;
    	
    	// Loop to test for the smallest area
	    for(int i = 0; i < areas.length; i++)
	    {	
	    
    		for(int j = i; j < areas.length; j++)
	    	{	
	    		if(areas[j] < smallestArea || areas[j] == (smallestArea))
	    		{
	    			smallestRectangle = rectangles[j];	//If areas[j] is smallest area, it sets the corresponding rectangle as the smallest rectangle
	    		}
	    	}
	    
	    }	

        return smallestRectangle;
	}        


	/**
	 * <p>
	 * This method counts how many times each value appears 
	 * in the data array, and returns an array of these counts.
	 * (If 16 occurs 13 times in the data array, then 
	 * the returned array will contain a thirteen in position 16
	 * of the array.)  This method assumes that data values 
	 * will be non-negative and small.
	 * </p>
	 * 
	 * <p>
	 * The size of the returned list is determined by the maximum value
	 * stored in the data array.  The size of the returned list will be
	 * one greater than the maximum value stored in the data array.
	 * </p>
	 * 
	 * <p><b>This is problem #8 for programming assignment #5.</b></p>
	 * 
	 * <p>(Hint:  This problem has two major steps.  Solve them one at a time,
	 * and don't try to mix the code between the two steps.  (Keep the ideas
	 * and code steps separate as much as you can.)</p>
	 * 
	 * @param data   A data array
	 * @return   An array of counts
	 */
	public static int[] histogram (int[] data)
	{
		// declares a variables to hold the length of the new histogram
    	int newHistLength = 0;
    	
    	// Count characters in array
    	for (int i = 0; i < data.length; i++) 
    	{
    			// checks for the maximum value in the array
    			if (data[i] > newHistLength)
    				newHistLength = data[i];	// sets the length of the new array
    	}
	
    	// Declares a new histogram of length 'newHistLength'
    	int[] histogram = new int[newHistLength + 1];	// adds 1 to the length of the histogram to account for element '0'
    	
    	// sets all the elements in 'histogram' equal to zero
    	for(int i = 0; i < histogram.length; i++)
    	{
        	histogram[i] = 0;
    	}
    	
    	// creates a new loop to count each age and record it to the histogram
    	for(int i = 0; i < data.length; i++)
    	{	
        	histogram[data[i]]++;	// adds one to the element in 'histogram' for the given value of 'ages'
    
    	}
    	
    	
    	// returns the new histogram of the ages
        return histogram;         
	}

	/**
	 * <p>
	 * This method creates and returns a new array that contains a list of the
	 * unique File objects that occur in the files array.  For this method,
	 * File objects are the same if they are equal using the .equals method.
	 * (The returned array is the set of file objects.)
	 * </p>
	 * 
	 * <p>
	 * The size of the returned list is determined by the number of unique
	 * items in the original list.  The order of the items in the returned
	 * list is unspecified.
	 * </p>
	 * 
	 * <p>
	 * The files array must not contain null.
	 * </p>
	 * 
	 * <p><b>This is problem #9 for programming assignment #5.</b></p>
	 * 
	 * <p>(Hint:  This problem also has two major steps.  Solve them one at a time,
	 * and don't try to mix the code between the two steps.  (Keep the ideas
	 * and code steps separate as much as you can.)  Additionally, the
	 * code for each step is very similar.</p>
	 * 
	 * <p>(Warning:  You cannot use Java collections, or any other built-in
	 * class that helps build sets.  Figure out your own way to see if the array
	 * has duplicates in it.)</p>
	 * 
	 * @param files   An array of File objects, possibly containing duplicates
	 * @return   An array of unique File objects
	 * @throws NullPointerException   If files is null or files contains null
	 */    
	public static File[] getUniqueSet (File[] files)
	{
		// New array to hold unique files
    	File[] uniqueFiles = new File[files.length];

    	// Set the first uniqueFile to the first 'files' value 
    	uniqueFiles[0] = files[0];	
    	
    	// This is a counter for the next empty space in uniqueFiles
    	int positionValue = 1;

    	// boolean switch to tell if value is unique
    	boolean uniqueValue=false;
    	
    	// This creates a loop that will compare the next first value to the next and see if they are the same
    	for(int i = 1; i < files.length; i++)
    	{		
    		//loops through new array, compares to 'files' and checks for equality
    		for(int j = 0; j < uniqueFiles.length; j++)
    		{	
    			if(files[i].equals(uniqueFiles[j]))	// if equal sets unique to false
    			{	
    				uniqueValue = false;
    				break;
    			}
    			else	//if not equal sets unique to true
    			{
    				uniqueValue = true;
    			}
    		}
    		
    		if(uniqueValue)
			{	uniqueFiles[positionValue] = files[i];	//sets new value in uniqueFiles	
				positionValue++; // Increments position counter
				
			}
    	}
    	
    	int newArrayLength = 0;	//counter for new array length
    	
    	//loops through to count all value that are not 'null'
    	for(int i = 0; i < uniqueFiles.length; i++)
    	{	
    		if(uniqueFiles[i] == (null))
    			break;
    		if(!uniqueFiles[i].equals(null))
    			newArrayLength++;	
    		
    	}
    	
    	// Array with unique values and no null values
    	File[] newArray = new File[newArrayLength];
    	
    	for(int i = 0; i < newArray.length; i++)
    	{
    		newArray[i] = uniqueFiles[i];
  
    	}

    	// remember to delete Arrays import
  
        return newArray;
	}
}
