package lab14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;

public class MouseDrawPanel extends JPanel implements MouseMotionListener,MouseListener {

	private static final long serialVersionUID = 1L;
	
	private int prevX;
	private int prevY;
	
	
	public MouseDrawPanel() {
		addMouseMotionListener(this);
	}

	//
	// The MouseMoveListener methods
	//
	public void mouseMoved(MouseEvent e) {		
		System.out.println("mouse moved" 
				+ " (" + e.getX() + "," + e.getY() + ")"
				+ " detected on "
				+ e.getComponent().getClass().getName());

	}

	public void mouseDragged(MouseEvent e) {
		System.out.println("mouse dragged" 
				+ " (" + e.getX() + "," + e.getY() + ")"
				+ " detected on "
				+ e.getComponent().getClass().getName());
		Graphics g = getGraphics();
		int x = e.getX();
		int y = e.getY();
		g.setColor(Color.black);
		g.drawLine(prevX, prevY, x, y);
		prevX = x;
		prevY = y;
	}

	/***
	 * Setup a simple application in main by making a JFrame and adding this panel to it
	 * @param args
	 */
	public static void main(String[] args) {
		// Setup a simple JFrame and add this custom panel to it
        JFrame frame = new JFrame("Simple Sketching Program");
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			e.printStackTrace();
		}
        frame.getContentPane().add(new MouseDrawPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
