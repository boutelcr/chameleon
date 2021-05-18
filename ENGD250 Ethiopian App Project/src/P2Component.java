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

	// The component of Prototype 2 of our concept

	ArrayList<P2Shape> adams = new ArrayList<P2Shape>();
	ArrayList<Point2D> newAdamNodes = new ArrayList<Point2D>();
	JColorChooser myColorChooser = new P2ColorChooser().getColorChooser();
	ArrayList<Ellipse2D> guidePoints = new ArrayList<Ellipse2D>();
	
	public P2Component() {
		super();
		
		P2MouseHandler mousehandler = new P2MouseHandler();
		addMouseListener(mousehandler);
		addMouseMotionListener(mousehandler);
		
		adams.add(new P2Shape(128, 131, 0)); // <----saucy Adam
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// Asks the superclass to do its work
		super.paintComponent(g);

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
			newAdamNodes.add(point);
			guidePoints.add(new Ellipse2D.Double(point.getX(),point.getY(),2,2));
			P2Component.this.repaint();
		} else {
			adams.add(new P2Shape(newAdamNodes));
			newAdamNodes.clear();
			guidePoints.clear();
			P2Component.this.repaint();
		}
	}
	
	public P2Shape inShape(Point2D point) {
		P2Shape topAdam = null;
		for (P2Shape adam : adams) {
			if (adam.getBody().contains(point.getX(), point.getY())) {
				topAdam = adam;
			}
		}			
		return topAdam;
	}
	
	public void saveAdams(String fileName) {
		for (P2Shape adam : adams) {
			System.out.println("saved to file");
			FileWrite.writeFile(adam.getData(), (fileName + ".txt"));
		}
	}
	
	public void loadAdams(String fileName) {
		System.out.println("Loading old adams");
		for (P2Shape adam : P2Shape.polyRead(Filereader.readFile(fileName + ".txt"))) {
			adams.add(adam);
			P2Component.this.repaint();
		}
	}
	
	public void clearSave(String fileName) {
		System.out.println("Clearing save data");
		FileWrite.clearFile(fileName + ".txt");
	}
	
	public JColorChooser getColorChooser() {
		return myColorChooser;
	}

	public class P2MouseHandler implements MouseMotionListener, MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			P2Shape inShape = P2Component.this.inShape(e.getPoint());
			if (inShape != null) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("womp");
					inShape.setColor(myColorChooser.getColor());

					P2Component.this.repaint();

				} else {
					System.out.println("saved to file");
					FileWrite.writeFile(inShape.getData(), "polyInfo.txt");
				}
			} else {
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("pwop");
					drawNewAdam(e.getPoint(), true);
				} else {
					drawNewAdam(e.getPoint(), false);
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
