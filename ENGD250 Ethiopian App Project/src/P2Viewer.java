import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

// @Authors - Caleb Boutell, Sophie Baer, Sage Dooley, Desirae Webster

//P2 viewer is where all of our components that we created our shown in Java Graphics
//this class displays the shoe image as well as the polygons that were created to display 
//onto our constructed JFrame

public class P2Viewer {
//Creates the frames that our images and polygons will sit 
	
	
	JFrame frame = new JFrame();
	P2Component component = new P2Component();
	
	public P2Viewer() {
		
		frame = new JFrame();
		int frameWidth = 1000;
		int frameHeight = 700;
		

		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("Click the shapes");

//		How the different components were added to the frame 
		P3Component component3 = new P3Component();
		JColorChooser colorComponent = component.getColorChooser();
		SavePanel savePanel = new SavePanel(this, component);

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
	
	public P2Component getWorkSpace() {
		return this.component;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void killFrame() {
		frame.dispose();
	}
	
}
