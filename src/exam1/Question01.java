package exam1;

public class Question01 {
	
	public static double findSpan(double[] data)
	{
		double min, max;
		max = data[0];
		min = data[0];
		for (int i = 0; i < data.length; i++)
		{
			if(data[i] > max)
				max = data[i];
			if(data[i] < min)
				min = data[i];
		}
		return max - min;
	}
	
	public static void main(String[] args)
	{
		double[] some = new double[]{0, 2.2, 3.2, 4.2, 5.2, -1, 6.2, 2.2, 8.2};
		System.out.println(findSpan(some));
	}

}
