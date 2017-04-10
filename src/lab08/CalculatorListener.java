package lab08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Objects of this class control the GUI calculator.  The
 * object(s) built from this class keep track of the numbers
 * and operations, and they respond to button presses from
 * the calculator buttons.
 * 
 * @author *** Your name here *** 
 * @version Spring 2017
 */
public class CalculatorListener implements ActionListener
{
    // Instance variables
    
    private JTextField display;     // A GUI object that displays text.
    
    private char lastOperation;     // The last operation key pressed.
    private double lastNumber;      // The left-hand side of any operation.
    private boolean numberStarted;  // True if the user has started entering a number.
    
    /**
     * Constructor - initializes the state of the calculator.
     * This object needs access to the GUI element that
     * displays the result.  When this object is built, the
     * user must supply a JTextField, and the results will
     * be displayed there.
     * 
     * @param display the calculator's numeric display GUI component
     */
    public CalculatorListener (JTextField display)
    {
        // Store the JTextField in an object variable so we can
        //   access it later.  (Copy the parameter into 'this' object.)
        
        this.display = display;
        
        // Clear the calculator.
        
//        lastOperation = '+';     // Default is addition.  
//        lastNumber = 1.0;        // Default left-hand side
//        numberStarted = false;   // The user has not started typing.
        display.setText ("0");   // Initial results.
    }
    
    /**
     * Adds a digit to the display (if the display
     * is not full.)  If a number was not started, this
     * starts a number.
     * 
     * @param d   a digit character
     */
    public void addDigit (char d)
    {
        // Retrieve the characters from the GUI text field.
        
        String text = display.getText();
        
        // If a number has not been started, start one.
        //   (clear the display, and mark the number started if not 0.)
        
        if (!numberStarted)
        {
            text = ""; 
            numberStarted = d != '0';
        }
        
        // Don't allow more than 15 characters in the text string.
        
        if (text.length() >= 15)
            return;
            
        // Combine the pressed key with the text, then put it back
        //  into the GUI text field so that it will show up on screen.
        
        text += d;
        display.setText (text);
    }
    
    
    /**
     * ActionListener - listens to the button actions.
     * The appropriate action is taken (for the calculator)
     * based on which button is pressed.
     * 
     * @param e  an action event (created by a JButton)
     */
    public void actionPerformed (ActionEvent e)
    {
        // Get the name of the button to determine the
        //   operation.  This is usually a bad idea,
        //   it is better to get the source of the event
        //   and compare object references.  Lab is too
        //   short for that technique.  ;)
        
        Object sourceOfEvent = e.getSource();           // Get the source object of the event.
        JButton sourceButton = (JButton) sourceOfEvent; // Change our view of the reference
        String buttonLabel = sourceButton.getText();    // Get the button label.
        char operation = buttonLabel.charAt(0);         // Get the first character of the label.

        // Do the appropriate operation for this button.

        switch (operation)
        {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                addDigit (operation);
                return;
            case 'C':
                lastOperation = 'C';
                lastNumber = 0.0;
                numberStarted = false;        
                display.setText ("0");
                return;
            case '+':
            case '-':
            case 'x':
            case '/':
            case '=':
                // An operation button has been pressed in this case.
                // Imagine the user keying in 4 3 x 1 0 - 
                // So, when minus is typed, the display shows 10.
                // When minus is typed, the multiply needs to be evaluated.
                
                // Do the PREVIOUS operation.  First, extract the displayed number.
                
                double currentNumber = Double.parseDouble(display.getText());
                
                // Next, do the operation.
                
                if (lastOperation == '+')
                    currentNumber = lastNumber + currentNumber;
                else if (lastOperation == '-')
                    currentNumber = lastNumber - currentNumber;
                else if (lastOperation == 'x')
                    currentNumber = lastNumber * currentNumber;
                else if (lastOperation == '/')
                    currentNumber = lastNumber / currentNumber;
                    
                // Clear the number entry flag.

                numberStarted = false;        
                
                // Display the result (but limit it to 15 characters).
                
                String result = "" + currentNumber;
                if (result.length() > 15)
                    result = result.substring(0,14);
                
                display.setText (result);
                
                // Save the operation and result as the last operation and result.
                
                lastNumber = currentNumber;
                lastOperation = operation;
        }
    }    
}
