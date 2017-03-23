package life;

/**
 * A grid object represents the grid part of a life simulation.
 * The grid object keeps track of the state of each square
 * (alive, dead), and allows the user to make one step in the
 * life simulation.
 * 
 * Note that this class does not do any drawing or other I/O.
 * It just represents a grid.
 * 
 * @author Peter Jensen
 */
public class Grid
{
	// Instance variables here.
	private int width;
	private int height;
	private boolean[][] grid;
	

	/**
	 * Constructor - creates an empty grid of the
	 * specified dimensions.
	 * 
	 * @param width The width of the new grid
	 * @param height The height of the new grid
	 */
	public Grid (int width, int height)
	{
		this.width = width;
		this.height = height;
		grid = new boolean[height][width];
		
	}

	/**
	 * Returns true if the specified cell in the grid
	 * is alive, false otherwise.  If the coordinates
	 * are illegal, false is returned.
	 * 
	 * @param row  a row number
	 * @param column a column number
	 * @return true iff that cell is alive
	 */
	public boolean isAlive (int row, int column)
	{
		if(row < 0 || row >= height || column >= width || column < 0)
			return false;

		return grid[row][column];
	}

	/**
	 * Sets the state of the specified cell in the
	 * grid.
	 * 
	 * @param row a row number
	 * @param column a column number
	 * @param isAlive true if the grid cell should be alive
	 */
	public void setCellState(int row, int column, boolean isAlive)
	{
		grid[row][column] = isAlive;
	}


	/** 
	 * Returns the width of the grid.
	 * 
	 * @return the width of this grid
	 */
	public int getWidth ()
	{
		return width;
	}

	/** 
	 * Returns the height of the grid.
	 * 
	 * @return the height of this grid
	 */
	public int getHeight ()
	{
		return height;
	}

	/**
	 * Clears the grid, all cells marked as
	 * dead.
	 */
	public void clear ()
	{
		grid = new boolean[height][width];
	}

	private int numberOfLivingNeighbors(int row, int column){

		int count = 0;

		if (isAlive(row-1, column-1))
			count++;
		if (isAlive(row-1, column))
			count++;
		if (isAlive(row-1, column+1))
			count++;

		if (isAlive(row, column-1))
			count++;
		if (isAlive(row, column+1))
			count++;

		if (isAlive(row+1, column-1))
			count++;
		if (isAlive(row+1, column))
			count++;
		if (isAlive(row+1, column+1))
			count++;

		return count;
	}

	private boolean cellFate(int row, int column) {

		switch(numberOfLivingNeighbors(row, column))
		{
		case 2:
			return isAlive(row, column);
		case 3:
			return true;
		default:
			return false;
		}
	}

	/**
	 * Performs one 'life' step using the standard rules
	 * of life:<p>
	 * 
	 * Any live cell with fewer than two neighbors dies, as if by loneliness. <br> 
	 * Any live cell with more than three neighbors dies, as if by overcrowding. <br>
	 * Any live cell with two or three neighbors lives, unchanged, to the next generation. <br>
	 * Any dead cell with exactly three neighbors comes to life.<p> 
	 * 
	 * Care must be taken to make sure the next generation is kept separate from the 
	 * current generation.
	 */
	public void stepOneGeneration ()
	{

		boolean[][] nextGeneration = new boolean[height][width];

		for(int row = 0; row < height; row++)
		{
			for(int col = 0; col <width; col++)
			{
				nextGeneration[row][col] = cellFate(row, col);
			}
		}

		grid = nextGeneration;
	}

}
