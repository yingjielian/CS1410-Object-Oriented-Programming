package lab02;

import java.util.Scanner;

public class test
{
	public static void main(String[] args)
	{
		
	}

	public static int candybrought (String[] data)
	{
		// Declare variables
		int candies = 0;
		
		if (data[1].equals("Adam"))
		{
			if (data[0].equals("Beth"))
				candies = 4;
			else if (data[0].equals("Cass"))
				candies = 3;
			else if (data[0].equals("Dole"))
				candies = 2;
		}
		
		else if (data[1].equals("Beth"))
		{
			if (data[0].equals("Evan"))
				candies = 3;
		}
		
		else if (data[1].equals("Evan"))
		{
			if (data[0].equals("Fury"))
				candies = 2;
		}
		
		else if (data[1].equals("Dole"))
		{
			if (data[0].equals("Greg"))
				candies = 6;
		}
		
		else if (data[1].equals("Cass"))
		{
			if (data[0].equals("Hugh"))
				candies = 4;
			else if (data[0].equals("Ivan"))
				candies = 6;
			else if (data[0].equals("Juan"))
				candies = 3;
		}
		
		if (data[1].equals("Ivan"))
		{
			if (data[0].equals("Kale"))
				candies = 1;
			else if (data[0].equals("Leon"))
				candies = 2;
			else if (data[0].equals("Mark"))
				candies = 1;
		}
		
		return candies;
	}
	
	public static int candyConsumed (String[] data)
	{
		// Declare variables
		int candies = 0;
		
		if (data[1].equals("Adam"))
		{
			if (data[0].equals("Beth"))
				candies = 2;
			else if (data[0].equals("Cass"))
				candies = 4;
			else if (data[0].equals("Dole"))
				candies = 3;
		}
		
		else if (data[1].equals("Beth"))
		{
			if (data[0].equals("Evan"))
				candies = 1;
		}
		
		else if (data[1].equals("Evan"))
		{
			if (data[0].equals("Fury"))
				candies = 1;
		}
		
		else if (data[1].equals("Dole"))
		{
			if (data[0].equals("Greg"))
				candies = 2;
		}
		
		else if (data[1].equals("Cass"))
		{
			if (data[0].equals("Hugh"))
				candies = 4;
			else if (data[0].equals("Ivan"))
				candies = 4;
			else if (data[0].equals("Juan"))
				candies = 1;
		}
		
		if (data[1].equals("Ivan"))
		{
			if (data[0].equals("Kale"))
				candies = 6;
			else if (data[0].equals("Leon"))
				candies = 5;
			else if (data[0].equals("Mark"))
				candies = 6;
		}
		
		return candies;
	}
	
	public static String[] checkPeople(String[] data)
	{
		String[] halloween = new String[]{};
		String[] cass1 = new String[]{"Hugh", "Cass", "4", "4"};
		String[] cass2 = new String[]{"Ivan", "Cass", "6", "4"};
		String[] cass3 = new String[]{"Juan", "Cass", "3", "1"};
		String[] ivan1 = new String[]{"Kale", "Ivan", "1", "6"};
		String[] ivan2 = new String[]{"Leon", "Ivan", "2", "5"};
		String[] ivan3 = new String[]{"Mark", "Ivan", "1", "6"};
		if (data[1].equals("Adam"))
		{
			if (data[0].equals("Beth"))
				halloween = new String[]{"Evan", "Beth", "3", "1"};
			else if (data[0].equals("Cass"))
			{	return cass1;
				return cass2;
				return cass3;
			}
			else if (data[0].equals("Dole"))
				halloween = new String[]{"Greg", "Dole", "6", "2"};
		}
		
		else if (data[1].equals("Beth"))
		{
			halloween = new String[]{"Evan", "Beth", "3", "1"};
		}
		
		else if (data[1].equals("Evan"))
		{
			halloween = new String[]{"Fury", "Evan", "2", "2"};
		}
		
		else if (data[1].equals("Dole"))
		{
			halloween = new String[]{"Greg", "Dole", "6", "2"};
		}
		
		else if (data[1].equals("Cass"))
		{
			if (data[0].equals("Hugh"))
				return null;
			else if (data[0].equals("Ivan"))
			{
				return ivan1;
				return ivan2;
				return ivan3;
			}
			else if (data[0].equals("Juan"))
				halloween = new String[]{"Juan", "Cass", "3", "1"};
		}
		
		if (data[1].equals("Ivan"))
		{
			if (data[0].equals("Kale"))
				halloween = new String[]{"Kale", "Ivan", "1", "6"};
			else if (data[0].equals("Leon"))
				halloween = new String[]{"Leon", "Ivan", "2", "5"};
			else if (data[0].equals("Mark"))
				halloween = new String[]{"Mark", "Ivan", "1", "6"};
		}
		
	}
}