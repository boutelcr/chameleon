import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;

// @Author - Desirae Webster

public class P3Component extends JComponent {
	BufferedImage img;

	public P3Component() {
		super();
		importImage();
		// TODO Auto-generated constructor stub
	}

	public void importImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Images/11.PNG"));
		} catch (IOException e) {
			System.out.println("Couldnt read Images/11.PNG");
		}
		this.img = img;

	}

	protected void paintComponent(Graphics g2) {
		// Asks the superclass to do its work
		super.paintComponent(g2);
		this.setBounds(0, 0, 100, 100);
		g2.drawImage(img, 0, 0, this);
		System.out.println("Painting");

//		Graphics2D graphics2 = (Graphics2D) g;
		
	}
}
