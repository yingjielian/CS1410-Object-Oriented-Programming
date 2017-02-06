package tests;

public class text1 
{
	public static void main(String[] args) 
	{
		int input, count;
		input = 1;
		count = 1;
		boolean isSmallest = false;
		while (! isSmallest)
		{
			input = count;
			while (input != 1)
			{
				if (input % 2 == 1)
				{
					input = input * 3 + 1;
				}
				input = input / 2;
				if (input < 0){
					System.out.println(count);
					System.exit(0);
				}
			}
			count++;
			
		}
	}
}
