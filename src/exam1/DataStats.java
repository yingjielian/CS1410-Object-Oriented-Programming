package exam1;

public class DataStats {
	
	private double high, low, average, total;
	private int count;
	
	public DataStats(double firstData)
	{
		high = firstData;
		low = firstData;
		count = 0;
	}

	public void addDataPoint(double data)
	{
		if(data > high)
			high = data;
		
		if(data < low)
			low = data;
	}
	
	
	public double getHigh()
	{
		return high;
	}
	
	public double getLow()
	{
		return low;
	}
	
	public void addTotal(double data)
	{
		total += data;
		count++;
	}
	
	public double getAverage()
	{
		average = total/count;
		
		return average;
	}
}
