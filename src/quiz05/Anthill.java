package quiz05;

public class Anthill 
{
	private String name;
	private int latitude, startHeight, endHeight, deltaHeight;
	private double longitude, population;


	public Anthill(String name, int latitude, double longitude, double population, 
			int startHeight, int endHeight)
	{
		this.name = name;
		this.longitude = longitude;
		this.population = population;
		this.latitude = latitude;
		this.startHeight = startHeight;
		this.endHeight = endHeight;
		this.deltaHeight = startHeight - endHeight;
	}

	public String getName()
	{
		return name;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public double getPopulation()
	{
		return population;
	}

	public int getLatitude()
	{
		return latitude;
	}

	public int getStartHeight()
	{
		return startHeight;
	}

	public int getEndtHeight()
	{
		return endHeight;
	}

	
	public int getDeltaHeight()
	{
		return deltaHeight;
	}
	
	public double getVolume()
	{
		double volume = Math.PI * Math.pow(deltaHeight, 3) / 6;
		
		return volume;
	}
	public String toString()
	{
		return name + "'s longitude is " + longitude + ", population is " + population + 
				", latitude is " + latitude + ", \n      startHeight is " +
				startHeight + ", endHeight is " + endHeight + ".";
	}
}
