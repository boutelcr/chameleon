import java.awt.BorderLayout;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

// @Authors - Caleb Boutell, Sophie Baer, Sage Dooley

public class P2Viewer {
	
	//A viewer for prototype 2 of our concept
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		int frameWidth = 800;
		int frameHeight = 700;
		

		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("Click the shapes");

		P2Component component = new P2Component();
		P3Component component3 = new P3Component();
		JColorChooser colorComponent = component.getColorChooser();

//		frame.add(component);
//		frame.add(component3);
//		frame.add(colorComponent);
		
		frame.getContentPane().add(component3,BorderLayout.NORTH);
		frame.getContentPane().add(component,BorderLayout.CENTER);
		frame.getContentPane().add(colorComponent, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
