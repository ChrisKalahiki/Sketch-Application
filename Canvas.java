import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Chris Kalahiki
 * Contains all methods used in the Sketch class.
 */
@SuppressWarnings("serial")
public class Canvas extends JComponent{
	BufferedImage image;
	Graphics2D graphics2D;
	int x1, x2, y1, y2;
	JPanel dPanel;
	
	public Canvas(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
				graphics2D.drawLine(x1, y1, x2, y2);
				repaint();
				x1 = x2;
				y1 = y2;
			}
		});
	}
	
	/**Method to save the image made in the Sketch program*/
	public void save(){		
		JFileChooser fileChooser = new JFileChooser();
		Component mainWindow = new JFrame();
		fileChooser.showSaveDialog(mainWindow);            //Opens save dialog box
		
		String fileName = "" + fileChooser.getSelectedFile();
		
		try {
            ImageIO.write(image, "png", new File(fileName));
        } 
		catch (IOException e) {
            System.out.println("Error");
		}
    }
	
	/**Method to clear the canvas*/
	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
	/**Method that makes drawing on the canvas possible*/
	public void paintComponent(Graphics g){
		if(image == null){
			image = (BufferedImage) createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}
	
	/**
	 * The following methods are used to change the color with which the user will create his or her masterpiece.
	 */
	public void black(){
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
	public void red(){
		graphics2D.setPaint(Color.red);
		repaint();
	}
	
	public void blue(){
		graphics2D.setPaint(Color.blue);
		repaint();
	}
	
	public void yellow(){
		graphics2D.setPaint(Color.yellow);
		repaint();
	}
	
	public void green(){
		graphics2D.setPaint(Color.green);
		repaint();
	}
}