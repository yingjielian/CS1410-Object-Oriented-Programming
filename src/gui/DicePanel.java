package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Objects of this class are extended JPanel objects.
 * Our class adds the functionality of storing die values,
 * randomizing them, and responding to and updating GUI elements.
 * 
 * @author pajensen
 *
 */
public class DicePanel extends JPanel implements ActionListener
{
    // This array holds the value of each die.
    
	private int[] dieValue;
	
	// This object is the application object that created
	//   this DicePanel object.  This allows us to call 
	//   methods in the application that built us.
	
	private ApplicationMain enclosingApplication;

	// Variables for keeping track of the average dice roll.
	
    private int rollCount;
    private int rollSum;

	/**
	 * Builds the dice panel.  The caller must send in a reference
	 * to the application that built this panel.
	 * 
	 * @param enclosingApplication a reference to the application we're in.
	 */
	public DicePanel(ApplicationMain enclosingApplication)
	{
	    // Keep the reference to the enclosing application so that
	    //   we can call it's functions later.
	    
	    this.enclosingApplication = enclosingApplication;
	    
        // Reset the average.  (This needs to happen before
	    //   the dice are rolled, I don't want to reset them
	    //   -after- I've started using these variables unless the
	    //   reset button is pressed.)
        
        rollCount = 0;
        rollSum = 0;
        
        // Create the array of die values, roll the dice. 
	    
		dieValue = new int[2];
		randomize();
	}
	
	/**
	 * Overrides the JPanel paint method.  This method
	 * draws the dice whenever the GUI system determines
	 * that our panel needs to be drawn.
	 * 
	 * @param g A graphics object that represents the drawable area
	 */
    public void paint (Graphics g)
    {
        // Clear the background of our drawable area.
    	
    	g.setColor(Color.GRAY);
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	
    	// Draw the dice, spread them out 110 pixels each.
    	
    	for (int i = 0; i < dieValue.length; i++)
    	    drawDie(g, 10+110*i, 10, dieValue[i]);
    }
    
    /**
     * Draws one die to the screen at x, y.
     * 
     * @param g the graphics object for our drawable area
     * @param x the x coordinate where this die should be drawn
     * @param y the y coordinate where this die should be drawn
     * @param v the value to draw on this die.
     */
    public void drawDie (Graphics g, int x, int y, int v)
    {
        // Clear/draw the die background.
        
    	g.setColor(Color.WHITE);
    	g.fillRoundRect(x, y, 100, 100, 20, 20);
    	
    	// Outline it in black (because it will look nice)
    	
    	g.setColor(Color.BLACK);
    	g.drawRoundRect(x, y, 100, 100, 20, 20);
    	
    	// Draw the pips for this value.
    	
    	switch (v)
    	{
    	case 5:
    		g.fillOval(x + 80 - 5, y + 20 - 5, 10, 10);  // Right upper 
    		g.fillOval(x + 20 - 5, y + 80 - 5, 10, 10);  // Left bottom		
    	case 3:
    		g.fillOval(x + 80 - 5, y + 80 - 5, 10, 10);  // Right bottom
    		g.fillOval(x + 20 - 5, y + 20 - 5, 10, 10);  // Left upper        			
    	case 1:
    		g.fillOval(x + 50 - 5, y + 50 - 5, 10, 10);  // Center
        	break;
    	case 6:
    		g.fillOval(x + 20 - 5, y + 50 - 5, 10, 10);  // Left center
    		g.fillOval(x + 80 - 5, y + 50 - 5, 10, 10);  // Right center
        case 4:
    		g.fillOval(x + 80 - 5, y + 20 - 5, 10, 10);  // Right upper 
    		g.fillOval(x + 20 - 5, y + 80 - 5, 10, 10);  // Left bottom		
    	case 2:
    		g.fillOval(x + 80 - 5, y + 80 - 5, 10, 10);  // Right bottom
    		g.fillOval(x + 20 - 5, y + 20 - 5, 10, 10);  // Left upper        		
    		break;
    	}
    }
    
    /**
     * This method shuffles the die values, effectively
     * rolling the dice.
     */
    public void randomize ()
    {
        // Roll the dice.
        
    	for (int i = 0; i < dieValue.length; i++)
    	    dieValue[i] = (int)(Math.random()*6+1);
    	
    	// Update the average.
    	
    	rollCount++;
    	for (int i = 0; i < dieValue.length; i++)
            rollSum += dieValue[i];
    	
    	// Update the GUI with the average.
    	
    	enclosingApplication.setAverageText("" + (rollSum/(double)rollCount));
    }

    /**
     * This method implements the required method for
     * receiving action events.  (Action events only
     * require one such method.  Some event types require
     * multiple methods.)
     * 
     * This method determines the source of the event (GUI,
     * timer, etc.) and updates the state of the dice and GUI
     * appropriately.)
     * 
     * @param ActionEvent the event that caused this method to be called
     */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		
		// If the timer expired, just roll the dice.
		
        if (source instanceof Timer)
        {
            randomize();
            repaint();
        }
        
        // If the source of the event was the roll button, roll the dice.
        
		if (enclosingApplication.isRollButton(source))
		{		
   	        randomize();
			repaint();
		}
		
		// If the source of the event was the reset button, reset the average.
		
        if (enclosingApplication.isResetButton(source))
        {       
            rollCount = 0;
            rollSum = 0;
            
            enclosingApplication.setAverageText("0");
        }
	}
	
	
	/* These functions override functions in JPanel.  The
	 * GUI system uses them to figure out how much space
	 * our panel needs.  We choose the values that are
	 * returned to make sure we have enough space to draw on.
	 */
	
	public Dimension getMinimumSize ()
	{
		return new Dimension(20+110*dieValue.length, 120);
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
