import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;

// @Author - Desirae Webster

//This class will allow images to be uploaded to our P2 viewer. 
//Designed this class specifically so that we could upload our shoe image to the code
//so that we could overlay our polygons on to the image. 

public class P3Component extends JComponent {
	BufferedImage img;

	public P3Component() {
		super();
		importImage();
		// TODO Auto-generated constructor stub
	}
// Code created a bufferedImage that is called img 
// then reach into file system to retrieve the image that you want to upload to the P2 viewer 
	public void importImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("ENGD250 Ethiopian App Project/Images/ShoeTemplate.png"));
		} catch (IOException e) {
			System.out.println("Couldnt read image");
		}
		this.img = img;

	}
//paints the image,creates bounds on the image and draws the image 
	protected void paintComponent(Graphics g2) {
		// Asks the superclass to do its work
		super.paintComponent(g2);
		this.setBounds(0, 0, 800, 800);
		g2.drawImage(img, 0, 0, this);
//		System.out.println("Painting");

//		Graphics2D graphics2 = (Graphics2D) g;
		
	}
}
