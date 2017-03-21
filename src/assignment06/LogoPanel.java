package assignment06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Objects of this class are extended JPanel objects.
 * Our class adds the functionality of drawing U logo,
 * changing it color, and responding to GUI elements.
 * 
 * @author Yingjie Lian
 * @version 03/20/2017
 * @class CS-1410
 *
 */
public class LogoPanel extends JPanel implements ActionListener{

	// This object is the application object that created
	// this DicePanel object.  This allows us to call 
	// methods in the application that built us.
	private UtahLogo enclosingUtahLogo;
	
	// This array holds the value in order to change the logo's color
	private int[] colorChange;
	
	/**
	 * Builds the logo Panel. The caller must in a reference
	 * to the application that built this panel.
	 * 
	 * @param enclosingUtahLogo a reference to the application we're in.
	 */
	public LogoPanel(UtahLogo enclosingUtahLogo)
	{
		// Keep the reference to the enclosing application so that 
		// we can call it's functions later.
		this.enclosingUtahLogo = enclosingUtahLogo;
		
		// Initialize the array size
		colorChange = new int[2];
		
		// Show a dialog box to remind the user
		JOptionPane.showMessageDialog(null, "Thanks for opening my application! You will see a "
				+ "\nlogo later. Please tell me what letter you just saw "
				+ "\nand enter the letter into the textfield then click "
				+ "\n'click' button.");
		randomize();
		
	}
	
	/**
	 * Overrides the JPanel paint method. This method draws the logo
	 * whenever the GUI system determines that out panel needs to  
	 * be drawn.
	 * 
	 * @param g A graphics object that represents the drawable area
	 */
	public void paint (Graphics g)
	{
		// Make the background be in white color
		g.setColor(Color.white);
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	
    	// Change the color for the U logo
    	for (int i = 0; i < colorChange.length; i++)
    		drawLogo(g, 200, 200, colorChange[i]);
	}
	
	/**
	 * Draw the U logo at x, y.
	 * 
	 * @param g the graphics object for our drawable area
	 * @param x the x coordinate where the logo should be drawn
	 * @param y the y coordinate where the logo should be drawn
	 * @param v the value to change the color
	 */
	public void drawLogo (Graphics g, int x, int y, int v)
	{
		// First fill out a rectangle
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// use swith-case to change the color of logo.
		switch (v)
		{
		case 0:
			g.setColor(Color.RED);
			break;
		case 1:
			g.setColor(Color.RED);
			break;
		case 2:
			g.setColor(Color.GREEN);
			break;
		case 3:
			g.setColor(Color.YELLOW);
			break;
		case 4:
			g.setColor(Color.RED);
			break;
		case 5:
			g.setColor(Color.MAGENTA);
		}
		// First fill out a rectangle
		g.fillRect(x, y, 200, 200);
		
		// White out the shape that not belongs to
		// the logo (like a eraser)
		g.setColor(Color.WHITE);
		g.fillRect(x+75, y+50, 50, 80);
		g.fillRect(x+85, y, 30, 50);
		g.fillRect(x+85, y, 30, 50);
		g.fillRect(x, y+50, 10, 150);
		g.fillRect(x+190, y+50, 10, 150);
		g.fillRect(x, y+190, 200, 10);
		
		// Erase the two little parts at left and right bottom
		// of the Big red Rectangle to make the logo looks perfectly
		// like the U logo.
		for(int i = 0; i < 45; i++)
		{
			for(int j = 0; j <= 25; j++)
			{
				g.fillRect(x + 5 + i, y + 155 + i + j, 5, 5);
				g.fillRect(x + 190 - i, y + 155 + i + j, 5, 5);
			}
		}
		
		
		
	}
	
	// Use number to control the color of the logo. What I thought
	// is the only way we can do for changing color is to use number
	// control it.
	public void randomize()
	{
		for (int i = 0; i < colorChange.length; i++ )
			colorChange[i] = (int)(Math.random()*7);
	}
	
	/**
	 * This method implements the required method for receiving 
	 * action events. (Action events only require one such method.
	 * Some event types require multiple methods.)
	 * 
	 * This method determines the source of the event (GUI, timer,
	 * button, etc.) and updates the state of the dice and GUI 
	 * appropriately.
	 * @param ActionEvent the event that caused this method to be called
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		// If the timer expired, just change the color
		// of the logo
		if (source instanceof Timer)
		{
			randomize();
			repaint();
		}
		
		// If the source of the event was the information
		// button, show user the Basic information of U of U.
		if (enclosingUtahLogo.isInfoButton(source))
		{
			repaint();
			JOptionPane.showMessageDialog(null, "The University of Utah is a public "
					+ "\ncoeducational space-grant research "
					+ "\nuniversity in Salt Lake City, Utah, "
					+ "\nUnited States. As the state's "
					+ "\nflagship university, the university "
					+ "\noffers more than 100 undergraduate "
					+ "\nmajors and more than 92 graduate "
					+ "\ndegree programs. As of Fall 2015, "
					+ "\nthere are 23,909 undergraduate "
					+ "\nstudents and 7,764 graduate students, "
					+ "\nfor an enrollment total of 31,673.");
		}
		
		// If the source of the event was the click
		// button, show user something.
		if (enclosingUtahLogo.isClick(source))
		{
			enclosingUtahLogo.enterU();
		}
			
	}
	
	public Dimension getMinimumSize ()
	{
		return new Dimension(520, 520);
	}
	public Dimension getPreferredSize ()
	{
		return getMinimumSize();
	}
	public Dimension getMaximumSize ()
	{
		return getMinimumSize();
	}
}
