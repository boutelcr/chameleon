import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


// @Author -- Sage Dooley, Caleb Boutell

public class P2ColorChooser implements ChangeListener{

	JFrame window;
	JColorChooser colorChooser;
	JPanel pan;
	JPanel colorPan;
	
	public static void main(String[] thing) {
		
		new P2ColorChooser();
		
	}
	
	public P2ColorChooser() {
		
//		window = new JFrame();
//		window.setSize(900, 700);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.getContentPane().setBackground(Color.GRAY);;
//		window.setLayout(null);
//		
//		pan = new JPanel();
//		pan.setBounds(100, 50, 625, 250);
//		pan.setBackground(Color.GREEN);
//		window.add(pan);
//		
		colorChooser = new JColorChooser();
		colorChooser.getSelectionModel().addChangeListener(this);
		
//		// How to remove the preview of panels
		colorChooser.setPreviewPanel(new JPanel());
//		
//		// The panels are numbered from 0 to 4. This will select what panels we can interact with.
//		// They are labeled as what panel contains what type of chooser.
		colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[4]); // CMYK
		colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[3]); // RGB
//		colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[2]); // HSL
		colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[1]); // HSV
//		colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[0]); // Swatch
		
//		pan.add(colorChooser);
		
		// This demo is a demonstration of how we can change the color of a panel with the choosers.
//		colorPan = new JPanel();
//		colorPan.setBounds(200, 420, 400, 100);
//		colorPan.setBackground(Color.WHITE);
//		window.add(colorPan);		
//		
//		window.setVisible(true);
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// Auto-generated method stub
		Color newColor = colorChooser.getColor();
//		System.out.println(colorChooser.getColor());
//		colorPan.setBackground(newColor);
	}
	
	public Color getColor() {
		return colorChooser.getColor();
	}
	
	public JColorChooser getColorChooser() {
		return colorChooser;
	}

}
