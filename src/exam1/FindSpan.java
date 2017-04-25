package exam1;

public class FindSpan {
	
	public static void main(String[] args)
	{
		double[] some = new double[]{1,2,3,4};
		double spin = 0, high = 0, low = 0, average = 0;
		DataStats data = new DataStats(some[0]);
		
		for (int i = 0;  i < some.length; i++)
		{
			data.addTotal(some[i]);
		}
		
		high = data.getHigh();
		low = data.getLow();
		
		average = data.getAverage();
//		spin = high - low;
		
		
		
		System.out.println(average);
		
	}

}
