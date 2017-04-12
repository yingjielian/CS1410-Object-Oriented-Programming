package practiceQuiz;

public class Person {
	
	private String name;
	private int age;
	private double score;
	
	public Person(String n, int a, double s)
	{
		name = n;
		age = a;
		score = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}

	public double getScore()
	{
		return score;
		
	}
	
	public String toString()
	{
		return name + " " + age + " " + score;
	}
}
