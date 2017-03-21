package assignment06;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import gui.ApplicationMain;
/**
 * This application builds a GUI that show the user a 
 * color-changed logo of University of Utah. The logo 
 * will change to 4 different colors, but Red will stay
 * longer because Red is Utah Theme color. Also, when user
 * press the button and press U button it will show user 
 * a dialog box.
 * 
 * @author Yingjie Lian
 * @version 03/20/2017
 * @class CS-1410
 *
 */
public class UtahLogo implements Runnable
{
	// Instance fields (object variables)
	private JTextField flagBackground,name;
	private JLabel enterName;
	private JButton infoButton, click;

	public static void main(String args[])
	{
		// 
		SwingUtilities.invokeLater(new UtahLogo());
	}
	
	// Instance methods
	/**
	 * Builds the GUI for this application. This method sould
	 * only be called from the FUI thread. (Our main method 
	 * takes care of this.)
	 */
	public void run() 
	{
		// Build the GUI
		JFrame frame = new JFrame("Utah Logo"); // Set a name at the top-level window.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Make sure when user x out the
		frame.setBackground(Color.WHITE);
		
		// Build some GUI objects
		flagBackground = new JTextField("text");
		flagBackground.setColumns(20);
		flagBackground.setEditable(false);
		
		enterName = new JLabel("Enter A Letter: ");
		name = new JTextField();
		name.setColumns(5);
		// Creats a button
		infoButton = new JButton("Information");
		click = new JButton("click");
		
		// Build all the panels which contain other GUI
		// objects and set their layout, use these layouts
		// to arrange all the panel for us.
		
		JPanel content = new JPanel(); // The container for the window
		content.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();// Sub-containers
		LogoPanel centerPanel = new LogoPanel(this); // Class we created
		JPanel bottomPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		
		
		topPanel.setLayout(new FlowLayout()); // Set layout vertically
		bottomPanel.setLayout(new FlowLayout());
		eastPanel.setLayout(new FlowLayout());
		
		
		// Listen to events
		infoButton.addActionListener(centerPanel);
		click.addActionListener(centerPanel);

		// Add the GUI objects to the panels
		topPanel.add(new JLabel("University of Utah"));
		eastPanel.add(enterName);
		
		// add button onto the panel
		bottomPanel.add(infoButton);
		eastPanel.add(name);
		eastPanel.add(click);
		
		content.add(topPanel, BorderLayout.NORTH);
		content.add(centerPanel, BorderLayout.CENTER);
		content.add(bottomPanel, BorderLayout.SOUTH);
		content.add(eastPanel, BorderLayout.EAST);
		
		frame.setContentPane(content); // The top-level panel is the content area of the window.
		
		frame.pack();// Calculates the frame's natural size
		frame.setVisible(true); // Display it.
		
		// Build a new Timer that triggers every 500 milliseconds (0.5 s)
		// and let it send ActionEvents to our Panel. Start it.
		Timer t = new Timer(500, centerPanel);
		t.start(); // start the timer when application was opened
		
	}
	
	/**
	 * Return true if the passed object is our GUI 
	 * object for U logo.
	 * 
	 * @param o any object
	 * @return true if the object is our GUI information button
	 */
	public boolean isInfoButton (Object o)
	{
		return o == infoButton;
	}

	/**
	 * Return true if the passed object is our GUI 
	 * object for U logo.
	 * 
	 * @param o any object
	 * @return true if the object is our GUI click button
	 */
	public boolean isClick (Object o)
	{
		return o == click;
	}
	
	/**
	 * Check if the user input equals to "u". If yes, show them a dialog box, otherwise
	 * not.
	 */
	public void enterU ()
	{
		String s = "u";
		if(s.equals(name.getText().toLowerCase()))
				JOptionPane.showMessageDialog(null, "Good job! Go Utes!");
		
	}
	
}
