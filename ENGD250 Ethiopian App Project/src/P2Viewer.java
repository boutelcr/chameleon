import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

// @Authors - Caleb Boutell, Sophie Baer, Sage Dooley

public class P2Viewer {
	
	public P2Viewer() {
		
		JFrame frame = new JFrame();
		int frameWidth = 1000;
		int frameHeight = 700;
		

		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("Click the shapes");

		P2Component component = new P2Component();
		P3Component component3 = new P3Component();
		JColorChooser colorComponent = component.getColorChooser();
		SavePanel savePanel = new SavePanel(component);

		frame.getContentPane().add(component3,BorderLayout.NORTH);
		frame.getContentPane().add(component,BorderLayout.CENTER);
		frame.getContentPane().add(colorComponent, BorderLayout.SOUTH);
		frame.getContentPane().add(savePanel, BorderLayout.EAST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new P2Viewer();
	}
	
}
