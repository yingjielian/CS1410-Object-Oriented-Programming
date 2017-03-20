package assignment06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import gui.ApplicationMain;

public class UtahLogo implements Runnable
{
	private JTextField flagBackground;
	private JButton infoButton;
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new UtahLogo());
	}
	
	
	public void run() 
	{
		JFrame frame = new JFrame("Utah Logo");
		frame.setVisible(true);
		frame.setSize(660, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		
		flagBackground = new JTextField("text");
		flagBackground.setColumns(20);
		flagBackground.setEditable(false);
		
		infoButton = new JButton("Information");
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		LogoPanel centerPanel = new LogoPanel(this);
		JPanel bottomPanel = new JPanel();
		
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new FlowLayout());
		
		infoButton.addActionListener(centerPanel);
		
		topPanel.add(new JLabel("University of Utah"));
		
		bottomPanel.add(infoButton);
		
		content.add(topPanel, BorderLayout.NORTH);
		content.add(centerPanel, BorderLayout.CENTER);
		content.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setContentPane(content);
		
		frame.pack();
		frame.setVisible(true);
		
		Timer t = new Timer(1000, centerPanel);
		t.start();
		
	}
	
	public boolean isInfoButton (Object o)
	{
		return o == infoButton;
	}

}
