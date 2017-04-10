package lab08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <p>
 * This application is a simulation of a simple hand-held
 * calculator.  GUI components are used for input and
 * output.  The user can click on the buttons to enter
 * numbers and select computations, and the results are
 * displayed in the text area at the top.
 * </p>
 * 
 * @author *** Your name here ***
 * @version Spring 2017
 */
public class CalculatorApplication implements Runnable
{
	static public void main (String[] args)
	{
		// Build an object for this class.  
		//   We're in a static main method, there is no 'this'.
		//   We need a runnable object.  Since this
		//   class implements the Runnable interface,
		//   and since this class has a run method, we
		//   can make an object from this class and use
		//   it as a Runnable object.

		CalculatorApplication app = new CalculatorApplication ();

		// Use this helper method to ask the GUI thread to 'run' our
		//   object.  The GUI thread will execute our run method (later).

		SwingUtilities.invokeLater(app);

		// Note:  If you wanted two copies of the application, you could
		//   create and run two CalculatorApplication objects.  (They
		//   should be different objects, don't just run the same one twice.)
		//   Two windows would appear.  Cool.
	}

	/**
	 * <p>This method represents our official starting point of
	 * the GUI code for the application.  It must be executed
	 * by the GUI thread of execution.  (Remember, we now have
	 * multicore processors, and a program can be executing in
	 * two places at once.  Each thread represents an individual
	 * (and separate) execution path.   GUI code must run in
	 * the GUI thread, so this method must be executed by the
	 * GUI thread.  See 'main' above to see how to make this happen.
	 * </p>
	 */
	public void run ()
	{
		// Create the window.
		JFrame window = new JFrame ("Nifty Calculator");

		// This tells the JFrame object to terminate the application when the user closes the window:
		window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// Make the window unresizeable, visible.
		window.setSize (600, 400); // Yingjie Customized
		window.setResizable (false);
		window.setLocationRelativeTo(null); // Centers the window on the screen
		window.setVisible (true);

		// Create a content panel for the window. We will add our
		// GUI controls to this container. Set the layout to use
		// BorderLayout.
		JPanel content = new JPanel();
		window.setContentPane(content);
		content.setLayout (new BorderLayout());


		// Create, customize, and add the calculator components.
		// First, create a number display and add it to the north in
		//   the window.
		JTextField numberDisplay = new JTextField("0", 15);
		numberDisplay.setForeground(Color.BLACK);
		numberDisplay.setBackground(Color.cyan);
		numberDisplay.setFont(new Font ("Courier", Font.BOLD, 24));
		numberDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		numberDisplay.setEditable(false);

		content.add (numberDisplay, BorderLayout.NORTH);

		// Create an inner panel to hold the number buttons.  Set it
		//   to use GridLayout.  Add it to the south side of the
		//   main window.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout (new GridLayout (8, 2));
		window.add (buttonPanel, BorderLayout.SOUTH);


		// Create the buttons, add them to the inner panel.
		
		JButton one = new JButton ("1");
        buttonPanel.add (one);
        JButton two = new JButton ("2");
        buttonPanel.add (two);
        JButton three = new JButton ("3");
        buttonPanel.add (three);
        JButton four = new JButton ("4");
        buttonPanel.add (four);
        JButton five = new JButton ("5");
        buttonPanel.add (five);
        JButton six = new JButton ("6");
        buttonPanel.add (six);
        JButton seven = new JButton ("7");
        buttonPanel.add (seven);
        JButton eight = new JButton ("8");
        buttonPanel.add (eight);
        JButton nine = new JButton ("9");
        buttonPanel.add (nine);
        JButton zero = new JButton ("0");
        buttonPanel.add (zero);
        JButton equal = new JButton ("=");
        buttonPanel.add (equal);
        JButton add = new JButton ("+");
        buttonPanel.add (add);
        JButton substract = new JButton ("-");
        buttonPanel.add (substract);
        JButton divide = new JButton ("/");
        buttonPanel.add (divide);
        JButton multiply = new JButton ("x");
        buttonPanel.add (multiply);
        JButton clear = new JButton ("C");
        buttonPanel.add (clear);


		// Create an object to listen to button events.
		//   Have our 'listening' object listen to events from every 
		//   button (by adding our object to each button as a listener ).
        CalculatorListener calc = new CalculatorListener (numberDisplay);
        one.addActionListener (calc);
        two.addActionListener (calc);
        three.addActionListener (calc);
        four.addActionListener (calc);
        five.addActionListener (calc);
        six.addActionListener (calc);
        seven.addActionListener (calc);
        eight.addActionListener (calc);
        nine.addActionListener (calc);
        zero.addActionListener (calc);
        add.addActionListener (calc);
        substract.addActionListener (calc);
        divide.addActionListener (calc);
        multiply.addActionListener (calc);
        equal.addActionListener (calc);
        clear.addActionListener (calc);
        

		// Force the window to compute its own size.  (Pack it.)
		window.pack();

		// Make the window unresizeable, visible.


		// Run method terminates, the window remains visible.
		//   The GUI thread event loop will call our listeners
		//   (assuming we added them correctly) whenever
		//   the user interacts with the GUI buttons.
	}
}
