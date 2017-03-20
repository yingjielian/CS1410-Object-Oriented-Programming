package assignment06;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JApplet;
import javax.swing.JOptionPane;


/**
 * This Applet will draw a 'U' and allow you to move the drawing around the Applet.
 * Click the screen and you will get a pop up and the screen will go black.
 * 
 * 
 * @Basil Vetas
 * @February 4, 2013
 */
public class MyFirstApplet extends JApplet implements MouseListener, MouseMotionListener
{
	int rectX, rectY; // these variables are used to draw the 'U'
	boolean iAmAUte; // this boolean is used to change the screen color

	/**
	 * Initializes variables and send the user a message explaining what to do.
	 * This is called once when the program starts.
	 */
	public void init()
	{	
		JOptionPane.showMessageDialog(null, "Have fun moving the 'U' around the screen." 
				+ "\nWhen you're ready, click the mouse for a surprise!");
		
		rectX = 200;
		rectY = 200;
		iAmAUte = false;
		
		this.addMouseListener(this);			
		this.addMouseMotionListener(this);

	}
	
	/**
	 * This will paint a 'U' in the Applet window.
	 * 
	 */
	public void paint(Graphics g)
	{	if(iAmAUte)	// If the boolean value is true, the screen will be painted BLACK instead of WHITE
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.WHITE);

		g.fillRect(0, 0,  this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		g.fillRect(rectX, rectY, 200, 200);		//This creates a red rectangle
			
		if(iAmAUte)	// If the boolean value is true, the screen will be painted BLACK instead of WHITE
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.WHITE);
		
		g.fillRect(rectX+75, rectY+50, 50, 80);
		g.fillRect(rectX+85, rectY, 30, 50);
		g.fillRect(rectX+85, rectY, 30, 50);
		g.fillRect(rectX, rectY+50, 10, 150);
		g.fillRect(rectX+190, rectY+50, 10, 150);
		g.fillRect(rectX, rectY+190, 200, 10);
			
		// These 'for' statements allow me to shape the bottom corners of the 'U' by blacking or 
		// whiting out the edges incrementally. The same code is below for the WHITE background
		
		for(int n = 0; n < 45; n++)	
		{	for(int i = 0; i <= 25; i++)
			{
				g.fillRect(rectX + 5 + n, rectY + 155 + n + i, 5, 5);
				g.fillRect(rectX + 190 - n, rectY + 155 + n + i, 5, 5);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	/**
	 * This creates the pop-up and initiate the boolean so that the screen will go black
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{	iAmAUte = true;
		repaint();	// forces a redraw

		// Print a message to the user
		
		JOptionPane.showMessageDialog(null, "Who am I, sir, a Utah man am I!" 
					+ "\nA Utah man, sir, and will be till I die! " 
					+ "\nKi! Yi!");
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub

		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub

		
	}
	/**
	 * This allows you to move the 'U' around the Applet screen
	 */
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		// allows the user to move the 'U' around
		
		rectX = e.getX();
		rectY = e.getY();
		repaint();		// forces a redraw

		
	}


}