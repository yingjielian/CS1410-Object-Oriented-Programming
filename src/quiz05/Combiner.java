package quiz05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combiner 
{
	public static void main(String[] args)
	{
		List<Anthill> anthills = new ArrayList<>();
		List<Anthill> sorted = new ArrayList<>();

		try 
		{
			Scanner bobs =  new Scanner(new File("src/quiz05/Bob's Data.txt"));
			Scanner alices = new Scanner(new File("src/quiz05/Alice's Data.txt"));

			while(bobs.hasNext() && alices.hasNext())
				anthills.add(new Anthill(bobs.next(), bobs.nextInt(), alices.nextDouble(),
						alices.nextDouble(), alices.nextInt(), alices.nextInt()));

			System.out.println("First anthill object: " + anthills.get(0) + "\n");
			System.out.println("Second anthill object: " + anthills.get(1) + "\n");

			Anthill largestPopulation = anthills.get(0);
			Anthill largetDeltaHeight = anthills.get(0);

			for(Anthill a : anthills)
			{
				if(largestPopulation.getPopulation() < a.getPopulation())
				{
					largestPopulation = a;
				}
				
				if(largetDeltaHeight.getDeltaHeight() < a.getDeltaHeight())
				{
					largetDeltaHeight = a;
					sorted.add(largetDeltaHeight);
				}
				
			}

			System.out.println(largestPopulation.getName() + " has the largest population" +
					"which is: " + largestPopulation.getPopulation() + ". \n\nHere are the "
					+ "data for " + largestPopulation.getName() +" down below: ");

			System.out.println(largestPopulation + "\n");

			double totalLongitude = 0;
			int totoalLatitude = 0;
			int count = 0;

			for(Anthill a: anthills)
			{
				totalLongitude += a.getLongitude();
				totoalLatitude += a.getLatitude();
				count++;
			}
			
			

			System.out.println("Average longitude is: " + totalLongitude/count );
			System.out.println("Average latitude is: " + totoalLatitude/count );
			
			System.out.println(largetDeltaHeight.getName());
//			System.out.println(sorted.get(99));
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
