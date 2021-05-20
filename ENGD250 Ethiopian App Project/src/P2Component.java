import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JComponent;

 // @Authors -- Caleb Boutell, Sophie Baer, Sage Dooley 

public class P2Component extends JComponent {

	// This canvas is where all colorable shapes lie and overlaps with the image

	ArrayList<P2Shape> adams = new ArrayList<P2Shape>(); 					//list of colorable polygons
	ArrayList<Point2D> newAdamNodes = new ArrayList<Point2D>();				//temp list of nodes to draw a new adam
	JColorChooser myColorChooser = new P2ColorChooser().getColorChooser();	//access to the color chooser
	ArrayList<Ellipse2D> guidePoints = new ArrayList<Ellipse2D>();			//graphical indicators to show the user what their new shape will look like
	
	public P2Component() {
		super();
		
		P2MouseHandler mousehandler = new P2MouseHandler();
		addMouseListener(mousehandler);
		addMouseMotionListener(mousehandler);
		
		adams.add(new P2Shape(128, 131, 0)); // this item is a size zero shape hidden underneath a line that exists to cover a small graphical glitch
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 

		// iterates through each shape (called Adams) to draw it with the correct polygon and color
		for (P2Shape adam : adams) {
			Graphics2D graphics2 = (Graphics2D) g;
			graphics2.setStroke(new BasicStroke(2));
			graphics2.setColor(adam.getColor());

			graphics2.draw(adam.getBody());
			graphics2.fill(adam.getBody());

			graphics2.setColor(new Color(0,0,0));
			for (Ellipse2D guidePoint : guidePoints) {
				graphics2.draw(guidePoint);
			}
		} 		
	}

	public void drawNewAdam(Point2D point, Boolean stillDrawing) {
		if (stillDrawing) {
			newAdamNodes.add(point); //adds a new node to the list for a new polygon
			guidePoints.add(new Ellipse2D.Double(point.getX(),point.getY(),2,2)); //creates a visible to dot to show the user where their point has been placed
			P2Component.this.repaint(); //refreshes to show all changes
		} else {
			adams.add(new P2Shape(newAdamNodes)); //creates the new polygon 
			newAdamNodes.clear(); //resets lists
			guidePoints.clear();
			P2Component.this.repaint();
		}
	}
	
	public P2Shape inShape(Point2D point) { //returns the top polygon underneath a given point, this is used for when the user clicks
		P2Shape topAdam = null;
		for (P2Shape adam : adams) {
			if (adam.getBody().contains(point.getX(), point.getY())) {
				topAdam = adam;
			}
		}			
		return topAdam;
	}
	
	public void saveAdams(String fileName) { //iterates through and saves each adam to a given file
		for (P2Shape adam : adams) {
			System.out.println("saved to file");
			FileWrite.writeFile(adam.getData(), (fileName + ".txt"));
		}
	}
	
	public void loadAdams(String fileName) { //iterates through and loads each adam to a given file
		System.out.println("Loading old adams");
		for (P2Shape adam : P2Shape.polyRead(Filereader.readFile(fileName + ".txt"))) {
			adams.add(adam);
			P2Component.this.repaint();
		}
	}
	
	public void clearSave(String fileName) { //clears a given file
		System.out.println("Clearing save data");
		FileWrite.clearFile(fileName + ".txt");
	}
	
	public JColorChooser getColorChooser() { //simple getter for the viewer
		return myColorChooser;
	}

	public class P2MouseHandler implements MouseMotionListener, MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			P2Shape inShape = P2Component.this.inShape(e.getPoint()); //finds if the user has clicked a shape
			if (inShape != null) { //if the user actually clicked on a shape
				if (e.getButton() == MouseEvent.BUTTON1) { //left click
					System.out.println("womp");
					inShape.setColor(myColorChooser.getColor()); //colors the shape

					P2Component.this.repaint();

				} else { //right click
					//no longer has any function; formerly used for testing
				}
			} else {
				if (e.getButton() == MouseEvent.BUTTON1) { //left click
					System.out.println("pwop");
					drawNewAdam(e.getPoint(), true); //adds a node for shape creation
				} else { //right click
					drawNewAdam(e.getPoint(), false); //finishes the shape
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// nothing to do
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// nothing to do
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// nothing to do
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// nothing to do
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// nothing to do
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// nothing to do
		}
	}

}
