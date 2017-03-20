package assignment06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LogoPanel extends JPanel implements ActionListener{

	private UtahLogo enclosingUtahLogo;
	
	private int[] colorChange;
	
	public LogoPanel(UtahLogo enclosingUtahLogo)
	{
		this.enclosingUtahLogo = enclosingUtahLogo;
		colorChange = new int[2];
		randomize();
	}
	
	public void paint (Graphics g)
	{
		g.setColor(Color.white);
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	
    	for (int i = 0; i < colorChange.length; i++)
    		drawFlag(g, 200, 200, colorChange[i]);
	}
	
	public void drawFlag (Graphics g, int x, int y, int v)
	{
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		g.fillRect(x, y, 200, 200);
		
		g.setColor(Color.WHITE);
		g.fillRect(x+75, y+50, 50, 80);
		g.fillRect(x+85, y, 30, 50);
		g.fillRect(x+85, y, 30, 50);
		g.fillRect(x, y+50, 10, 150);
		g.fillRect(x+190, y+50, 10, 150);
		g.fillRect(x, y+190, 200, 10);
		
		for(int i = 0; i < 45; i++)
		{
			for(int j = 0; j <= 25; j++)
			{
				g.fillRect(x + 5 + i, y + 155 + i + j, 5, 5);
				g.fillRect(x + 190 - i, y + 155 + i + j, 5, 5);
			}
		}
		
		switch (v)
		{
		case 1:
			g.setColor(Color.blue);
			break;
		case 2:
			g.setColor(Color.GREEN);
			break;
		case 3:
			g.setColor(Color.YELLOW);
			break;
		}
		
	}
	
	public void randomize()
	{
		for (int i = 0; i < colorChange.length; i++ )
			colorChange[i] = (int)(Math.random()*3 + 1);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if (source instanceof Timer)
		{
			randomize();
			repaint();
		}
		
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
		
	}
	
	public Dimension getMinimumSize ()
	{
		return new Dimension(660, 660);
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
