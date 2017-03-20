package assignment06;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JOptionPane;


public class Smiley extends JApplet
{
	/**
	 * Called once when the JApplet program starts
	 */
	public void init() 
	{
		int startX, startY;
		double size;
		
		//startX = Integer.parseInt(JOptionPane.showInputDialog(this, "X position: "));
		//startY = Integer.parseInt(JOptionPane.showInputDialog(this, "Y position: "));
		//size = Double.parseDouble(JOptionPane.showInputDialog(this, "Scale Factor: "));
	}
	
	/**
	 * called every time the JApplet redraws
	 */
	public void paint(Graphics g)
	{	for(int x=0; x < 2000; x+= 100)
		{
			for(int y=0; y<2000; y+= 100)
			{
					drawSmiley(g, x, y, 1);
			}
		}
		
	
	}
	
	public void drawSmiley(Graphics g, int x, int y, double percentage)
	{
		
		// Clear the screen
		// g.setColor(Color.WHITE);
		// g.fillRect(x + (int)(0*percentage), y + (int)(0*percentage), this.getWidth(), this.getHeight());
		
		//Face
		g.setColor( new Color(0.9f, 0.8f, 0.3f)); 	//new Color(R,G,B) values takes floats
		g.fillOval(x + (int)(0*percentage), y + (int)(0*percentage), (int)(100*percentage), (int)(100*percentage));
		
		//Eyes
		g.setColor(Color.WHITE);
		g.fillRect(x + (int)(23*percentage), y + (int)(23*percentage), (int)(7*percentage), (int)(7*percentage));
		g.fillRect(x + (int)(68*percentage), y + (int)(23*percentage), (int)(7*percentage), (int)(7*percentage));
		
		//Pupils
		g.setColor(Color.BLUE);
		g.fillRect(x + (int)(28*percentage), y + (int)(28*percentage), (int)(2*percentage), (int)(2*percentage));
		g.fillRect(x + (int)(73*percentage), y + (int)(28*percentage), (int)(2*percentage), (int)(2*percentage));
		
		
		//Nose
		g.setColor(Color.BLACK);
		g.drawOval(x + (int)(45*percentage), y + (int)(45*percentage), (int)(10*percentage), (int)(10*percentage));
		
		//Mouth
		g.setColor(Color.RED);
		g.drawArc(x + (int)(-10*percentage), y + (int)(-45*percentage), (int)(120*percentage), (int)(120*percentage), 240, 60);
	}

	
}
