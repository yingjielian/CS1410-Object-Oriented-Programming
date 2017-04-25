package practiceQuiz02;

public class Person 
{

	private String name;
	private int age;
	private double score;
	
	public Person(String name, int age, double score)
	{
		this.name = name;
		this.age = age;
		this.score = score;
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
		return name + age + score;
	}
}
