package practiceQuiz02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class People 
{

	public static void main (String[] args)
	{
		List<Person> people= new ArrayList<>();
		double total = 0;
		int count = 0;
		double average = 0;
		
		try 
		{
			Scanner s = new Scanner(new File("src/practiceQuiz02/People.txt"));
//			while(s.hasNext())
				people.add(new Person(s.next(), s.nextInt(), s.nextDouble()));
			
			for(Person p : people)
			{
				total += p.getScore();
				count++;
			}
			
			average = total/count;
			
			System.out.println(average);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
