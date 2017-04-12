package practiceQuiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class People {
	private static Person person;
	private static ArrayList<Person> people;
	
	public static void main(String[] args)
	{
		List<Person> people = new ArrayList<>();
		
		try {
			Scanner s = new Scanner(new File("src/practiceQuiz/People.txt"));
			while (s.hasNext())
				people.add(new Person(s.next(), s.nextInt(), s.nextDouble()));
			System.out.println(people.size());
			
			double total = 0.0;
			Person oldest = people.get(0);
			
			for(Person p : people)
			{
				// Used to find the average score
				total += p.getScore();
				
				if (oldest.getAge() < p.getAge())
				{
					oldest = p;
				}
				
			}
			
			System.out.println(total/2000);
			System.out.println("Name: " + oldest.getName() + " Age: " + oldest.getAge());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
