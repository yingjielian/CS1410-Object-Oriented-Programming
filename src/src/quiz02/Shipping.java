package quiz02;

import java.util.Scanner;
/**
 * 
 * @author Yingjie Lian
 * @version 02/14/2017
 * @class CS-1410
 *
 */

public class Shipping 
{
	public static void main(String[] args) 
	{
		String size = "";
		double weight = 0.0, money = 0.0;
		System.out.println("Shipping Cost Computer");
		Scanner s = new Scanner(System.in);
		System.out.println("How many packages would you like to ship?");
		int  n = s.nextInt();
		
		for (int i = 1; i <= n; i++)
		{
			System.out.println("Package size?");
			size = s.next();
			System.out.println("Package weight?");
			weight = s.nextDouble();
			money = money + sizeAndWeight(size, weight);
		}
		
		System.out.println("Your shipping costs will be $" + money);
		
	}

	/**
	 * This method is going to return the cost of the packages.
	 * @param size 
	 * @param weight
	 * @return
	 */
	public static double sizeAndWeight (String size, double weight)
	{
		double cost = 0.0;
		double result = 0.0;
		if (size.equals("huge"))
		{
			cost = 10.0 + 0.5 * weight;
			result += cost;
		}
		
		else if (size.equals("normal"))
		{
			if (weight < 8)
			{
				cost = 3.75;
			}
			else
			{
				cost = weight * 0.75;
			}
			result +=cost;
		}
		return result;
	}
}
