package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * This application builds a GUI that allows
 * the user to roll a bunch of dice.  It doesn't
 * have any other utility, it is just a GUI
 * example for the class.
 * 
 * @author Peter Jensen
 * @version March 8, 2017
 */
public class ApplicationMain implements Runnable
{
    public static void main (String[] args)
    {
        // This function in SwingUtilities takes a Runnable
        //   object as a parameter.  It instructs the GUI
        //   thread to execute the 'run' method in the object.
        //   So, we create an object from this class, send
        //   it in, and sometime later the GUI thread will
        //   execute our run method on our object.
        
    	SwingUtilities.invokeLater(new ApplicationMain());
    	
    	// Note:  The method returns quickly (in the main thread),
    	//   and it is likely that the run method has not yet
    	//   started execution in the GUI thread.
    }
    
    /* The above method is static.  It's just part of the
     * class.  The variables and methods below are not static.
     * They will be part of any ApplicationMain object that
     * is built (using new, see above).
     */
    
    // Instance fields (object variables)
    
    private JTextField avgTextField;
    private JButton    rollButton;
	private JButton    resetButton;
	
    // Instance methods
    
	/**
	 * Builds the GUI for this application.  This method
	 * should only be called from the GUI thread.  (Our
	 * main method takes care of this.)
	 */
    public void run ()
    {
    	// Build the GUI
    	
    	JFrame frame = new JFrame("Dice");  // The top-level window.
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        // Build some GUI objects, customize them a bit.
    	//   (I've reordered this code because I needed these
    	//    objects to exist -before- I created my panel.)
        
        avgTextField = new JTextField("text");
        avgTextField.setColumns(20);        
        avgTextField.setEditable(false);
        
        rollButton = new JButton("Roll");
        resetButton = new JButton("Reset");
        
        // Build 'panels' that will contain other GUI objects.
    	// Set their layout (using a layout object), the
    	//   layout object will arrange each panel for us,
    	//   we just have to add new GUI objects to each panel.
    	
    	JPanel content = new JPanel();  // The container for the window.
    	content.setLayout(new BorderLayout());
    	
    	JPanel northPanel = new JPanel();  // Sub-containers
    	DicePanel centerPanel = new DicePanel(this);  // Our class, our panel, we draw on it.
    	JPanel southPanel = new JPanel();
    	
    	northPanel.setLayout(new FlowLayout());
    	southPanel.setLayout(new FlowLayout());
    	
    	// Listen to events.
    	
    	rollButton.addActionListener(centerPanel);
    	resetButton.addActionListener(centerPanel);
    	
    	// Add the GUI objects to the panels (nested)
    	//   to build the GUI.
    	
        northPanel.add(new JLabel("Average: "));
        northPanel.add(avgTextField);
        
    	southPanel.add(rollButton);
    	southPanel.add(resetButton);
    	
    	content.add(northPanel,  BorderLayout.NORTH);
    	content.add(centerPanel, BorderLayout.CENTER);
    	content.add(southPanel,  BorderLayout.SOUTH);
    	
    	frame.setContentPane(content);  // The top-level panel is the content area of the window.
    	
    	frame.pack();  // Calculates the frame's natural size
    	frame.setVisible(true);  // Display it.
    	
    	// Build a new Timer that triggers every 5000 milliseconds (5 sec)
    	//   and have it send ActionEvents to our panel.  Start it.
    	
    	Timer t = new Timer(5000, centerPanel);
    	t.start();
    }
    
    /**
     * Returns true if the passed object is our
     * GUI object for rolling the dice.
     * 
     * @param o any object
     * @return true iff the object is our GUI roll button
     */
    public boolean isRollButton (Object o)
    {
        // Just compare references.  If both variables
        //   refer to the same object, well, they're the same!
        
        return o == rollButton;
    }
    
    /**
     * Returns true if the passed object is our
     * GUI object for resetting the average.
     * 
     * @param o any object
     * @return true iff the object is our GUI reset button
     */
    public boolean isResetButton (Object o)
    {
        // Just compare references.  If both variables
        //   refer to the same object, well, they're the same!
        
        return o == resetButton;
    }
    
    /**
     * Sets the text in the GUI avg text field.
     * 
     * @param s any string
     */
    public void setAverageText (String s)
    {
        avgTextField.setText(s);
    }
}
