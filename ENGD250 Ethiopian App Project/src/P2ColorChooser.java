import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


// @Author -- Sage Dooley, Caleb Boutell

public class P2ColorChooser implements ChangeListener{
	JColorChooser colorChooser;
	
	public static void main(String[] thing) {
		
		new P2ColorChooser();
		
	}
	
	public P2ColorChooser() {

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
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// Auto-generated method stub
		Color newColor = colorChooser.getColor();
	}
	
	public Color getColor() {
		return colorChooser.getColor();
	}
	
	public JColorChooser getColorChooser() {
		return colorChooser;
	}

}
