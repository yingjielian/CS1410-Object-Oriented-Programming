package tests;

import java.util.Arrays;

public class test1 {

	public static void main(String[] args) {

		int[] abc = new int[] {3,5,4,3,2,4,4,4};
		System.out.println(Arrays.toString(histogram(abc)));

	}

	public static int[] histogram (int[] ages)
	{	
		// declares a variables to hold the length of the new histogram
		int newHistLength = 0;

		// Count characters in array
		for (int i = 0; i < ages.length; i++) 
		{
			// checks for the maximum value in the array
			if (ages[i] > newHistLength)
				newHistLength = ages[i];	// sets the length of the new array
		}

		// Declares a new histogram of length 'newHistLength'
		int[] histogram = new int[newHistLength + 1];	// adds 1 to the length of the histogram to account for element '0'

		// sets all the elements in 'histogram' equal to zero
		for(int i = 0; i < histogram.length; i++)
		{
			histogram[i] = 0;
		}

		// creates a new loop to count each age and record it to the histogram
		for(int i = 0; i < ages.length; i++)
		{	
			histogram[ages[i]]++;	// adds one to the element in 'histogram' for the given value of 'ages'

		}

		// returns the new histogram of the ages
		return histogram;       
	}



}
