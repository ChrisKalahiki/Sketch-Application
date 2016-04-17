import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Chris Kalahiki
 * @version 1.0
 * @since 2/12/16
 *
 * Program allows user to sketch a picture and save as a .png file
 */
public class Sketch {
	/**Method creates the interface used to sketch.*/
	public static void main(String[] args){
		JFrame frame = new JFrame();  //Declares Frame used for interface
		
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		
		final Canvas canvas = new Canvas();
		
		
		container.add(canvas, BorderLayout.CENTER);
		
		/**Sets dimensions of GUI.*/
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(80, 100));
		panel.setMinimumSize(new Dimension(80, 100));
		panel.setMaximumSize(new Dimension(80, 100));
		
		/**Button used to save image.*/
		JButton sButton = new JButton("Save");
		sButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.save();
			}
		});
		
		/**Button used to clear canvas.*/
		JButton cButton = new JButton("Clear");
		cButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.clear();
			}
		});
		
		/**Changes color to black.*/
		JButton blackButton = new JButton("Black");
		blackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.black();
			}
		});
		
		/**Changes color to red.*/
		JButton redButton = new JButton("Red");
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.red();
			}
		});
		
		/**Changes color to blue.*/
		JButton blueButton = new JButton("Blue");
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.blue();
			}
		});
		
		/**Changes color to yellow.*/
		JButton yellowButton = new JButton("Yellow");
		yellowButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.yellow();
			}
		});
		
		/**Changes color to green.*/
		JButton greenButton = new JButton("Green");
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.green();
			}
		});
		
		/**Sets size of buttons.*/
		sButton.setPreferredSize(new Dimension(80, 20));
		cButton.setPreferredSize(new Dimension(80, 20));
		blackButton.setPreferredSize(new Dimension(80, 20));
		redButton.setPreferredSize(new Dimension(80, 20));
		blueButton.setPreferredSize(new Dimension(80, 20));
		yellowButton.setPreferredSize(new Dimension(80, 20));
		greenButton.setPreferredSize(new Dimension(80, 20));
		
		/**Adds buttons to panel.*/
		panel.add(sButton);
		panel.add(cButton);
		panel.add(blackButton);
		panel.add(redButton);
		panel.add(blueButton);
		panel.add(yellowButton);
		panel.add(greenButton);
		
		container.add(panel, BorderLayout.WEST);
		
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
