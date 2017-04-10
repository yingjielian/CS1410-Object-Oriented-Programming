package lab12;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Boxing {

	public static void main(String[] args)
	{
		int[] arr = new int[3];

		// ArrayList<int> myList = new ArrayList<int>(); // Because int is a primitive, need to be an Object

		Integer[] arr2 = new Integer[2];
		ArrayList<Integer> myList = new ArrayList<Integer>();

		Integer x = new Integer(3);
		Integer y = 3;  // Example of Boxing, Object store primitive

		Double zzzzzz = 0.0;

		int z = 3;

		int w = new Integer(3); // Example of Unboxing, primitive store Object

		System.out.println("x " + x);
		System.out.println("y " + y);
		System.out.println("z " + z);
		System.out.println("x and y are equal: " + (x == y)); // Because x and y are Objects, please use .euqal
		System.out.println("x and y are equal: " + (x.equals(y)));
		System.out.println(z == y);

		myList.add(new Integer(3));
		myList.add(4);
		myList.add(8);
		
		Integer sum = 0;
		// Sum up my items
		for(int num : myList){
			
			sum += num;	
		}
		
//		for(int i = 0; i < myList.size(); i++) // Same function for loop
//		{
//			sum += myList.get(i);
//		}

		System.out.println("sum is " + sum);
		System.out.println(myList.toString());

		myList.get(1);
		// arr.length;
		myList.size();



		/*
		 * Map and HashMap Examples
		 */
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		
		Map<String, BufferedImage> myPic = new HashMap<String, BufferedImage>();
		
		myMap.put("Yingjie", 421);
		myMap.put("Tyler", 1138);
		
		
		Integer resultSum = 0;
		for(int n : myMap.values())
		{
			resultSum += n;
		}
		
		System.out.println("resultSum is " + resultSum);
		System.out.println(myMap.toString());
		System.out.println("Yingjie's id is: " + myMap.get("Yingjie"));

		myMap.remove("Tyler");

		//		if(myMap.isEmpty()) // do not use myMap == 0!!

		if (myMap.containsKey("Tyler"))
		{
			System.out.println("Tyler's id is: " + myMap.get("Tyler"));
		}
		else
			System.out.println("Unfriended");

		if (myMap.containsKey("Greg"))
		{
			System.out.println("Greg's id is: " + myMap.get("Greg"));
		}
		else
			System.out.println("Bad");
		
		


	}


}