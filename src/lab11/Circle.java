package lab11;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Circle objects represent a circle shape
 * drawn to the screen at a particular position
 * with some size and color.
 *
 * @author Peter Jensen
 * @version Spring 2017
 */
public class Circle extends Shape
{
    // Instance variables.

//    private int x, y;
//    private Color color;
    private int radius;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this circle object.
     *
     * @param x
     *         the x coordinate of this object's position
     *
     * @param y
     *         the x coordinate of this object's position
     *
     * @param diameter
     *              the diameter of this circle
     *
     * @param color
     *             the color of this circle
     */
    public Circle (int x, int y, int diameter, Color color)
    {
    	
    	// Call the superclass constructor.  This must be the first statement
    	//   in this constructor.
    	
    	super (x, y, color);
    	
    	// Save the size.
    	
    	this.radius = diameter / 2;
    	
//    	this.x = x;
//    	this.y = y;
//    	this.color = color;
    	this.radius = diameter / 2;
    	move(this.x, this.y);
    }

    /**
     * Changes the position of this shape by
     * the specified amount.  Note that this does
     * not set the position absolutely, the deltas
     * specify how far to move the shape from its
     * current position.
     *
     * @param deltaX
     *              how far to move the shape horizontally
     *
     * @param deltaY
     *              how far to move the shape vertically
     */
//    public void move (int deltaX, int deltaY)
//    {
//    	x = x + deltaX;
//    	y = y + deltaY;
//    }

    /**
     * Draws the circle at it's current position and color
     * to the specified graphics object.
     *
     * @param g
     *         the graphics object (where to draw to)
     */
    public void draw (Graphics g)
    {
    	g.setColor (color);
    	g.fillOval (x, y, radius * 2, radius * 2);
    }  
    
    /**
     * Returns true if the coordinates are within the circle.
     *
     * @param targetX
     *               an x coordinate
     *
     * @param targetY
     *               a y coordinate
     *
     * @return
     *        true if the coordinates are within the shape
     */
    public boolean isInside (int targetX, int targetY)
    {
    	int cx = x + radius;  // Calculate the center point
    	int cy = y + radius;
    	
    	int deltaX = cx - targetX;  // Calculate the deltas to the click
    	int deltaY = cy - targetY;
    	
    	// Make sure the distance from the click to the center is less
    	//   than the radius.  (Notice how I avoid a sqaure root.)
    	
    	return (deltaX * deltaX + deltaY * deltaY) <= radius * radius;
    }
}
