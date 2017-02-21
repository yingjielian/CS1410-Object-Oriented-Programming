package lab01;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This application is just a fun demo.  It opens a window,
 * displays a greeting, and then decomposes the greeting
 * into a bunch of 'worms', which traverse the screen.  This
 * demo has no useful purpose beyond that.  (Students may
 * find the code interesting later in the semester.)
 * <p>
 *
 * The application class opens the window, creates the worms,
 * and starts the animation thread.  When the user closes the
 * window the application dies.
 *
 * @author Peter Jensen
 * @version January 09, 2017
 */
public class FunDemo extends JPanel
{
    // Constants.
    
    final static public String greeting = "Welcome to China";
    
    // Instance variables.
    
    private ArrayList<Worm> worms;
    
    /**
     * The application entry point.
     */
    public static void main (String[] args) throws Exception
    {
        // Let the constructor do all the work, but make sure
	//  to invoke it using the GUI thread.

	javax.swing.SwingUtilities.invokeAndWait(new Runnable()
	    {
		public void run()
		{		    
		    new FunDemo();
		}
	    });
    }
    
    /**
     * My window constructor.  Creates and displays the frame, the worms, and
     * the animator object.
     */
    private FunDemo()
    {
        // Create the worms.
        
        makeWorms();
       
        // Build the application window.
        
        JFrame frame = new JFrame("CP SC 1410 - Lab #1 Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        this.setMinimumSize(new Dimension(500, 500));
        this.setPreferredSize(new Dimension(500, 500));
        frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	

        // Create the thread.  Note: Synchronization issue - if the user
        //   somehow manages to close the window before these calls, the
        //   thread won't properly die.  To be fixed later.
        
        WormAnimator animator = new WormAnimator(frame, worms, 10000, 50);
        frame.addWindowListener(animator);
        
        // Done.  The application should be running smoothly.
    }

    /**
     * Create the worms initially to spell out a greeting.
     *
     */
    private void makeWorms ()
    {
        // Create the list.
        
        worms = new ArrayList<Worm>();
        
        // Create a BufferedImage with the message in it.
        
        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        
        g.setColor(Color.WHITE);
        g.drawString(greeting, 0, 100);
        
        // Compute the position and size of the message.
        
        int messageWidth = g.getFontMetrics().stringWidth(greeting);
        int messageHeight = g.getFontMetrics().getHeight();
        int messageX = 0;
        int messageY = 100 - g.getFontMetrics().getAscent();
        int leftMargin = (500 - messageWidth) / 2;
        int topMargin = (500 - messageHeight) / 2;
        
        // Extract the pixels, make one worm per white pixel.
        
        for (int x = 0; x < messageWidth; x++)
            for (int y = 0; y < messageHeight; y++)
                if ((image.getRGB(x + messageX, y + messageY) & 0x00808080) != 0)
                    worms.add(new Worm(x + leftMargin, y + topMargin));
        
        // Done making worms.
    }
    
    /**
     * This paint method is automatically called when the application
     * needs to be redrawn to the screen.  This method simply draws all the worms
     * to a black background.
     */
    public void paintComponent(Graphics g)
    {
        int width = this.getWidth();
        int height = this.getHeight();
        
        // Wipe the background.
        
        g.setColor (Color.BLACK);
        g.fillRect(0, 0, width, height);
        
        // Draw the worms.
        
        for (Worm w : worms)
            w.draw(g);
    }
}

/**
 * This class pauses, then animates a group of worms
 * continuously until the enclosing frame is closed.
 *
 *
 * @author Peter Jensen
 * @version January 09, 2017
 */
class WormAnimator implements WindowListener, Runnable {
    // Instance variables.
    
    private int initialDelay;  // In milliseconds.
    private int frameDelay; // In milliseconds.

    private boolean stop; 
    
    private ArrayList<Worm> worms;
    private JFrame frame;
    
    /**
     * Creates and starts the worm animator.  The animation will pause
     * for an initial delay, and then animate the worms every 
     * frameDelay milliseconds.
     * 
     * @param frame
     *             The window containing the worms
     * @param worms
     *             The objects to animate
     * @param initialDelay
     *                    An initial pause length
     * @param frameDelay
     *                  The time between animation updates
     */
    WormAnimator (JFrame frame, ArrayList<Worm> worms, int initialDelay, int
frameDelay)
    {
        // Save the parameter values.
        
        this.frame = frame;
        this.worms = worms;
        this.initialDelay = initialDelay;
        this.frameDelay = frameDelay;
        
        // Start the thread.
        
        this.stop = false;
        new Thread(this).start();
    }
    
    
    public void run ()
    {
	System.out.println (FunDemo.greeting);
	
        // Pause for an initial period.
        
        try
        {
            long startTime = System.currentTimeMillis();
            long currentTime = System.currentTimeMillis();
            while (!stop && currentTime - startTime < initialDelay)
            {
                Thread.sleep(Math.min(20, initialDelay - (currentTime - startTime)));
                currentTime = System.currentTimeMillis();
            }
        }
        catch (InterruptedException e)
        {
            // For now, just ignore this exception.
        }

	System.out.println("Consider city populations.  The most significant digit in city populations is six times more likely to be a 1 than a 9.  (See Benford's law.)");
        
        // Animation loop - animate, then pause for the remainder of the time.

        long startTime = System.currentTimeMillis();
        while (!stop)
        {            
            try
            {
                // Delay.
                
                long currentTime = System.currentTimeMillis();
                
                if (frameDelay - (currentTime - startTime) > 0)
                    Thread.sleep(frameDelay - (currentTime - startTime));

                // Advance logical time independent of actual time to smooth animation. 
                
                startTime += frameDelay;
                if (currentTime - startTime > frameDelay)
                    startTime = currentTime - frameDelay;
                
                // Update animation.
                
                for (Worm w : worms)
                    w.advance();
                
                frame.repaint();
                
            }
            catch (InterruptedException e)
            {
                // For now, just ignore this exception.
            }
        }
        
        // Done.
    }
    
    
    /* Window events. */ 
    
    public void windowClosing (WindowEvent arg0)
    {
        // Stop the thread.
        
        stop = true;
    }

    public void windowOpened (WindowEvent arg0){}
    public void windowClosed (WindowEvent arg0){}
    public void windowIconified (WindowEvent arg0){}
    public void windowDeiconified (WindowEvent arg0){}
    public void windowActivated (WindowEvent arg0){}
    public void windowDeactivated (WindowEvent arg0){} }

/**
 * Objects of this class represent a single animating worm.
 *
 * @author Peter Jensen
 * @version January 09, 2017
 */
class Worm
{
    // Instance variables.
    
    double initialX, initialY, currentX, currentY;
     
    LinkedList<WormSegment> segments;
    double velocityX, velocityY;
    double red = 1.0;
    double blue = 1.0;
    double green = 1.0;
    
    /**
     * This constructor builds a dot worm, one segment, white in color, with a
     * random heading and small velocity.
     */
    Worm (int x, int y)
    {
        this.segments = new LinkedList<WormSegment> ();
        this.velocityX = Math.random() - 0.5;
        this.velocityY = Math.random() - 0.5;
        this.initialX = x;
        this.initialY = y;
        this.currentX = x;
        this.currentY = y;
        
        segments.add(new WormSegment(x, y, x, y, Color.WHITE));
    }

    /**
     * Makes the worm wander, weighted towards the center of the screen.
     *
     */
    synchronized void advance()
    {
        // Limit to eight segments.
        
        if (segments.size() >= 6)
            segments.removeFirst();
        
        // Semi-randomly adjust velocity, heading, and color.
        
        double shift = (Math.random() - 0.5) * 0.25;
        double min = 0.7;
        switch ((int) (Math.random() * 3))
        {
            case 0:
                red += shift;
                if (red < 0.3) red = min;
                if (red > 1.0) red = 1.0;
                break;
            case 1:
                green += shift;
                if (green < 0.3) green = min;
                if (green > 1.0) green = 1.0;
                break;
            case 2:
                blue += shift;
                if (blue < 0.3) blue = min;
                if (blue > 1.0) blue = 1.0;
                break;
        }
        Color newColor = new Color ((float) red, (float) green, (float) blue);
        
        velocityX += (Math.random() - 0.5) * 0.3;
        velocityY += (Math.random() - 0.5) * 0.3;
        
        double deltaX = initialX - currentX;
        double deltaY = initialY - currentY;
        double distanceFromCenter = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        velocityX += Math.random() * deltaX * Math.sqrt(distanceFromCenter) / 30000;
        velocityY += Math.random() * deltaY * Math.sqrt(distanceFromCenter) / 30000;
        
        // Create a new worm segment.
        
        double nextX = currentX + velocityX;
        double nextY = currentY + velocityY;
        
        segments.add(new WormSegment((int) currentX, (int) currentY, (int) nextX, (int) nextY, newColor));
        
        currentX = nextX;
        currentY = nextY;
    }
    
    /**
     * Draws this worm.
     */
    synchronized void draw (Graphics g)
    {
        for (WormSegment s : segments)
            s.draw(g);
    }
}

/**
 * Objects of this class represent a segment of an animating worm.
 *
 * @author Peter Jensen
 * @version January 09, 2017
 */
class WormSegment
{
    // Instance variables.
    
    int startX, startY, endX, endY;
    Color c;
    
    /**
     * This constructor builds the worm segment.
     */
    WormSegment (int startX, int startY, int endX, int endY, Color c)
    {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.c = c;
    }
    
    /**
     * Draws this segment of the worm.
     */
    void draw (Graphics g)
    {
        g.setColor(c);
        g.drawLine(startX, startY, endX, endY);
    }
}
