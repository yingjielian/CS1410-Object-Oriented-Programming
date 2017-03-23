package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Objects of this class represent both a simulation and the
 * GUI of the simulation.  (I know, this kind of violates separation
 * of concerns, but for this application the display is entangled
 * with the simulation.  It makes sense to keep it simpler.)
 * 
 * Objects of 'this' class are JPanels, and are the panel where
 * the simulation is drawn.  A Timer is used to trigger simulation
 * steps.  Everything in thiss class should only be executed in 
 * the GUI thread.
 * 
 * @author Peter Jensen
 * @version Spring 2017
 */
public class LifeSimulation extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
    // Constants - I only use them in this class, so I made them private.
    //   Also, I don't want them to accidentally change, so I declared them final.
    
    private static final int gridWidth = 40;
    private static final int gridHeight = 30;
    private static final int animationSpeed = 200;  // Milliseconds between updates.  Smaller = faster
    private static final int cellSize = 15; 
    
    private static final long serialVersionUID = 0;  // This just gets rid of an annoying warning.
    
    // Instance variables.
    
    private Grid grid;             // For keeping the state of the cells
    private Timer animationTimer;  // For triggering action events
    
    private JButton clearButton, stepButton, animateOrStopButton;
    
    private int gridX, gridY;  // The location of the upper-left corner of the grid,
                               //   determined when the grid is painted.
    private boolean lastLivingOrDeadUserChange;    
    
    /**
     * Constructor - creates the GUI for the simulation and
     * sets up simulation variables for both running and
     * listening to user events.
     */
    public LifeSimulation ()
    {
        // Before creating the GUI, set up storage for the
        //   grid using our helper class.
        
        this.grid = new Grid(gridWidth, gridHeight);
        
        // Next, create the timer, but don't start it yet.  
        //   When the timer is stopped, the simuation is not
        //   self animating.  When the timer runs, the simulation
        //   runs.
        
        animationTimer = new Timer(animationSpeed, this);
        
        // Create a window.
        
        JFrame frame = new JFrame("Cellular Life Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make a content panel, set border layout.
        
        Container content = new JPanel();  
        content.setLayout(new BorderLayout());
        
        // The object being created, this, is a JPanel.
        //   (See the class header.)  For clarity, I'll 
        //   use the 'this' keyword, but you wouldn't have to.
        
        // Set the size of the panel that draws the grid.
        
        this.setMinimumSize(new Dimension(grid.getWidth() * cellSize + 10, grid.getHeight() * cellSize + 10));
        this.setPreferredSize(this.getMinimumSize());
        
        // Mouse events over the grid should be reported to the grid.
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        // Create the buttons, add them to a panel, and listen to them.
        
        clearButton = new JButton ("Clear the grid");
        stepButton = new JButton ("Step one generation");
        animateOrStopButton = new JButton ("Animate");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        buttonPanel.add(clearButton);
        buttonPanel.add(stepButton);
        buttonPanel.add(animateOrStopButton);
        
        clearButton.addActionListener(this);
        stepButton.addActionListener(this);
        animateOrStopButton.addActionListener(this);
        
        // Add the subpanels to each other, then set the
        //  content panel in the application window.
        
        content.add(this, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);
        frame.setContentPane(content);
        
        // Done building the GUI - show the window.
        
        frame.pack();
        frame.setLocationRelativeTo(null);  // Centers the window.
        frame.setVisible(true);        
    }
    
    
    /**
     * Draws the grid.
     * 
     * @param g
     *         this panel's graphics object
     */
    public void paint (Graphics g)
    {
        // Compute the upper-left corner of the grid.  Center it in the
        //  available space.  (If the user changes the window size we
        //  want the blank space appropriately distributed.)
        
        int width = this.getWidth();
        int height = this.getHeight();
        int rows = grid.getHeight();
        int columns = grid.getWidth();
        
        gridX = (width - columns * cellSize) / 2;
        gridY = (height - rows * cellSize) / 2;

        // Wipe the window clean.
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        
        // Draw each grid cell.
        
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
            {
                // Draw a dark gray box around the cell.
                
                g.setColor (new Color(32, 32, 32));
                g.drawRect(gridX + column * cellSize, gridY + row * cellSize, cellSize+1, cellSize+1);
                
                // Draw a rounded yellowish cell if it is alive.
                
                if (grid.isAlive(row, column))
                {
                    g.setColor (new Color(255, 255, 224));
                    g.fillRoundRect(gridX + column * cellSize + 1, gridY + row * cellSize + 1, cellSize-1, cellSize-1, cellSize/2, cellSize/2);
                }
            }
    }
    
    /**
     * This method is called when one of the three
     * buttons are pressed (because we registered this
     * object as a listener).  It determines which button
     * was pressed, and acts accordingly.
     * 
     * It is also called when the timer triggers an action
     * event.  In this case, step the animation one generation.
     * 
     * @param event
     *             The action event that triggered the method call
     */
    public void actionPerformed (ActionEvent event)
    {
        Object source = event.getSource();
        
        // If the source of the event is the Timer, the
        //   simulation is running.  Step one frame.
        
        if (source == animationTimer)
        {
            grid.stepOneGeneration();
            repaint();
            return;  // We've handled this event - exit.
        }
        
        // Act upon the buttons.
        
        if (source == clearButton)
        {
            grid.clear();
            repaint();
        }
        else if (source == stepButton)
        {
            grid.stepOneGeneration();
            repaint();
        }
        else if (source == animateOrStopButton)
        {
            if (animationTimer.isRunning())  // Running, user clicked 'stop'
            {
                animationTimer.stop();
                animateOrStopButton.setText("Animate");                
            }
            else  // Not running, user clicked 'animate'
            {
                animationTimer.start();
                animateOrStopButton.setText("Stop");                
            }
        }
    }

    /**
     * Because I registered this object as a listener
     * to mouse events, this method will be called
     * whenever the mouse button is pushed down.
     * It records the row and column number (in the grid) 
     * of the mouse press.  It then toggles the
     * grid state for this location.
     * 
     * @param event
     *             the mouse event that triggered this method call
     */
    public void mousePressed (MouseEvent event)
    {
        // Calculate the grid coordinate from the mouse coordinate.
        
        int column = (event.getX() - gridX) / cellSize;
        int row    = (event.getY() - gridY) / cellSize;

        // If in bounds, invert the cell state.  (Notice the 'not' operation
        //   below.)
        
        if (row >= 0    && row < grid.getHeight() &&
            column >= 0 && column < grid.getWidth())
        {
            lastLivingOrDeadUserChange = !grid.isAlive(row, column);
            grid.setCellState(row, column, lastLivingOrDeadUserChange);
            repaint();
        }
    }

    /**
     * Because I registered this object as a listener
     * to mouse motion events, this method will be called
     * whenever the mouse is moved with the button pushed down.
     * It records the row and column number  (in the grid) 
     * of the mouse press.  It then sets the same grid
     * cell state that was set in mousePressed.
     * 
     * @param event
     *             the mouse event that triggered this method call
     */
    public void mouseDragged (MouseEvent event)
    {
        // Calculate the grid coordinate from the mouse coordinate.
        
        int column = (event.getX() - gridX) / cellSize;
        int row    = (event.getY() - gridY) / cellSize;

        // If in bounds, set the cell to the same state that
        //   was computed when the mouse was pressed (above).
        
        if (row >= 0    && row < grid.getHeight() &&
            column >= 0 && column < grid.getWidth())
        {
            grid.setCellState(row, column, lastLivingOrDeadUserChange);
            repaint();
        }
        
    }
    
    // Unused event handlers - must be 'implemented' because
    //   they are part of the interfaces.  Empty implementations below.
    
    public void mouseReleased (MouseEvent arg0) {}
    public void mouseClicked (MouseEvent arg0)  {}
    public void mouseEntered (MouseEvent arg0)  {}
    public void mouseExited (MouseEvent arg0)   {}
    public void mouseMoved (MouseEvent arg0)    {}
}
